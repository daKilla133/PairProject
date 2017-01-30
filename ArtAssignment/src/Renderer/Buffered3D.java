package Renderer;
import java.awt.Color;
import java.awt.image.BufferedImage;

import Geometry.Triangle;
import MathLogic.Vec3;
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
		for(int y = b.getImg().getHeight()/2; y < b.getImg().getHeight(); y++)
		{
			for(int x = 0; x < b.getImg().getWidth(); x++)
			{
//				int xx = (int)(Global.camera.pos.getX() / Global.camera.pos.getZ());
//				int yy = (int)(Global.camera.pos.getY() / Global.camera.pos.getZ());
				Tri3D(new Vec3(), new Vec3(), new Vec3(), Color.MAGENTA);
//				pixels[x+y*b.getImg().getWidth()] = 156;
			}
		}
		/*for(int y = 0; y < b.getImg().getHeight(); y++)
		{
			double yDepth = (y-b.getImg().getHeight()/2.0)/b.getImg().getHeight();

			yDepth = Math.abs(yDepth);
			Global.camera.pos.setZ((float)(4.0/yDepth));	
			Math.abs(yDepth);			
			for(int x = 0; x < b.getImg().getWidth(); x++)
			{
				double xDepth = (x-b.getImg().getWidth()/2.0)/b.getImg().getHeight();
				xDepth *= Global.camera.pos.getZ();
				int xx = (int)(xDepth*Global.camera.pos.getX()*Math.cos(time/100)+Global.camera.pos.getZ()*Math.sin(time/100));
				int yy = (int)(-Global.camera.pos.getZ()*Math.sin(time/100)+xDepth*Global.camera.pos.getX()*Math.cos(time/100));
				pixels[x+y*b.getImg().getWidth()] = (xx+yy*32)&34;
			}
		}*/
	}
	private void addLine(int x, int y, int xx, int yy, Color c)
	{
		if(x > xx)
		{
			int temp = x;
			x = xx;
			xx = temp;
		}
		if(y > yy)
		{
			int temp = y;
			y = yy;
			yy = temp;
		}
		for(int j = y; j < yy;)
			for(int i = x; i < xx; i ++, j++)
				pixels[i + j*img.getWidth()] = c.getRGB(); 
		//Template generated for reference.
	}
	public void Tri3D(Vec3 p1, Vec3 p2, Vec3 p3, Color c)
	{
		addLine(5, 5, 125, 125, c);
		//get z depth by home alg.
	}
	public BufferedImage getImg()
	{
		return img;
	}
}
