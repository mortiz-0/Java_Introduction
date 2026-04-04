package ciudad.tile;

import java.awt.Color;

public class House extends Building{
	public House(int x, int y) {
		super(x, y);
	}
	@Override
	public Color getColor() {
		return Color.orange;	
	}
	@Override
	public char[] getKey() {
		return "House".toCharArray();
	}
}
