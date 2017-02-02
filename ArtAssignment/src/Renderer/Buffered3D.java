package Renderer;
import java.awt.image.BufferedImage;

import Utils.Global;

public class Buffered3D {
	private BufferedImage img;
	public final int[] pixels;
	public Buffered3D(BufferedImage img)
	{
		pixels = new int[img.getWidth()*img.getHeight()];
		this.img = img;
	}
	public void gFloor(Buffered3D b, float time)
	{	
		float floorP = 8;
		float forward = Global.player.zCom;
		float right = Global.player.xCom;
		float rotation = Global.player.rotation;
		
		for(int y = b.getImg().getHeight()/2; y < b.getImg().getHeight(); y++)
		{
			double yDepth = (y-b.getImg().getHeight()/2.0)/b.getImg().getHeight();
			yDepth = Math.abs(yDepth);
			float z = (float)(floorP/yDepth);	
			for(int x = 0; x < b.getImg().getWidth(); x++)
			{
				double xDepth = (x-b.getImg().getWidth()/2.0)/b.getImg().getHeight();
				xDepth *= z;
				double xx = xDepth*Math.cos(rotation)+z*Math.sin(rotation);
				double yy = z*Math.cos(rotation)-xDepth*Math.sin(rotation);
				int xPix = (int)(xx+right);
				int yPix = (int)(yy+forward);
				pixels[x+y*b.getImg().getWidth()] = ((xPix&15)*16|(yPix&15)*16)>>1;
			}
		}
	}
	public BufferedImage getImg()
	{
		return img;
	}
}
