package ciudad.tile;

import java.awt.Color;

public class FireStation extends Tile {

	public FireStation(int x, int y) {
		super(x, y, 10, 15);
	}
	@Override
	public Color getColor() {
		return Color.red;	
	}
	@Override
	public char[] getKey() {
		return "FireStation".toCharArray();
	}
}		
