package ciudad.tile;

import java.awt.Graphics;
import java.awt.Color;

import ciudad.Clickable;
import ciudad.GraphicElement;

public abstract class Tile implements GraphicElement, Clickable{
	private int x;
	private int y;
	private int height;
	private int width;
	private boolean selected = false;
	private boolean locked = false;
	//Constructor
	public Tile(int x, int y, int height, int width) {
		super();
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}
	//Methods
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}
	public Color getColor() {
		return Color.black;
	}
	public char[] getKey() {
		return "Tile".toCharArray();
	}
	@Override
	public void paint(Graphics g) {
		int[] xPoints = {this.x, this.x, this.x + this.width, this.x +this.width};
		int[] yPoints = {this.y, this.y + this.height, this.y + this.height, this.y,};
		g.setColor(this.getColor());
		g.fillPolygon(xPoints, yPoints, 4);
		g.drawChars(this.getKey(), 0, this.getKey().length, this.x, this.y-5);
	}
	@Override
	public boolean isSelected() {
		return this.selected;
	}
	@Override
	public boolean isLocked() {
		return this.locked;
	}
	@Override
	public void setSelected(boolean b) {
		this.selected = b;
	}
	@Override
	public void setLocked(boolean b) {
		this.locked = b;
	}
	@Override
	public boolean isInside(int x, int y) {
		return x >= this.x && x <= this.x + this.width 
				&& y >= this.y && y <= this.y + this.height;
	}
}
