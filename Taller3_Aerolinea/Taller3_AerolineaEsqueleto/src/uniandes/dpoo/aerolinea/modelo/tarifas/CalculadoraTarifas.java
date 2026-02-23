package uniandes.dpoo.aerolinea.modelo.tarifas;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.Ruta;

public abstract class CalculadoraTarifas {
	public static final double IMPUESTO = 0.28;
	public CalculadoraTarifas() {
	}
	public int calculaTarifa(Vuelo vuelo, Cliente cliente) {
		return 0;
	}
	protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		return 0;
	}
	protected double calcularPorcentajeDescuento(Cliente cliente) {
		return 1.0;
	}
	protected int calculardDistancia(Ruta ruta) {
		return 0;
	}
	protected int calcularValorImpuestos(int costoBase) {
		return 0;
	}
}
