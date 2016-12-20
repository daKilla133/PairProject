package Geometry;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;

import WindowFrame.Window;

public abstract class Point3D extends Point2D {
	public void setLocation(double x, double y)
	{	}
	public abstract void setLocation(double x, double y, double z);
	public abstract double getZ();
	public void draw(Window win)
	{
		Graphics2D g = (Graphics2D) win.getGraphics();
	}
}
