import java.awt.Graphics;

public class Circle extends Shape {
	protected int size;
	
	public Circle(String circle, int x, int y, int size){
		super(circle, x, y);
		this.size = size;
	}

	@Override
	public void draw(Graphics gfx, int x, int y) {
		gfx.drawOval(x, y, size, size);

	}

	@Override
	public void dance(Graphics gfx, int x, int y, int x_max, int y_max) {
		gfx.drawOval(x, y, size, size);

	}

}