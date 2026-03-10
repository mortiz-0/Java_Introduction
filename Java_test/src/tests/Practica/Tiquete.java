package tests.Practica;

public class Tiquete {
	//Attributes
	private Cliente cliente;
	private String vuelo;
	private String codigo;
	private int tarifa;
	private boolean usado = false;
	//Constructor
	public Tiquete(String codigo, String vuelo, Cliente clienteComprador, int tarifa) {
		this.codigo = codigo;
		this.tarifa = tarifa;
		this.cliente = clienteComprador;
		this.vuelo= vuelo;
	}
	//Methods
	public Cliente getCliente(){
		return cliente;
	}
	public String getVuelo(){
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
