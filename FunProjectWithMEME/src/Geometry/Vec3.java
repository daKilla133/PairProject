package Geometry;

import java.io.Serializable;
import MathLogic.Math3D;

public class Vec3 extends Point3D implements Serializable{
	private static final long serialVersionUID = 1L;
	private float x, y, z;
	
	public Vec3()
	{
		x = 0.0f;
		y = 0.0f;
		z = 0.0f;
	}
	public Vec3(float x, float y, float z)
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
	
	public void Scale(float size)
	{
		x *= size;
		y *= size;
		z *= size;
	}
	
	public float Magnitude()
	{
		float mag = (float) Math.sqrt((x * x) + (y * y) + (z * z));
		return mag;
	}
	
	public void Normal()
	{
		float mag = Magnitude();
		x /= mag;
		y /= mag;
		z /= mag;
	}
	
	public void Add(Vec3 other)
	{
		x += other.x;
		y += other.y;
		z += other.z;
	}
	
	public void Copy(Vec3 other)
	{
		x = other.x;
		y = other.y;
		z = other.z;
	}
	
	public Vec3 Mult(float val)
	{
		return new Vec3(x * val, y * val, z * val);
	}
	
	public static Vec3 eulerConversion(float yaw, float pitch, float roll, float size)
	{
		float xV = -(float)(Math.sin(yaw) * Math.cos(pitch));
		float zV = (float)(Math.cos(pitch) * Math.cos(yaw));
		float yV = (float)(Math.sin(pitch));
		
		return new Vec3(size * xV, size * yV, size * zV);
	}
	
	public void Rotate(Vec3 point, float yaw, float pitch, float roll)
	{
		x -= point.x;
		y -= point.y;
		z -= point.z;
		Math3D.Rotate(this, yaw, pitch, roll);
		x += point.x;
		y += point.y;
		z += point.z;
	}

	public String toString()
	{
		return "X: " + x + " Y: " + y + " Z: " + z;
	}
	
}
