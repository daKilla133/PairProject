package WindowFrame;

import java.awt.Color;
import java.awt.Graphics2D;

import Geometry.Polygon3D;

public class WireFrame {
	Polygon3D poly;
	Graphics2D g;
	public WireFrame(Polygon3D polygon, Graphics2D g)
	{
		poly = polygon;
		this.g = g;
	}
	public void render()
	{
		g.setColor(Color.BLUE);
		for(int i = 0; i < poly.xpoints.length-1; i ++)
		{
		
//			g.drawLine(poly.xpoints[i].getX(), poly.ypoints[i].getY(), poly.xpoints[i+1].getX(), poly.ypoints[i+1]getY());
//			g.drawLine(poly.xpoints[i], poly.zpoints[i], poly.xpoints[i+1], poly.zpoints[i+1]);
//			g.drawLine(poly.zpoints[i], poly.ypoints[i], poly.zpoints[i+1], poly.ypoints[i+1]);
		}
	}
}
