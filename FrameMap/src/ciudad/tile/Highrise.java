package ciudad.tile;

import java.awt.Color;

public class Highrise extends Building{
	public Highrise(int x, int y) {
		super(x, y);
	}
	@Override
	public Color getColor() {
		return Color.yellow;	
	}
	@Override
	public char[] getKey() {
		return "Highrise".toCharArray();
	}
}
