package tests.Practica;

public class ClienteCorporativo extends Cliente {
	public final String CORPORATIVO = "Corporativo";
	private int tamanoEmpresa;
	private String nombreEmpresa;
	public ClienteCorporativo(String nombreEmpresa, int tamanoEmpresa) {
		this.nombreEmpresa =  nombreEmpresa;
		this.tamanoEmpresa = tamanoEmpresa;
	}
	
	public int getTamanoEmpresa() {
		return tamanoEmpresa;
	}
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	@Override
	public String getTipoCliente() {
		return CORPORATIVO;
	}

	@Override
	public String getIdentificador() {
		return nombreEmpresa;
	}

}
