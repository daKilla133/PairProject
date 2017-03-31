package Renderer;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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
		float floorP = 10;
		float forward = Global.player.zCom;
		float right = Global.player.xCom;
		float rotation = Global.player.rotation;
		double cosine = Math.cos(rotation);
		double sine = Math.sin(rotation);
		
		for(int y = b.getImg().getHeight()/2; y < b.getImg().getHeight(); y++)
		{
			double yDepth = (y-b.getImg().getHeight()/2.0)/b.getImg().getHeight();
			yDepth = Math.abs(yDepth);
			float z = (float)(floorP/yDepth);	
			for(int x = 0; x < b.getImg().getWidth(); x++)
			{
				double xDepth = (x-b.getImg().getWidth()/2.0)/b.getImg().getHeight();
				xDepth *= z;
				double xx = xDepth*cosine+z*sine;
				double yy = z*cosine - xDepth*sine;
				int xPix = (int)(xx+right);
				int yPix = (int)(yy+forward);
				pixels[x+y*b.getImg().getWidth()] = ((xPix&15)*16|(yPix&15)*16)|6;
			}
		}
	}
	public BufferedImage drawSky(String filePath)
	{
		BufferedImage b = null;
		try {
			b = (ImageIO.read(new File(filePath)));
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return b;
	}
	public BufferedImage getImg()
	{
		return img;
	}
}
