package Geometry;

import java.awt.Graphics2D;
import java.io.Serializable;

public class Polygon3D implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public Vec3[] zpoints;
	public Vec3[] ypoints;
	public Vec3[] xpoints;
	private int zIndex = 0;
	private int yIndex = 0;
	private int xIndex = 0;

	public void addPoint(Vec3 x, Vec3 y, Vec3 z)
	{
		zpoints[zIndex] = z;
		zIndex++;
		ypoints[yIndex] = y;
		yIndex++;
		xpoints[xIndex] = x;
		xIndex++;
	}
	public void addArrayCoordinates(Vec3[] x, Vec3[] y, Vec3[] z)
	{
		for(int i = xIndex, j = yIndex; i < xIndex + x.length && j < yIndex + y.length; i++, j++)
		{
			xpoints[i] = x[i - xIndex];
			ypoints[j] = y[j - yIndex];
		}
		for(int i = zIndex; i < zIndex + z.length; i ++)
		{
			zpoints[i] = z[i-zIndex];
		}
		xIndex += x.length-1;
		yIndex += y.length-1;
		zIndex += z.length-1;
	}
	public void render(Graphics2D g)
	{
		for(int i = 0; i < zIndex; i ++)
		{
//			g.drawLine(xpoints[xIndex], xpoints[xIndex-1], x2, y2);
			
		}
	}
}
