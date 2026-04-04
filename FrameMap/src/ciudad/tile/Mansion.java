package ciudad.tile;

import java.awt.Color;

public class Mansion extends Building {

	public Mansion(int x, int y) {
		super(x, y);
	}
	@Override
	public Color getColor() {
		return Color.blue;	
	}
	@Override
	public char[] getKey() {
		return "Mansion".toCharArray();
	}
}
