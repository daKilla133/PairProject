package Renderer;
import java.awt.Color;
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
	public void tFloor(Buffered3D b, float time)
	{	
		for(int y =  0; y < b.getImg().getHeight(); y++)
		{
			double yDepth = (y-b.getImg().getHeight()/2.0)/b.getImg().getHeight();

			yDepth = Math.abs(yDepth);
			Global.camera.pos.setZ((float)(4.0/yDepth));	
			Math.abs(yDepth);			
			for(int x = 0; x < b.getImg().getWidth(); x++)
			{
				double xDepth = (x-b.getImg().getWidth()/2.0)/b.getImg().getHeight();
				xDepth *= Global.camera.pos.getZ();
//				int xx = (int)(xDepth*Global.camera.pos.getX()*Math.cos(time/100)+Global.camera.pos.getZ()*Math.sin(time/100));
				int xx = (int)(xDepth*Global.camera.pos.getX() +Global.camera.pos.getZ());
				int yy = (int)(yDepth*Global.camera.pos.getY() +Global.camera.pos.getZ());
//				int yy = (int)(-Global.camera.pos.getZ()*Math.sin(time/100)+xDepth*Global.camera.pos.getX()*Math.cos(time/100));
				pixels[x+y*b.getImg().getWidth()] = (xx+yy*22);
			}
		}
	}
	public BufferedImage getImg()
	{
		return img;
	}
}
