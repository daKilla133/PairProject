import java.awt.Rectangle;
//import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.Random;

import Geometry.Triangle;
import MathLogic.Noise;
import MathLogic.Vec3;
import Renderer.Buffered3D;
import Renderer.Graphics3D;
import WindowFrame.Window;
import Utils.ConsoleWindow;
//import WindowFrame.WireFrame;
import Utils.GlobalScope;

public class Main implements Runnable{
	
	private boolean run = false;
	public static void main(String[] args)
	{
		Main m = new Main();
		m.start();
	}
	private void start()
	{
		if(run)
			return;
		run = true;
		GlobalScope.main = new Thread(this);
		GlobalScope.main.start();
	}
	private void stop()
	{
		if(!run)
			return;
		run = false;
		try {
			GlobalScope.main.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	private void init() {
		GlobalScope.mainWindow = new Window(600, 600, "3DTerrain");
		GlobalScope.mainWindow.createBufferStrategy(4);
		GlobalScope.mainWindow.addKeyListener(GlobalScope.camera);
		GlobalScope.mainWindow.addMouseListener(GlobalScope.camera);
		
		ConsoleWindow.init();
		Window.time = 0;
		//Cube rect = new Cube();
		//frame = new WireFrame(rect, ((Graphics2D)win.getBufferStrategy().getDrawGraphics()));
		//c = new CoordinateSystem3D();
	}
	public void run()
	{
		init();
		Graphics3D imgGraphics;
		while(run)
		{
			BufferedImage img = GlobalScope.mainWindow.getBufferedImage();
			imgGraphics = new Graphics3D(new Buffered3D(img, GlobalScope.mainWindow));
			imgGraphics.getGr().clearRect(0, 0, GlobalScope.mainWindow.getWidth(), GlobalScope.mainWindow.getHeight());
//			imgGraphics.bf.tFloorGen(GlobalScope.mainWindow.getWidth(), GlobalScope.mainWindow.getHeight(), GlobalScope.camera.pos);
			Triangle triangle = new Triangle(GlobalScope.camera.pos, new Vec3(2,2,5), new Vec3(4,4,4));
		
//			imgGraphics.getGr().drawRect(x, y, 50, 50);
			triangle.render(imgGraphics.getGr(), new Rectangle(0, 0, GlobalScope.mainWindow.getWidth(), GlobalScope.mainWindow.getHeight()));
//			imgGraphics.XRotate((float)Math.PI/3);
			
//			Noise n = new Noise(new Random().nextInt());
//			int x = (int)(GlobalScope.mainWindow.getWidth()*n.noise(Window.time, 0));
			GlobalScope.mainWindow.repaint();
			try {
				Window.time += .01;
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
				stop();
			}
		}
		stop();
	}

}
