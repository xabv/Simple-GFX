import java.awt.Graphics;



public class Rectangle extends Shape{

	protected static int w, h; 

	public Rectangle(String r, int x, int y, int width, int height) {
		super(r,x,y);
		w = width;
		h = height;
	}

	@Override
	public void draw(Graphics g, int inX, int inY) {
		g.drawRect(inX,inY,w,h);
	}

	@Override
	public void dance(Graphics g, int inX, int inY, int maxX, int maxY) {
		g.drawRect(inX,inY,w,h);
	}
	
}

