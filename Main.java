import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static int x, y, w, h, arcW, arcH, size, winSize = 600;
	public static Color getColor;
	public static String cmd, color, canvas;
	public static String[] tokens;
	public static ArrayList<Picture<Shape>> picList = new ArrayList<Picture<Shape>>();
	public static ArrayList<String> okShapes;
	public static File file;
	public static BufferedReader reader;
	public static Picture<Shape> picture;
	public static DrawingPanel panel;
	public static Graphics graphics;

	public static void main(String[] args) throws Exception{

		try{
			file = new File(args[0]);
			reader = new BufferedReader(new FileReader(file));
			okShapes = new ArrayList<String>(Arrays.asList("circle","rectangle",
					"coloredrect", "myShape"));
			panel = new DrawingPanel(winSize,winSize);
			graphics = panel.getGraphics();
			cmdFunc();
		}
		
		catch (FileNotFoundException e){
			System.out.println("\nFile was not found.\n");
			Thread.sleep(2500);
			e.printStackTrace();
		}
		
		finally{
			if (args.length <= 0){
				System.out.println("Please use: java Homework1 validInputFileName.txt");
				System.exit(0);
			}
		}

	}

	public static void cmdFunc() throws InterruptedException, IOException{
		System.out.println();
		while((cmd = reader.readLine())!=null){
			System.out.println(cmd);
			Thread.sleep(1000);

			if(cmd.startsWith("start")){
				canvas = cmd.split(" ")[2];
				picture = new Picture<Shape> (canvas);
				picList.add(picture);
			}

			else if(cmd.startsWith("draw")){
				tokens = cmd.split(" ");
				canvas = tokens[2];
				color = tokens[3];
				x = Integer.parseInt(tokens[4]);
				y = Integer.parseInt(tokens[5]);
				getColor = Color.getColor(color);
				if(getColor == null)
					getColor = findColor(color);
				if(picList.contains(picture)){
					for(Picture<Shape> picDraw: picList){
						if(picDraw.getCanvas().equals(canvas))
							picDraw.draw(graphics, getColor, x, y);
					}
				}
				else
					System.out.println("\nPicture " + canvas + " does not exist.\n");
			}

			else if(cmd.startsWith("dance")){
				tokens = cmd.split(" ");
				canvas = tokens[2];
				x = Integer.parseInt(tokens[3]);
				y= Integer.parseInt(tokens[4]);
				if(picList.contains(picture)){
					for(Picture<Shape> picDance: picList){
						if(picDance.getCanvas().equals(canvas))
							picDance.dance(graphics, getColor, x, y, winSize, winSize);
					}
				}
				else
					System.out.println("\nERROR: picture " + canvas + " does not exist.\n");
			}
			
			else if(cmd.startsWith("erase")){
				picture.clear(graphics);
				System.out.println();
			}
			
			else if(cmd.startsWith("end")){
				picList.remove(cmd.split(" ")[1]);
				System.out.println("\ndemo is now done");
				System.exit(1);
			}
			
			else if(okShapes.contains(cmd.split(" ")[0]))
				addShapes();
			
			else
				System.out.println("\nERROR: command \"" + cmd + "\" is not supported.\n");
		}

		reader.close();

	}

	public static void addShapes(){
		
		if(cmd.startsWith("circle")){
			tokens = cmd.split(" ");
			x = Integer.parseInt(tokens[1]);
			y = Integer.parseInt(tokens[2]);
			size = Integer.parseInt(tokens[3]);
			Circle circle = new Circle("circle", x, y, size);
			picture.addShape(circle);
		}

		else if(cmd.startsWith("rectangle")){
			tokens = cmd.split(" ");
			x = Integer.parseInt(tokens[1]);
			y = Integer.parseInt(tokens[2]);
			w = Integer.parseInt(tokens[3]);
			h = Integer.parseInt(tokens[4]);
			Rectangle rect = new Rectangle("rectangle", x, y, w, h);
			picture.addShape(rect);
		}

		else if(cmd.startsWith("coloredrect")){
			tokens = cmd.split(" ");			
			x = Integer.parseInt(tokens[1]);
			y = Integer.parseInt(tokens[2]);
			w = Integer.parseInt(tokens[3]);
			h = Integer.parseInt(tokens[4]);
			color = tokens[5];
			getColor = Color.getColor(color);
			if(getColor == null)
				getColor = findColor(color);
			ColoredRectangle coloredRect = new ColoredRectangle("coloredrect",
					getColor, x, y, w, h);
			picture.addShape(coloredRect);
		}

		else if(cmd.startsWith("myShape")){
			tokens = cmd.split(" ");
			x = Integer.parseInt(tokens[1]);
			y = Integer.parseInt(tokens[2]);
			w = Integer.parseInt(tokens[3]);
			h = Integer.parseInt(tokens[4]);
			arcW = Integer.parseInt(tokens[5]);
			arcH = Integer.parseInt(tokens[6]);
			MyShape myShape = new MyShape("myShape", x, y, w, h, arcW, arcH);
			picture.addShape(myShape);
		}

	}

	public static Color findColor(String name) {
		switch(name.toLowerCase()){
			default:
			case "gray":
			case "grey":
				return Color.gray;
			case "light_grey":
			case "lightgrey":
			case "light_gray":
			case "lightgray":
				return Color.lightGray;
			case "dark_grey":
			case "darkgrey":
			case "dark_gray":
			case "darkgray":
				return Color.darkGray;
		}

	}
}
