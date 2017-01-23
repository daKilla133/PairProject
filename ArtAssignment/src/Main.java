import java.awt.Toolkit;
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
	private void init() 
	{
		GlobalScope.mainWindow = new Window(
				(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
				(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight(),"3DTerrain");

		//		GlobalScope.mainWindow = new Window(400, 400, "3DTerrain");
		GlobalScope.mainWindow.createBufferStrategy(4);
		ConsoleWindow.init();

		GlobalScope.mainWindow.addKeyListener(GlobalScope.camera);
		GlobalScope.mainWindow.addMouseListener(GlobalScope.camera);
		Window.time = System.nanoTime();
		//Cube rect = new Cube();
		//frame = new WireFrame(rect, ((Graphics2D)win.getBufferStrategy().getDrawGraphics()));
		//c = new CoordinateSystem3D();
	}

	private long lastTime;
	private double fps;
	private boolean run = false;
	
	public double fps()
	{	return fps;	} 
	public void run()
	{
		init();
		GlobalScope.frames = fps();

		Graphics3D imgGraphics;
		Buffered3D b;
		b = new Buffered3D(GlobalScope.mainWindow.getBufferedImage());
		imgGraphics = new Graphics3D(b);
		float i = 0;
		while(run)
		{
			Window.time = System.nanoTime();
			i+=.35;
			//	imgGraphics.bf.tFloorGen(GlobalScope.mainWindow.getWidth(), GlobalScope.mainWindow.getHeight(), GlobalScope.camera.pos);
			//	Triangle triangle = new Triangle(GlobalScope.camera.pos, new Vec3(2,2,5), new Vec3(4,4,4));
			imgGraphics.render(0, 0, GlobalScope.mainWindow.getWidth(), GlobalScope.mainWindow.getHeight(),i);
			lastTime = System.nanoTime();
			try{
				Thread.sleep(2);
			}
			catch (InterruptedException e){}
			fps = 1000000000.0 / (System.nanoTime() - lastTime); 
			GlobalScope.frames = fps();
			lastTime = System.nanoTime();
			//triangle.render(imgGraphics.getGr(), new Rectangle(0, 0, GlobalScope.mainWindow.getWidth(), GlobalScope.mainWindow.getHeight()));

			//Noise n = new Noise(new Random().nextInt());
			//int x = (int)(GlobalScope.mainWindow.getWidth()*n.noise(Window.time, 0));

		}
		stop();
	}

}
