import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
		Graphics2D imgGraphics = (Graphics2D)img.getGraphics();
		
		while(true)
		{
			imgGraphics.setColor(Color.BLACK);
//			imgGraphics.fillRect(0, 0, GlobalScope.mainWindow.getWidth(), GlobalScope.mainWindow.getHeight());
			//	c.create3DSpace(GlobalScope.mainWindow.getGraphics());	
			imgGraphics.fillRect(0, 0, GlobalScope.mainWindow.getWidth(), GlobalScope.mainWindow.getHeight());
			imgGraphics.setColor(Color.white);
//			imgGraphics.draw
			Triangle triangle = new Triangle(new Vec3(), new Vec3(2,2,5), new Vec3(4,4,4));
			for(int y = 0; y < 600; y += 50){
				for(int x = 0; x < 600; x += 50)
//					imgGraphics.drawRect(x, y, 50, 50);
					triangle.render(imgGraphics, new Rectangle(x, y, 50, 50));
			}
//			imgGraphics.rotate(Math.PI/3);
			imgGraphics.rotate(0, 0, Math.PI/3);
//			GlobalScope.center.Rotate(GlobalScope.center, 60, 0, 0);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
