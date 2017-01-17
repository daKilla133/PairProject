package Renderer;

import java.awt.BufferCapabilities;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import WindowFrame.Window;

public class Buffered3D {
	private BufferedImage img;
	private BufferStrategy bs;
	public int[] pixels;
	public Buffered3D(BufferedImage img, Window win)
	{
		this.img = img;
		pixels = ((DataBufferInt)img.getRaster().getDataBuffer()).getData();
		bs = win.getBufferStrategy();
		if(bs == null)
			win.createBufferStrategy(3);
		for(int i = 0; i < win.getHeight() * win.getWidth(); i++)
		{
				pixels[i] = 0;
		}
	}
	public BufferedImage getImg()
	{
		return img;
	}
	public void tFloorGen(int width, int height)
	{
		int[] pixel = new int[width*height];
		for(int y = 0; y < width; y++)
		{
			
		}
	}
}
