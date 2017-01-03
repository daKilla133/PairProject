import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

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

		while(true)
		{
			//	c.create3DSpace(GlobalScope.mainWindow.getGraphics());	
			BufferedImage img = GlobalScope.mainWindow.getBufferedImage();
			
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
