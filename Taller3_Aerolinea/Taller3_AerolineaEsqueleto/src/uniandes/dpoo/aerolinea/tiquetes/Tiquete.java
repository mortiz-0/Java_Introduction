package uniandes.dpoo.aerolinea.tiquetes;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;


public class Tiquete {
	//Attributes
	private Cliente cliente;
	private Vuelo vuelo;
	private String codigo;
	private int tarifa;
	private boolean usado = false;
	//Constructor
	public Tiquete(String codigo, Vuelo vuelo, Cliente clienteComprador, int tarifa) {
		this.codigo = codigo;
		this.tarifa = tarifa;
		this.cliente = clienteComprador;
		this.vuelo= vuelo;
	}
	//Methods
	public Cliente getCliente(){
		return cliente;
	}
	public Vuelo getVuelo(){
		return vuelo;
	}
	public int getCodigo(){
		return Integer.parseInt(this.codigo);
	}
	public String getCodigoString(){return this.codigo;	}
	public int getTarifa(){
		return this.tarifa;
	}
	public void marcarComoUsado(){
		this.usado = true;
	}
	public boolean esUsado(){
		return this.usado;
	}
}
