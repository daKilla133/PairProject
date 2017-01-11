import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.Random;

//import java.awt.image.DataBufferInt;
import Geometry.*;
import MathLogic.Noise;
import Renderer.Buffered3D;
import Renderer.Graphics3D;
import WindowFrame.Window;
//import WindowFrame.WireFrame;
import Utils.GlobalScope;

public class Main {
//		WireFrame frame;
//	private CoordinateSystem3D c;
	public static void main(String[] args)
	{
		Main m = new Main();
		m.run();
	}

	private void init() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		GlobalScope.mainWindow = new Window(600, 600, "3DTerrain");
		GlobalScope.mainWindow.createBufferStrategy(4);
		Window.time = 0;
		//win.addKeyListener(new Action());
		//Cube rect = new Cube();
		//frame = new WireFrame(rect, ((Graphics2D)win.getBufferStrategy().getDrawGraphics()));
//		c = new CoordinateSystem3D();
	}
	public void run()
	{
		init();
		BufferedImage img = GlobalScope.mainWindow.getBufferedImage();
		Graphics3D imgGraphics = new Graphics3D(new Buffered3D(img));

//		imgGraphics.rotate(Math.PI/6);
		while(true)
		{
			imgGraphics.getGr().clearRect(0, 0, GlobalScope.mainWindow.getWidth(), GlobalScope.mainWindow.getHeight());
			imgGraphics.getGr().setColor(Color.white);
//			Triangle triangle = new Triangle(new Vec3(), new Vec3(2,2,5), new Vec3(4,4,4));
			for(int y = 0; y < 600; y += 50){
				for(int x = 0; x < 600; x += 50);
//					imgGraphics.drawRect(x, y, 50, 50);
//					triangle.render(imgGraphics, new Rectangle(x, y, 50, 50));
			}
			Noise n = new Noise(new Random().nextInt());
			int x = (int)(GlobalScope.mainWindow.getWidth()*n.noise(Window.time, 0));
		
//			imgGraphics.clearRect(0, 0, GlobalScope.mainWindow.getWidth(), GlobalScope.mainWindow.getHeight());
			GlobalScope.mainWindow.repaint();
//			GlobalScope.center.Rotate(GlobalScope.center, 60, 0, 0);
			try {
				Window.time += .01;
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
