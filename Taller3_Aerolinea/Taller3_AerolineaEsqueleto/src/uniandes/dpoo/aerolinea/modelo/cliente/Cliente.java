package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.ArrayList;
import java.util.List;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente {
	//Attributes
	private List<Tiquete> tiquetesSinUsar;
	private List<Tiquete> tiquetesUsados;
	//Constructor
	public Cliente() {
		tiquetesSinUsar = new ArrayList<>();
		tiquetesUsados = new ArrayList<>();
	}
	//Methods
	public abstract String getTipoCliente();
	public abstract String getIdentificador();
	public void agregarTiquete(Tiquete tiquete) {
		tiquetesSinUsar.add(tiquete);
	}
	public int calcularValorTotalTiquetes() {
		int total = 0;
		for (Tiquete t : tiquetesSinUsar) {
			total += t.getTarifa();
		}
		for (Tiquete t : tiquetesUsados) {
			total += t.getTarifa();
		}
		return total;
		//Calcula el valor total de los tiquetes que ha comprado un cliente
	}
	public void usarTiquetes(Vuelo vuelo) {
		List<Tiquete> usados = new ArrayList<>();
		for (Tiquete t : tiquetesSinUsar) {
			if (vuelo.equals(t.getVuelo())) {
				t.marcarComoUsado();
				usados.add(t);
			}
		}
		tiquetesSinUsar.removeAll(usados);
		tiquetesUsados.addAll(usados);
		//Marca como usados todos los tiquetes del cliente qus se hayan realizado en el vuelo que llega por parámetro, moviéndolos de la lista de tiquetes sin usar a la lista de tiquetes usados
	}
}
