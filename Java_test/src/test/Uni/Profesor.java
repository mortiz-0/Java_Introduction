package test.Uni;

public class Profesor extends ColombianCitizen implements ICompras{
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
	@Override
	public void cambiarEstadoPedido() {
		// TODO Auto-generated method stub
		
	}
}