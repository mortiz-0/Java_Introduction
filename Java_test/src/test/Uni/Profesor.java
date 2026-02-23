package test.Uni;

public class Profesor extends AbstractAccion{
	@Override
	public String accionSalon(){
		return "Enseñar";
	}
	@Override
	public String hacerPedido(){
		this.cambiarEstadoPedido();
		return "Supervisar";
	}
	public Profesor(String name, String tipoDoc, String num_id, String exp_id) {
		super(name, tipoDoc, num_id, exp_id);
		this.changeCitizenType("Profesor");
	}
}