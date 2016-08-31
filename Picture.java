
import java.util.*;
import java.awt.*;

public class Picture<S extends Shape> {
	protected ArrayList<S> shapeList = new ArrayList<S>();
	protected ArrayList<String> picList;
	protected String canvas;
	protected Shape s;
	protected int x, y;
	
	public Picture(String canvas) {
		this.canvas = canvas;
	}
	
	public String getCanvas(){
		return canvas;
	}
	
	public void addShape(S shape) {
		shapeList.add(shape);
	}
		
	public void draw(Graphics gfx, Color color, int offsetX, int offsetY) throws InterruptedException {
		Iterator<S> shapeIter;
		Shape shape;
		shapeIter = shapeList.iterator();
		while(shapeIter.hasNext() ){
			gfx.setColor(color);
			shape = shapeIter.next();
			x = shape.getX();
			y = shape.getY();
			shape.draw(gfx, x + offsetX, y + offsetY);
			Thread.sleep(500);
		}
		
	}

	public void dance(Graphics g, Color c, int offsetX, int offsetY, int maxX, int maxY) throws InterruptedException {
		g.setColor(Color.white);
		g.fillRect(0,0,600,600);
		for(Shape shape: shapeList){
			g.setColor(c);
			x = shape.getX();
			y = shape.getY();
			shape.dance(g, offsetX+x, offsetY+y, maxX, maxY);
			Thread.sleep(500);
			g.setColor(Color.white);
			g.fillRect(0,0,600,600);
			g.setColor(c);
			if(offsetX + x < 300 && offsetY + y < 300){
				shape.dance(g, (offsetX + x) * 2, (offsetY + y) * 2 , maxX, maxY);
				Thread.sleep(500);
				g.setColor(Color.white);
				g.fillRect(0,0,600,600);
			}
			else{
				shape.dance(g, offsetX + x -150, offsetY + y - 150, maxX, maxY);
				Thread.sleep(500);
				g.setColor(Color.white);
				g.fillRect(0,0,600,600);
			}
		}
	}

	public void clear(Graphics g) {
			g.setColor(Color.white);
			g.fillRect(0, 0, Main.winSize, Main.winSize);
	}

}
