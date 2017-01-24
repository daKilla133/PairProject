package Renderer;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.DataBufferInt;
import java.util.Random;

import MathLogic.Math3D;
import Utils.GlobalScope;
import WindowFrame.Window;

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
	public void render(int xOffset, int yOffset, int w, int h, float elapsedTime)
	{
		pixels = ((DataBufferInt)bf.getImg().getRaster().getDataBuffer()).getData();
		for(int i = 0; i < bf.pixels.length; i++)
			pixels[i] = bf.pixels[i];
		Graphics2D g = getGr();
		g.setBackground(Color.BLACK);
		g.clearRect(0, 0, GlobalScope.mainWindow.getWidth(), GlobalScope.mainWindow.getHeight());
		
		bf.tFloor(new Buffered3D(bf.getImg()), elapsedTime);
		g.drawImage(bf.getImg(), xOffset, yOffset, w, h, null);
		g.dispose();
		bs.show();
	}
}
