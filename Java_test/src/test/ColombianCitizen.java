package test;
import java.time.LocalDate;

public class ColombianCitizen {
	private String nombre = "";
	private String tipo_documento = "";
	private String num_id = "";
	private LocalDate exp_id = LocalDate.parse("2000-01-01");
	//Constructor
	public ColombianCitizen (String name, String tipoDoc, String num_id, String exp_id) {
		this.nombre = name;
		this.tipo_documento = tipoDoc;
		this.num_id = num_id;
		this.exp_id = LocalDate.parse(exp_id);
	}
	//Methods
	public String getNombre() {
		return this.nombre;
	}
	public String getTipoDoc() {
		return this.tipo_documento;
	}
	public String getNumId() {
		return this.num_id;
	}
	public LocalDate getExpId() {
		return this.exp_id;
	}
}
