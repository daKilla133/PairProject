package Renderer;

import java.awt.Graphics2D;

public class Graphics3D {

	Buffered3D bf;
	public Graphics3D(Buffered3D bf)
	{
		this.bf = bf;
	}
	public Graphics2D getGr()
	{
		return (Graphics2D)bf.getImg().getGraphics();
	}
	public void XRotate(float theta)
	{
	
	}
	public void YRotate(float theta)
	{
		
	}
	public void ZRotate(float theta)
	{
		
	}
}
