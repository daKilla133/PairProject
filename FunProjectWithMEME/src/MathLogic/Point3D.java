package MathLogic;

import java.awt.geom.Point2D;

public abstract class Point3D extends Point2D {
	public void setLocation(double x, double y)
	{	}
	public abstract void setLocation(double x, double y, double z);
	public abstract double getZ();
}
