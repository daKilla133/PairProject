package Renderer;

import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.Raster;
import java.util.Random;

import MathLogic.Vec3;
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
	public void tFloorGen(int width, int height, Vec3 c)
	{
		int[] pixel = new int[width*height];
		Random r = new Random();
		for(int i = 0; i < height*width; i++)
		{
			pixel[i] = r.nextInt();
		}
		pixels = pixel;
		bs.getDrawGraphics().drawImage(img, width, height, null);
	}
}
