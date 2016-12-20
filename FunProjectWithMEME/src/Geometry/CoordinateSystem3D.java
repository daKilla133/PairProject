package Geometry;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import WindowFrame.Window;

public class CoordinateSystem3D {
	private Rectangle camera;
	public CoordinateSystem3D(Window frame)
	{
		camera = new Rectangle();
		camera.setLocation(0, 0);
		camera.setSize(frame.getSize());
	}
	public CoordinateSystem3D(int x, int y)
	{
		camera = new Rectangle();
		camera.setLocation(0, 0);
		camera.setSize(x, y);
	}
	public CoordinateSystem3D(int x, int y, int xOffSet, int yOffSet)
	{
		camera = new Rectangle();
		camera.setLocation(xOffSet, yOffSet);
		camera.setSize(x, y);
	}
	public void create3DSpace(Window frame)
	{
		frame.getContentPane().setBackground(Color.black);
		Graphics2D g = (Graphics2D)frame.getContentPane().getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(frame.getWidth()/2, frame.getHeight()/2, 2, frame.getHeight());
		
//		frame.setShape(Shape);
	}
}
