package uniandes.dpoo.aerolinea.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.aerolinea.persistencia.CentralPersistencia;

public class CentralPersistenciaTest {
	public CentralPersistenciaTest() {
	}
	@BeforeEach
	void setUp() {
		try {
			CentralPersistencia CentPer = new CentralPersistencia();
		}
		catch(Exception e){
			throw e;
		}
	}
	@Test
	void testGetPersistenciaAerolinea() {
		
	}
	@Test
	void testGetPersistenciaAerolineaIncorrecto() {
		
	}
	@Test
	void testGetPersistenciaTiquetes() {
		
	}
	@Test
	void testGetPersistenciaTiquetesIncorrecto() {
		
	}
}
