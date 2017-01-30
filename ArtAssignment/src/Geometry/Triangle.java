package Geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import MathLogic.Vec3;

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

}
