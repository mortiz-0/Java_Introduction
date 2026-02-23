package uniandes.dpoo.aerolinea.persistencia;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import uniandes.dpoo.aerolinea.exceptions.AeropuertoDuplicadoException;
import uniandes.dpoo.aerolinea.exceptions.InformacionInconsistenteException;
import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Aerolinea;
import uniandes.dpoo.aerolinea.modelo.Avion;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;

public class PersistenciaAerolineaJson implements IPersistenciaAerolinea {
    private static final String CODIGO_RUTA = "codigoRuta";
    private static final String ORIGEN = "origen";
    private static final String DESTINO = "destino";
    private static final String HORA_SALIDA = "horaSalida";
    private static final String HORA_LLEGADA = "horaLlegada";
    private static final String NOMBRE_AEROPUERTO = "nombre";
    private static final String CODIGO_AEROPUERTO = "codigo";
    private static final String NOMBRE_CIUDAD = "nombreCiudad";
    private static final String LATITUD = "latitud";
    private static final String LONGITUD = "longitud";
    private static final String NOMBRE_AVION = "nombreAvion";
    private static final String CAPACIDAD = "capacidad";
    private static final String FECHA = "fecha";

    @Override
    public void cargarAerolinea(String archivo, Aerolinea aerolinea) throws IOException, InformacionInconsistenteException, JSONException, Exception {
        String jsonCompleto = new String(Files.readAllBytes(new File(archivo).toPath()));
        JSONObject raiz = new JSONObject(jsonCompleto);

        cargarRutas(aerolinea, raiz.getJSONArray("rutas"));
        cargarAviones(aerolinea, raiz.getJSONArray("aviones"));
        cargarVuelos(aerolinea, raiz.getJSONArray("vuelos"));
    }

    @Override
    public void salvarAerolinea(String archivo, Aerolinea aerolinea) throws IOException {
        JSONObject jobject = new JSONObject();

        salvarRutas(aerolinea, jobject);
        salvarAviones(aerolinea, jobject);
        salvarVuelos(aerolinea, jobject);

        PrintWriter pw = new PrintWriter(archivo);
        jobject.write(pw, 2, 0);
        pw.close();
    }

    private void cargarRutas(Aerolinea aerolinea, JSONArray jRutas) throws InformacionInconsistenteException {
        // Cache para reutilizar aeropuertos con el mismo código
        java.util.Map<String, Aeropuerto> aeropuertosCache = new java.util.HashMap<>();

        int numRutas = jRutas.length();
        for(int i = 0; i < numRutas; i++) {
            JSONObject ruta = jRutas.getJSONObject(i);
            String codigoRuta = ruta.getString(CODIGO_RUTA);

            JSONObject jOrigen = ruta.getJSONObject(ORIGEN);
            JSONObject jDestino = ruta.getJSONObject(DESTINO);

            try {
                // Obtener o crear aeropuerto de origen
                String codigoOrigen = jOrigen.getString(CODIGO_AEROPUERTO);
                Aeropuerto origen = aeropuertosCache.get(codigoOrigen);
                if(origen == null) {
                    origen = new Aeropuerto(
                        jOrigen.getString(NOMBRE_AEROPUERTO),
                        codigoOrigen,
                        jOrigen.getString(NOMBRE_CIUDAD),
                        jOrigen.getDouble(LATITUD),
                        jOrigen.getDouble(LONGITUD)
                    );
                    aeropuertosCache.put(codigoOrigen, origen);
                }

                // Obtener o crear aeropuerto de destino
                String codigoDestino = jDestino.getString(CODIGO_AEROPUERTO);
                Aeropuerto destino = aeropuertosCache.get(codigoDestino);
                if(destino == null) {
                    destino = new Aeropuerto(
                        jDestino.getString(NOMBRE_AEROPUERTO),
                        codigoDestino,
                        jDestino.getString(NOMBRE_CIUDAD),
                        jDestino.getDouble(LATITUD),
                        jDestino.getDouble(LONGITUD)
                    );
                    aeropuertosCache.put(codigoDestino, destino);
                }

                String horaSalida = ruta.getString(HORA_SALIDA);
                String horaLlegada = ruta.getString(HORA_LLEGADA);

                Ruta nuevaRuta = new Ruta(origen, destino, horaSalida, horaLlegada, codigoRuta);
                aerolinea.agregarRuta(nuevaRuta);
            } catch(AeropuertoDuplicadoException e) {
                throw new InformacionInconsistenteException("Aeropuerto duplicado: " + e.getMessage());
            }
        }
    }

    private void cargarAviones(Aerolinea aerolinea, JSONArray jAviones) throws InformacionInconsistenteException {
        int numAviones = jAviones.length();
        for(int i = 0; i < numAviones; i++) {
            JSONObject avion = jAviones.getJSONObject(i);
            String nombreAvion = avion.getString(NOMBRE_AVION);
            int capacidad = avion.getInt(CAPACIDAD);

            Avion nuevoAvion = new Avion(nombreAvion, capacidad);
            aerolinea.agregarAvion(nuevoAvion);
        }
    }

    private void cargarVuelos(Aerolinea aerolinea, JSONArray jVuelos) throws Exception {
        int numVuelos = jVuelos.length();
        for(int i = 0; i < numVuelos; i++) {
            JSONObject vuelo = jVuelos.getJSONObject(i);
            String codigoRuta = vuelo.getString(CODIGO_RUTA);
            String fecha = vuelo.getString(FECHA);
            String nombreAvion = vuelo.getString(NOMBRE_AVION);

            Ruta ruta = aerolinea.getRuta(codigoRuta);
            if(ruta == null)
                throw new InformacionInconsistenteException("Ruta no encontrada: " + codigoRuta);

            Avion avion = null;
            for(Avion a : aerolinea.getAviones()) {
                if(a.getNombre().equals(nombreAvion)) {
                    avion = a;
                    break;
                }
            }
            if(avion == null)
                throw new InformacionInconsistenteException("Avión no encontrado: " + nombreAvion);

            aerolinea.programarVuelo(fecha, codigoRuta, nombreAvion);
        }
    }

    private void salvarRutas(Aerolinea aerolinea, JSONObject jobject) {
        JSONArray jRutas = new JSONArray();
        for(Ruta ruta : aerolinea.getRutas()) {
            JSONObject jRuta = new JSONObject();
            jRuta.put(CODIGO_RUTA, ruta.getCodigoRuta());

            JSONObject jOrigen = new JSONObject();
            jOrigen.put(NOMBRE_AEROPUERTO, ruta.getOrigen().getNombre());
            jOrigen.put(CODIGO_AEROPUERTO, ruta.getOrigen().getCodigo());
            jOrigen.put(NOMBRE_CIUDAD, ruta.getOrigen().getNombreCiudad());
            jOrigen.put(LATITUD, ruta.getOrigen().getLatitud());
            jOrigen.put(LONGITUD, ruta.getOrigen().getLongitud());
            jRuta.put(ORIGEN, jOrigen);

            JSONObject jDestino = new JSONObject();
            jDestino.put(NOMBRE_AEROPUERTO, ruta.getDestino().getNombre());
            jDestino.put(CODIGO_AEROPUERTO, ruta.getDestino().getCodigo());
            jDestino.put(NOMBRE_CIUDAD, ruta.getDestino().getNombreCiudad());
            jDestino.put(LATITUD, ruta.getDestino().getLatitud());
            jDestino.put(LONGITUD, ruta.getDestino().getLongitud());
            jRuta.put(DESTINO, jDestino);

            jRuta.put(HORA_SALIDA, ruta.getHoraSalida());
            jRuta.put(HORA_LLEGADA, ruta.getHoraLlegada());

            jRutas.put(jRuta);
        }
        jobject.put("rutas", jRutas);
    }

    private void salvarAviones(Aerolinea aerolinea, JSONObject jobject) {
        JSONArray jAviones = new JSONArray();
        for(Avion avion : aerolinea.getAviones()) {
            JSONObject jAvion = new JSONObject();
            jAvion.put(NOMBRE_AVION, avion.getNombre());
            jAvion.put(CAPACIDAD, avion.getCapacidad());

            jAviones.put(jAvion);
        }
        jobject.put("aviones", jAviones);
    }

    private void salvarVuelos(Aerolinea aerolinea, JSONObject jobject) {
        JSONArray jVuelos = new JSONArray();
        for(Vuelo vuelo : aerolinea.getVuelos()) {
            JSONObject jVuelo = new JSONObject();
            jVuelo.put(CODIGO_RUTA, vuelo.getRuta().getCodigoRuta());
            jVuelo.put(FECHA, vuelo.getFecha());
            jVuelo.put(NOMBRE_AVION, vuelo.getAvion().getNombre());

            jVuelos.put(jVuelo);
        }
        jobject.put("vuelos", jVuelos);
    }
}
