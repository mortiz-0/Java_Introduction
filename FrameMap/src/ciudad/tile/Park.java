package ciudad.tile;

import java.awt.Color;

public class Park extends Tile {

	public Park(int x, int y) {
		super(x, y, 20, 20);
	}
	@Override
	public Color getColor() {
		return Color.green;	
	}
	@Override
	public char[] getKey() {
		return "Park".toCharArray();
	}
}
