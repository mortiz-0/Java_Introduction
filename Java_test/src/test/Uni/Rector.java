package test.Uni;

public class Rector extends AbstractAccion{
	@Override
	public String accionSalon(){
		return "Supervisar";
	}
	@Override
	public String hacerPedido(){
		this.cambiarEstadoPedido();
		return "Aprobar";
	}
	public Rector(String name, String tipoDoc, String num_id, String exp_id) {
		super(name, tipoDoc, num_id, exp_id);
		this.changeCitizenType("Rector");		
	}

}