package test.Uni;
import java.time.LocalDate;

public class ColombianCitizen {
	private String nombre = "";
	private String tipo_documento = "";
	private String num_id = "";
	private LocalDate exp_id = LocalDate.parse("2000-01-01");
	private String citizenType = "Ciudadano";
	//Constructor
	public ColombianCitizen (String name, String tipoDoc, String num_id, String exp_id) {
		this.nombre = name;
		this.tipo_documento = tipoDoc;
		this.num_id = num_id;
		this.exp_id = LocalDate.parse(exp_id);
	}
	//Methods
	
	//Getters
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
	public String getcitizenType() {
		return this.citizenType;
	}
	//Changers
	protected void changeNombre(String new_value) {
		this.nombre = new_value;
	}
	protected void changeTipoDoc(String new_value) {
		this.tipo_documento = new_value;
	}
	protected void changeNumId(String new_value) {
		this.num_id = new_value;
	}
	protected void changeExpId(String new_value) {
		this.exp_id = LocalDate.parse(new_value);
	}
	protected void changeCitizenType(String new_value) {
		this.citizenType = new_value;
	}
}
