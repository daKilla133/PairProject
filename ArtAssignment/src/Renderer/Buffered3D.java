package Renderer;
import java.awt.image.BufferedImage;

import Utils.GlobalScope;

public class Buffered3D {
	private BufferedImage img;
	public final int[] pixels;
	public Buffered3D(BufferedImage img)
	{
		pixels = new int[img.getWidth()*img.getHeight()];
		/*for(int i = 0; i < pixels.length; i++)
			pixels[i] = 0;*/
		this.img = img;
	}
	public void tFloor(Buffered3D b, float time)
	{	
		for(int y = 0; y < b.getImg().getHeight(); y++)
		{
			double yDepth = (y-b.getImg().getHeight()/2.0)/b.getImg().getHeight();

			yDepth = Math.abs(yDepth);
			GlobalScope.camera.pos.setZ((float)(4.0/yDepth));	
			Math.abs(yDepth);			
			for(int x = 0; x < b.getImg().getWidth(); x++)
			{
				double xDepth = (x-b.getImg().getWidth()/2.0)/b.getImg().getHeight();
				xDepth *= GlobalScope.camera.pos.getZ();
				int xx = (int)(xDepth*GlobalScope.camera.pos.getX());
				int yy = (int)(GlobalScope.camera.pos.getZ()*time)>>5;
				pixels[x+y*b.getImg().getWidth()] = xx+yy*32;
			}
		}
	}
	public BufferedImage getImg()
	{
		return img;
	}
}
