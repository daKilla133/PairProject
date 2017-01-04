package Geometry;

import java.awt.Color;
import java.awt.Graphics;

import MathLogic.Point3D;

public class Triangle {
	private Point3D x, y, z; 
	public Triangle(Point3D x, Point3D y, Point3D z)
	{
		this.x = x;
		this.y = y;
		this.z = z;	
	}
	public Point3D getX()
	{	return x;	}
	
	public Point3D getY()
	{	return y;	}
	
	public Point3D getZ()
	{	return z;	}
	public void render(Graphics g)
	{
		double xp1 = x.getX() / x.getZ();
		double yp1 = x.getY() / x.getZ();
		double xp2 = y.getX() / y.getZ();
		double yp2 = y.getY() / y.getZ();
		double xp3 = z.getX() / z.getZ();
		double yp3 = z.getY() / z.getZ();
		if(g.getClip() == null)
			g.clipRect(50, 0, 1000, 200);
			
		int xx = (int)(xp1 * (g.getClipBounds().width / 2)) + g.getClipBounds().width / 2;
		int yy = (int)(yp1 * (g.getClipBounds().height / 2)) + g.getClipBounds().height / 2;
		int xx2 = (int)(xp2 * (g.getClipBounds().width / 2)) + g.getClipBounds().width / 2;
		int yy2 = (int)(yp2 * (g.getClipBounds().height / 2)) + g.getClipBounds().height / 2;
		int xx3 = (int)(xp3 * (g.getClipBounds().width / 2)) + g.getClipBounds().width / 2;
		int yy3 = (int)(yp3 * (g.getClipBounds().height / 2)) + g.getClipBounds().height / 2;
		
		g.setColor(Color.blue);
		g.drawLine(xx, yy, xx2, yy2);g.drawLine(xx2, yy2, xx3, yy3);g.drawLine(xx3, yy3, xx, yy);
	}
}
