package ciudad;

import java.awt.Graphics;

public interface GraphicElement {
	public boolean isSelected();
	public boolean isLocked();
	public void setSelected(boolean b);
	public void setLocked(boolean b);
	public void paint(Graphics g);
}
