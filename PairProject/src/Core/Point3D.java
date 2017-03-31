package Core;

public class Point3D {
	private float x, y, z;
	public float getX() 
	{	return x;	}

	public float getY() 
	{	return y;	}
	
	public float getZ()
	{ return z;	}

	public void setLocation(float x, float y) 
	{
		this.x += x;
		this.y += y;
	}
	public void setLocation(float x, float y, float z)
	{
		setLocation(x, y);
		this.z += z;
	}

}
