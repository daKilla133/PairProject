package Renderer;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.IndexColorModel;

import MathLogic.Vec3;

public class Buffered3D {
	BufferedImage bf;
	Graphics3D g;
	public Buffered3D(int arg0, int arg1, int arg2, IndexColorModel arg3) {
		bf = new BufferedImage(arg0, arg1, arg2, arg3);
	}
	public void createGraphics()
	{
		Graphics2D g = (Graphics2D)bf.getGraphics();
		class GraphicsRaster extends Graphics3D
		{
			Graphics2D g;
			GraphicsRaster(Graphics2D g)
			{
				this.g = g;
			}

			public void xRotate(double theta)
			{	}
	
			public void yRotate(double theta) {
				
				
			}

			public void zRotate(double theta) {
				
				
			}

			public void translate(Vec3 v)
			{
				
			}
			public Graphics2D getGraphics()
			{
				return g;
			}
		}
		GraphicsRaster gr = new GraphicsRaster(g);
	}
	public Graphics2D g()
	{
		
	}
}
