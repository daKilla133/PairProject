package Renderer;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.DataBufferInt;

import MathLogic.Math3D;
import Utils.GlobalScope;

public class Graphics3D {

	public final Buffered3D bf;
	private BufferStrategy bs;
	private int[] pixels;
	public Graphics3D(Buffered3D bf)
	{
		this.bf = bf;
		bs = GlobalScope.mainWindow.getBufferStrategy();
		if(bs == null)
			GlobalScope.mainWindow.createBufferStrategy(3);
	}
	public Graphics2D getGr()
	{return (Graphics2D)bs.getDrawGraphics();}
	public void render()
	{
		pixels = ((DataBufferInt)bf.getImg().getRaster().getDataBuffer()).getData();
		for(int i = 0; i < bf.pixels.length; i++)
			pixels[i] = bf.pixels[i];
		Graphics2D g = getGr();
		g.setBackground(Color.BLACK);
		g.clearRect(0, 0, GlobalScope.mainWindow.getWidth(), GlobalScope.mainWindow.getHeight());
		bf.tFloor(new Buffered3D(bf.getImg().getSubimage(0, 0, 300, 300)), 400, 400);
		g.drawImage(bf.getImg(), 0, 0, GlobalScope.mainWindow.getWidth(), GlobalScope.mainWindow.getHeight(), null);
		g.dispose();
		bs.show();
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
