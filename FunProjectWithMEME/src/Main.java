import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;


//import java.awt.image.DataBufferInt;
import Geometry.*;
import WindowFrame.Window;
//import WindowFrame.WireFrame;
import Utils.GlobalScope;

public class Main {
	//	WireFrame frame;
	private CoordinateSystem3D c;
	public static void main(String[] args)
	{
		Main m = new Main();
		m.run();
	}

	private void init() {
		GlobalScope.mainWindow = new Window(800, 600, "3DTerrain");
		GlobalScope.mainWindow.createBufferStrategy(4);
		Window.index++;
		//win.addKeyListener(new Action());
		//Cube rect = new Cube();
		//frame = new WireFrame(rect, ((Graphics2D)win.getBufferStrategy().getDrawGraphics()));
		c = new CoordinateSystem3D();
	}
	public void run()
	{
		init();
		BufferedImage img = GlobalScope.mainWindow.getBufferedImage();
		Graphics imgGraphics = img.getGraphics();
		while(true)
		{
			//	c.create3DSpace(GlobalScope.mainWindow.getGraphics());	
			Triangle triangle = new Triangle(new Vec3(),new Vec3(0, 1, 0), new Vec3(0, 1, 2));
			for(int i = 0; i < GlobalScope.mainWindow.getWidth(); i++)
				for(int j = 0; j < GlobalScope.mainWindow.getHeight(); j++)
					img.setRGB(i, j, Color.black.getRGB());	
			triangle.render(imgGraphics);
			Graphics2D g = (Graphics2D)GlobalScope.mainWindow.getGraphics();
			g.drawImage(img, 0, 0,  GlobalScope.mainWindow.getWidth(), GlobalScope.mainWindow.getHeight(), null);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
