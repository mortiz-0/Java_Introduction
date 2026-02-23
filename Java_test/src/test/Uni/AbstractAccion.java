package test.Uni;

public abstract class AbstractAccion extends ColombianCitizen implements IUniversidad{
	private boolean hizoPedido = false;
	public AbstractAccion(String name, String tipoDoc, String num_id, String exp_id) {
		super(name, tipoDoc, num_id, exp_id);
		}
	@Override
	public void cambiarEstadoPedido() {
		this.hizoPedido  = true;
	}
}