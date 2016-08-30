import java.awt.Color;
import java.awt.Graphics;


public class ColoredRectangle extends Shape {

public static Color getColor;
protected static int w, h; 
	public ColoredRectangle(String cr, Color color, int a, int b, int c,int d) {
		super(cr,a,b);
		getColor = color;
		w = c;
		h = d;
	}

	@Override
	public void draw(Graphics g, int inX, int inY) {
		g.setColor(getColor);
		g.drawRect(inX, inY, w, h);
		g.fillRect(inX, inY, w, h);
	}

	@Override
	public void dance(Graphics g, int inX, int inY, int maxX, int maxY) {
			g.drawRect(inX,inY, w, h);
			g.fillRect(inX, inY, w,h);
		
	}

}
