import java.awt.Graphics;



public class MyShape extends Shape {
	int w, h, arcW, arcH;
	
	public MyShape(String ms, int x, int y, int w, int h, int arcW, int arcH) {
		super(ms, x, y);
		this.w = w;
		this.h = h;
		this.arcW = arcW;
		this.arcH = arcH;
	}

	@Override
	public void draw(Graphics g, int inX, int inY) {		
		g.drawRoundRect(inX,inY,w,h,arcW,arcH);
	}

	@Override
	public void dance(Graphics g, int inX, int inY, int maxX, int maxY) {
		g.drawRoundRect(inX,inY,w,h,arcW,arcH);
	}
}

