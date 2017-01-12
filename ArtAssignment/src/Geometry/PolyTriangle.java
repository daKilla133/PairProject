package Geometry;

import java.awt.Polygon;

public class PolyTriangle extends Polygon{

	private static final long serialVersionUID = 1L;
	public PolyTriangle(int x, int y, int x2, int y2, int x3, int y3)
	{
		this.addPoint(x, y);
		this.addPoint(x2, y2);
		this.addPoint(x3, y3);
	}
		
}
