package uniandes.dpoo.aerolinea.tests;

import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import uniandes.dpoo.aerolinea.consola.ConsolaAerolinea;
import uniandes.dpoo.aerolinea.exceptions.InformacionInconsistenteException;
import uniandes.dpoo.aerolinea.exceptions.VueloSobrevendidoException;
import uniandes.dpoo.aerolinea.modelo.Aerolinea;
import uniandes.dpoo.aerolinea.persistencia.CentralPersistencia;
import uniandes.dpoo.aerolinea.persistencia.TipoInvalidoException;

public class AeropuertoTest {
	public AeropuertoTest(){
	}
	@BeforeAll
	public static void setUp() {
		try {
		ConsolaAerolinea.main(new String[0]);
		}
		catch(Exception e){
			throw e;
		}
	}
	@Test
	void testCodigoUnico() {
		//Verifica que se lance una excepción si se crea un aeropuerto con un código que ya existía
	}
	@Test
	void testCalcularDistanciaAlCentro() {
		//Verifica que se calcule correctamente la distancia hasta las coordenadas 0,0
	}
	@Test
	void testCalcularDistanciaEntreParejasOpuestas() {
	//Verifica que se calcule correctamente la distancia entre aeropuertos que están en cuadrantes opuestos
	}
	@Test
	void testCalcularDistanciaEntreParejas() {
	//Verifica que se calcule correctamente la distancia entre aeropuertos que están en cuadrantes adyacentes.
	}
	@Test
	void testCalcularDistanciaMismoAeropuerto() {
	//Verifica que se calcule correctamente la distancia entre el mismo aeropuerto
	}
    /**
     * Test 1: Prueba la carga de información de aerolínea desde JSON
     */
    public void testCargarAerolineaJSON(Aerolinea unaAerolinea) throws Exception
    {
        System.out.println("--- TEST 1: Cargar Aerolínea desde JSON ---");
        String archivo = "./datos/aerolinea.json";

        unaAerolinea.cargarAerolinea(archivo, CentralPersistencia.JSON);

        System.out.println("✓ Aerolínea cargada correctamente");
        System.out.println("  - Rutas cargadas: " + unaAerolinea.getRutas().size());
        System.out.println("  - Aviones cargados: " + unaAerolinea.getAviones().size());
        System.out.println("  - Vuelos cargados: " + unaAerolinea.getVuelos().size());
        System.out.println();
    }

    /**
     * Test 2: Prueba la carga de tiquetes desde JSON
     */
    public void testCargarTiquetesJSON(Aerolinea unaAerolinea) throws TipoInvalidoException, IOException, InformacionInconsistenteException
    {
        System.out.println("--- TEST 2: Cargar Tiquetes desde JSON ---");
        String archivo = "./datos/tiquetes.json";

        unaAerolinea.cargarTiquetes(archivo, CentralPersistencia.JSON);

        System.out.println("OK Tiquetes y clientes cargados correctamente");
        System.out.println("  - Clientes cargados: " + unaAerolinea.getClientes().size());
        System.out.println("  - Tiquetes cargados: " + unaAerolinea.getTiquetes().size());
        System.out.println();
    }

    /**
     * Test 3: Prueba programar un nuevo vuelo
     */
    public void testProgramarVuelo(Aerolinea unaAerolinea) throws Exception
    {
        System.out.println("--- TEST 3: Programar Vuelo ---");
        String fecha = "2024-12-10";
        String codigoRuta = "4559";
        String nombreAvion = "Airbus A320";

        int vuelosAntes = unaAerolinea.getVuelos().size();
        unaAerolinea.programarVuelo(fecha, codigoRuta, nombreAvion);
        int vuelosDespues = unaAerolinea.getVuelos().size();

        System.out.println("✓ Vuelo programado correctamente");
        System.out.println("  - Vuelos antes: " + vuelosAntes);
        System.out.println("  - Vuelos después: " + vuelosDespues);
        System.out.println("  - Ruta: " + codigoRuta + ", Fecha: " + fecha + ", Avión: " + nombreAvion);
        System.out.println();
    }

    /**
     * Test 4: Prueba vender tiquetes
     */
    public void testVenderTiquetes(Aerolinea unaAerolinea) throws VueloSobrevendidoException, Exception
    {
        System.out.println("--- TEST 4: Vender Tiquetes ---");
        String identificadorCliente = "Charlie";
        String fecha = "2024-12-10";
        String codigoRuta = "4559";
        int cantidad = 2;

        int tiquetesAntes = unaAerolinea.getTiquetes().size();
        int valorTotal = unaAerolinea.venderTiquetes(identificadorCliente, fecha, codigoRuta, cantidad);
        int tiquetesDespues = unaAerolinea.getTiquetes().size();

        System.out.println("✓ Tiquetes vendidos correctamente");
        System.out.println("  - Cliente: " + identificadorCliente);
        System.out.println("  - Cantidad: " + cantidad);
        System.out.println("  - Valor total: $" + valorTotal);
        System.out.println("  - Tiquetes antes: " + tiquetesAntes);
        System.out.println("  - Tiquetes después: " + tiquetesDespues);
        System.out.println();
    }

    /**
     * Test 5: Prueba salvar la información de la aerolínea a JSON
     */
    public void testSalvarAerolineaJSON(Aerolinea unaAerolinea) throws TipoInvalidoException, IOException
    {
        System.out.println("--- TEST 5: Salvar Aerolínea a JSON ---");
        String archivo = "./datos/aerolinea_salida.json";

        unaAerolinea.salvarAerolinea(archivo, CentralPersistencia.JSON);

        System.out.println("✓ Aerolínea guardada correctamente en: " + archivo);
        System.out.println();
    }

    /**
     * Test 6: Prueba registrar un vuelo como realizado
     */
    public void testRegistrarVueloRealizado(Aerolinea unaAerolinea)
    {
        System.out.println("--- TEST 6: Registrar Vuelo Realizado ---");
        String fecha = "2024-11-05";
        String codigoRuta = "4558";

        unaAerolinea.registrarVueloRealizado(fecha, codigoRuta);

        System.out.println("✓ Vuelo registrado como realizado");
        System.out.println("  - Ruta: " + codigoRuta + ", Fecha: " + fecha);
        System.out.println("  - Los tiquetes de este vuelo fueron marcados como usados");
        System.out.println();
    }

    /**
     * Test 7: Prueba consultar el saldo pendiente de clientes
     */
    public void testConsultarSaldoPendiente(Aerolinea unaAerolinea)
    {
        System.out.println("--- TEST 7: Consultar Saldo Pendiente ---");

        String[] clientesAPrueba = {"Bob", "Alice", "Apple", "Charlie"};

        for(String idCliente : clientesAPrueba) {
            String saldo = unaAerolinea.consultarSaldoPendienteCliente(idCliente);
            System.out.println("  - Saldo pendiente de " + idCliente + ": $" + saldo);
        }

        System.out.println("✓ Consultas de saldo completadas");
        System.out.println();
    }

    /**
     * Test 8: Prueba salvar tiquetes a JSON
     */
    public void testSalvarTiquetesJSON(Aerolinea unaAerolinea) throws TipoInvalidoException, IOException
    {
        System.out.println("--- TEST 8: Salvar Tiquetes a JSON ---");
        String archivo = "./datos/tiquetes_salida.json";

        unaAerolinea.salvarTiquetes(archivo, CentralPersistencia.JSON);

        System.out.println("✓ Tiquetes guardados correctamente en: " + archivo);
        System.out.println();
    }
}