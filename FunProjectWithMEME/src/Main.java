import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;


//import java.awt.image.DataBufferInt;
import Geometry.*;
import MathLogic.Vec3;
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
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		GlobalScope.mainWindow = new Window(600, 600, "3DTerrain");
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
		
			imgGraphics.setColor(Color.BLACK);
//			imgGraphics.fillRect(0, 0, GlobalScope.mainWindow.getWidth(), GlobalScope.mainWindow.getHeight());
			//	c.create3DSpace(GlobalScope.mainWindow.getGraphics());	
			Triangle triangle = new Triangle(new Vec3(1,1,2), new Vec3(2,2,5), new Vec3(4,4,4));
			triangle.render(imgGraphics, new Rectangle(50, 50, 300, 300));
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
