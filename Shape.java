
/* Skeleton code for Homework 1, CS3100, CSU Stanislaus, Fall 2014 */
import java.awt.*;

public abstract class Shape {
	private String myname;
	private int x, y;
	
	public Shape(String newname, int inx, int iny) {
		if (newname.length() > 0) {
			myname = newname;
		}
		else { myname = "Shape"; }
		if (inx >= 0) { 
			x = inx; 
		} else { x = 0; }
		if (iny >= 0) { 
			y = iny;
		} else { y = 0; }
	}

	public String getName() {
		return myname;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	protected void setX(int in) {
		if (in >= 0) {
			x = in;
		}
	}
	protected void setY(int in) {
		if (in >= 0) {
			y = in;
		}
	}
	/* Using the given Graphics variable, draws the current
	 * Shape at the current location of this Shape (x, y)
	 * offset by the given parameters (inX, inY).  In other words,
	 * the Shape will be drawn at (x+inX, y+inY).         */
	public abstract void draw(Graphics g, int inX, int inY);

	/* Using the given Graphics variable, draws the current
	 * Shape repeatedly in some pattern.  The pattern should
	 * either start at, or be centered around, the current 
	 * location of this Shape (x, y) offset by the given 
	 * parameters (inX, inY).  In other words, the "dance" will 
	 * start at or center around (x+inX, y+inY).
	 * 
	 * maxX: the maximum width of the window to draw in
	 * maxY: the maximum height of the window to draw in */
	public abstract void dance(Graphics g, int inX, int inY, int maxX, int maxY);

	@Override
	public String toString() {
		return myname + ": x:" + x + ", y:" + y;
	}
} // End of Shape class