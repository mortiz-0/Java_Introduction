package test.Uni;

public class Estudiante extends ColombianCitizen implements ICompras{
	public Estudiante(String name, String tipoDoc, String num_id, String exp_id) {
		super(name, tipoDoc, num_id, exp_id);
		this.changeCitizenType("Estudiante");
	}
	@Override
	public String accionSalon(){
		return "Estudiar";
	}
	@Override
	public String hacerPedido(){
		this.cambiarEstadoPedido();
		return "Comprar";
	}
	@Override
	public void cambiarEstadoPedido() {
		// TODO Auto-generated method stub
		
	}
}