package tests.Practica;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Cliente {
	public ArrayList<Tiquete> tiquetesSinUsar;
	public ArrayList<Tiquete> tiquetesUsados;
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
	public int calcularValorTotal() {
		int valor = 0;
		for(Tiquete t: tiquetesSinUsar) {
			valor += t.getTarifa();
		}
		return valor;
	}
	public void usarTiquetes(String Vuelo) {
		Iterator<Tiquete> it = tiquetesSinUsar.iterator();
		while(it.hasNext()) {
			Tiquete t = it.next();
			if(t.getVuelo().equals(Vuelo)) {
				tiquetesUsados.add(t);
				it.remove();
			}
		}
	}
}
