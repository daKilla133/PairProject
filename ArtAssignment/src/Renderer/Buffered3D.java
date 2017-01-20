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
			pixels[i] = r.nextInt();
		tFloorGenerate(this, 25, 25);
		this.img = img;
	}
	public void tFloorGenerate(Buffered3D b, int xOffset, int yOffset)
	{
		for(int y = 0; y < img.getHeight(); y++)
		{
			int yPix = y + yOffset;
			if(yPix < 0 || yPix >= b.getImg().getHeight())
				continue;
			for(int x = 0; x < img.getWidth(); x++)
			{
				int xPix = x + xOffset;
				if(xPix < 0 || xPix >= b.getImg().getWidth())
					continue;
				pixels[xPix + yPix*(int)img.getWidth()] = b.pixels[x+y*(int)b.getImg().getWidth()];
			}
		}
	}
	public BufferedImage getImg()
	{
		return img;
	}
}
