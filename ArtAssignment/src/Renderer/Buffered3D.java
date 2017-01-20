package Renderer;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Buffered3D {
	private BufferedImage img;
	public final int[] pixels;
	public Buffered3D(BufferedImage img)
	{
		pixels = new int[img.getWidth()*img.getHeight()];
		Random r = new Random();
		for(int i = 0; i < pixels.length; i++)
			pixels[i] = 500;
		this.img = img;
	}
	public void tFloor(Buffered3D b, int xOffset, int yOffset)
	{	
		for(int y = 0; y < b.getImg().getHeight(); y++)
		{
			int yPix = y + yOffset;
			if(yPix < 0 || yPix >= img.getHeight())
				continue;
			for(int x = 0; x < b.getImg().getWidth(); x++)
			{
				int xPix = x + xOffset;
				if(xPix < 0 || xPix >= b.getImg().getWidth())
					continue;
				pixels[xPix + yPix*img.getWidth()] = b.pixels[x+y*(int)b.getImg().getWidth()];
			}
		}
	}
	public BufferedImage getImg()
	{
		return img;
	}
}
