package ciudad;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;

import ciudad.connector.*;
import ciudad.tile.*;

@SuppressWarnings("serial")
public class Ciudad extends JPanel{
	// Attributes
	public String nombre;
	public List<GraphicElement> piezas = new ArrayList<>();
	// Constructor
	public Ciudad(String nombre) {
		this.nombre = nombre;
	}
	// Methods
	public void addTile(Tile Tile){
		piezas.add(Tile);
	}
	public void addConnector(Connector Connector) {
		piezas.add(Connector);
	}
	//Override for the painting, researched the necessary
	//to use the java.awt library
	@Override
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    for (GraphicElement p : piezas) {
	        p.paint(g);
	    }
	}
	public static void main(String[] arg){
        Ciudad miCiudad = new Ciudad("Bogotá");
		JFrame frame = new JFrame("Mapa CicloRuta "+ miCiudad.nombre);
		// Basic test: add some tiles and a connector
        //Tiles
		miCiudad.addTile(new House(50, 50));
		miCiudad.addTile(new FireStation(150, 80));
		miCiudad.addTile(new Park(115, 145));
		//Connectors
		Calles calles = new Calles();
		calles.addPart(new Calle(50, 200, 100, 100));
		calles.addPart(new Calle(200, 150, 100, 150));
		miCiudad.addConnector(calles);
		Cicloruta ciclo = new Cicloruta();
		ciclo.addPart(new TramoCicloRuta(150, 100, 150, 150));
		ciclo.addPart(new TramoCicloRuta(100, 50, 150, 100));
		miCiudad.addConnector(ciclo);
		frame.add(miCiudad);
        frame.setSize(350, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
}
