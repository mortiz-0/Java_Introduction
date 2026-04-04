package ciudad.connector;

import java.awt.Color;
public class TramoCicloRuta extends ConnectingPart {
	//Suppose this class inherits from ConnectingPart and not from Connector
	public TramoCicloRuta(int x1, int x2, int y1, int y2) {
		super(x1, x2, y1, y2);
	}
	@Override
	public Color getColor() {
		return Color.orange;	
	}
}
