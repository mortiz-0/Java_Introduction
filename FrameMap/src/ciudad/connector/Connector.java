package ciudad.connector;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import ciudad.Clickable;
import ciudad.GraphicElement;

public abstract class Connector implements GraphicElement, Clickable{
	//Attribute
	List<ConnectingPart> parts = new ArrayList<>();
	
	public boolean selected = false;
	public boolean locked = false;
	//Methods
	//Can't see the use of the getters for the connectors
	//without position attributes and selection, makes sense for the
	//connecting parts itself but dunno for the connector.
	public int getX() {
		return parts.getFirst().getX1();
	}

	public int getY() {
		return parts.getFirst().getY1();
	}

	public int getHeight() {
		int height = parts.stream()
			.mapToInt(c->c.getY2()-c.getY1()).sum();
		return height;
	}

	public int getWidth() {
		return parts.stream()
				.mapToInt(c->c.getX2()-c.getX1()).sum();
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
	//Had to though about it quite a bit. Went for equal slope between the point
	//with the initial point of the segment and restricted x & y axis.
	public boolean isInside(int x, int y) {
		boolean b = false;
		for(ConnectingPart p: parts) {
			double slope = (p.getY2()-p.getY1())/(p.getX2()-p.getX1());
			if((y-p.getY1())/(x-p.getX1())==slope &&
				y >= p.getY1() && y <= p.getY2() &&
				x >= p.getX1() && x <= p.getX2()){
				b = true;
				break;
			}
		}
		return b;
	}
	
	public void addPart(ConnectingPart part) {
		parts.add(part);
	}
	@Override
	public void paint(Graphics g) {
		for (ConnectingPart p: parts) {
			p.paint(g);
		}
	}
}
