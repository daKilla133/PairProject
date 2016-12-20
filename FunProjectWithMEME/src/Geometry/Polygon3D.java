package Geometry;

import java.io.Serializable;

public class Polygon3D implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public Point3D[] zpoints;
	public Point3D[] ypoints;
	public Point3D[] xpoints;
	private int zIndex = 0;
	private int yIndex = 0;
	private int xIndex = 0;

	public void addPoint(Point3D x, Point3D y, Point3D z)
	{
		zpoints[zIndex] = z;
		zIndex++;
		ypoints[yIndex] = y;
		yIndex++;
		xpoints[xIndex] = x;
		xIndex++;
	}
	public void addArrayCoordinates(Point3D[] x, Point3D[] y, Point3D[] z)
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
	
}
