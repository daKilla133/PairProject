package Renderer;

import java.awt.Graphics2D;

import MathLogic.Math3D;
import Utils.GlobalScope;

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
		Math3D.Rotate(GlobalScope.camera.pos, theta, 0, 0);
		getGr().drawImage(bf.getImg(), 0, 0, bf.getImg().getWidth(), bf.getImg().getHeight(), null);
	}
	public void YRotate(float theta)
	{
		Math3D.Rotate(GlobalScope.camera.pos, 0, theta, 0);
	}
	public void ZRotate(float theta)
	{
		Math3D.Rotate(GlobalScope.camera.pos, 0, 0, theta);	
	}
}
