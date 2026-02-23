package uniandes.dpoo.aerolinea.tests;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;

public class RutaTest {
	public RutaTest(){
	}
	@BeforeAll
	static void crearAeropuertos() throws Exception {
		try {
			Aeropuerto aeropuerto1 = new Aeropuerto(null, null, null, 0, 0);
		}
		catch(Exception e){
			throw e;
		}
	}
	@BeforeEach
	void setUp() {
		try {
			Ruta ruta1 = new Ruta(null, null, null, null, null);
		}
		catch(Exception e){
			throw e;
		}
	}
	@Test
	void testGetDuracion() {
		
	}
	@Test
	void testGetMinutos() {
		
	}
	@Test
	void testGetHoras() {
		
	}
}
