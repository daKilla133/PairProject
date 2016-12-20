package Geometry;

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
}
