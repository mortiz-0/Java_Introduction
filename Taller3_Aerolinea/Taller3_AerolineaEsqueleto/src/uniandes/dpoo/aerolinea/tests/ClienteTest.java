package uniandes.dpoo.aerolinea.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;

public class ClienteTest {
	public ClienteTest() {
	}
	@BeforeEach
	void setUp() {
		try {
			ClienteCorporativo cliente = new ClienteCorporativo("Empresa XYZ", 123);
		}
		catch(Exception e) {
			throw e;
		}
	}
	@Test
	void test() {
		
	}
}
