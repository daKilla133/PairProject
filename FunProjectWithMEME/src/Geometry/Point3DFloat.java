package Geometry;

import java.io.Serializable;

public class Point3DFloat extends Point3D implements Serializable{
	private static final long serialVersionUID = 1L;
	private float x, y, z;
	
	public Point3DFloat()
	{
		x = 0.0f;
		y = 0.0f;
		z = 0.0f;
	}
	public Point3DFloat(float x, float y, float z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public void setLocation(double x, double y, double z)
	{
		this.x = (float)x;
		this.y = (float)y;
		this.z = (float)z;
	}

	public double getZ() 
	{	return z;	}

	public double getY() 
	{	return y;	}

	public double getX() 
	{	return x;	}

	public String toString()
	{
		return "X: " + x + " Y: " + y + " Z: " + z;
	}
	
}
