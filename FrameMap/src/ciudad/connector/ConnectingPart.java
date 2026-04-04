package ciudad.connector;

import java.awt.Color;
import java.awt.Graphics;

public abstract class ConnectingPart {
	//Attributes
	protected int x1;
	protected int x2;
	protected int y1;
	protected int y2;
	//Constructor
	public ConnectingPart(int x1, int x2, int y1, int y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}
	//Methods
	public void paint(Graphics g) {
		int[] xPoints = {this.x1, this.x1, this.x2, this.x2};
		int[] yPoints = {this.y1, this.y1+5, this.y2+5, this.y2};
		g.setColor(this.getColor());
		g.fillPolygon(xPoints, yPoints, 4);
	}
	public Color getColor() {
		return Color.gray;	
	}
	public int getX1() {
		return x1;
	}
	public int getX2() {
		return x2;
	}
	public int getY1() {
		return y1;
	}
	public int getY2() {
		return y2;
	}
	
}
