package uniandes.dpoo.aerolinea.consola;

import java.io.IOException;

import uniandes.dpoo.aerolinea.modelo.Aerolinea;
import uniandes.dpoo.aerolinea.tests.AeropuertoTest;

public class ConsolaAerolinea extends ConsolaBasica
{
    private Aerolinea unaAerolinea;

    /**
     * Es un método que corre la aplicación y ejecuta tests de las funcionalidades principales.
     * Las pruebas de comprobación de requerimientos ubicadas en AeropuertoTest
     * fueron realizadas con Inteligencia Artificial en su totalidad.
     */
    public void correrAplicacion( )
    {
        try
        {
            System.out.println("=== INICIO DE PRUEBAS DE LA AEROLÍNEA ===\n");

            AeropuertoTest aeropuertoTest = new AeropuertoTest();
			aeropuertoTest.testCargarAerolineaJSON(unaAerolinea);
			aeropuertoTest.testCargarTiquetesJSON(unaAerolinea);
			aeropuertoTest.testProgramarVuelo(unaAerolinea);
			aeropuertoTest.testVenderTiquetes(unaAerolinea);
			aeropuertoTest.testSalvarAerolineaJSON(unaAerolinea);
			aeropuertoTest.testRegistrarVueloRealizado(unaAerolinea);
			aeropuertoTest.testConsultarSaldoPendiente(unaAerolinea);
			aeropuertoTest.testSalvarTiquetesJSON(unaAerolinea);

            System.out.println("\n=== FIN DE PRUEBAS ===");
        }
        catch( Exception e )
        {
            System.err.println("Error durante la ejecución de pruebas: " + e.getMessage());
            e.printStackTrace( );
        }
    }

    public static void main( String[] args )
    {
        ConsolaAerolinea ca = new ConsolaAerolinea( );
        ca.correrAplicacion( );
    }
}
