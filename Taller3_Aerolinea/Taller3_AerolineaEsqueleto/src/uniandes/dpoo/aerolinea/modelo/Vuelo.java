package uniandes.dpoo.aerolinea.modelo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import uniandes.dpoo.aerolinea.exceptions.VueloSobrevendidoException;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.GeneradorTiquetes;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class Vuelo {
	//Attributes
	private String fecha;
	private Ruta ruta;
	private Avion avion;
	private Map<String,Tiquete> tiquetes;
	//Constructor
	public Vuelo(Ruta ruta, String fecha, Avion avion) {
		this.fecha = fecha;
		this.avion = avion;
		this.ruta = ruta;
		this.tiquetes = new HashMap<String,Tiquete>();
	}

	public String getFecha() {
		return fecha;
	}

	public Ruta getRuta() {
		return ruta;
	}

	public Avion getAvion() {
		return avion;
	}

	public Collection<Tiquete> getTiquetes() {
		return tiquetes.values();
	}

	public void agregarTiquete(Tiquete tiquete) {
		this.tiquetes.put(tiquete.getCodigoString(), tiquete);
	}

	public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) throws VueloSobrevendidoException {
		// Verificar si hay capacidad suficiente
		int tiquetesVendidos = tiquetes.size();
		int capacidadTotal = avion.getCapacidad();

		if (tiquetesVendidos + cantidad > capacidadTotal) {
			throw new VueloSobrevendidoException(this);
		}

		int valorTotal = 0;

		// Generar y vender los tiquetes
		for (int i = 0; i < cantidad; i++) {
			int tarifa = calculadora.calculaTarifa(this, cliente);
			Tiquete nuevoTiquete = GeneradorTiquetes.generarTiquete(this, cliente, tarifa);

			// Agregar el tiquete al vuelo y al cliente
			this.agregarTiquete(nuevoTiquete);
			cliente.agregarTiquete(nuevoTiquete);

			valorTotal += tarifa;
		}

		return valorTotal;
	}
	@Override
	public int hashCode() {
		return Objects.hash(this.ruta.getCodigoRuta(), this.fecha);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    Vuelo other = (Vuelo) obj;
	    return Objects.equals(this.fecha, other.fecha) && 
	           Objects.equals(this.ruta.getCodigoRuta(), other.ruta.getCodigoRuta());
	}
}
