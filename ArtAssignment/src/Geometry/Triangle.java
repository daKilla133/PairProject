package Geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import MathLogic.Vec3;
import Utils.GlobalScope;

public class Triangle {
	private Vec3 x, y, z; 
	public Triangle(Vec3 x, Vec3 y, Vec3 z)
	{
		this.x = x;
		this.y = y;
		this.z = z;	
	}
	public Vec3 getX()
	{	return x;	}
	
	public Vec3 getY()
	{	return y;	}
	
	public Vec3 getZ()
	{	return z;	}
	public void render(Graphics g, Rectangle c)
	{
		double xp1 = x.getX() / x.getZ();
		double yp1 = x.getY() / x.getZ();
		double xp2 = y.getX() / y.getZ();
		double yp2 = y.getY() / y.getZ();
		double xp3 = z.getX() / z.getZ();
		double yp3 = z.getY() / z.getZ();
//		g.setClip(c);
		
//		int xx = (int)(xp1 * (g.getClipBounds().width / 2)) + g.getClipBounds().width / 2;
//		int yy = (int)(yp1 * (g.getClipBounds().height / 2)) + g.getClipBounds().height / 2;
//		int xx2 = (int)(xp2 * (g.getClipBounds().width / 2)) + g.getClipBounds().width / 2;
//		int yy2 = (int)(yp2 * (g.getClipBounds().height / 2)) + g.getClipBounds().height / 2;
//		int xx3 = (int)(xp3 * (g.getClipBounds().width / 2)) + g.getClipBounds().width / 2;
//		int yy3 = (int)(yp3 * (g.getClipBounds().height / 2)) + g.getClipBounds().height / 2;

		g.setColor(Color.white);
		g.drawRect(c.x, c.y, c.getSize().width, c.getSize().height);
	}
}
