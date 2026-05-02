package demo.uni;

public class Rector extends ColombianCitizen implements ICompras{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	@Override
	public void cambiarEstadoPedido() {
		// TODO Auto-generated method stub
		
	}

}