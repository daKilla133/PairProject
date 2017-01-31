import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.Random;

import Geometry.Triangle;
import MathLogic.Noise;
import MathLogic.Vec3;
import Renderer.Buffered3D;
import Renderer.Graphics3D;
import WindowFrame.Window;
import Utils.ConsoleWindow;
import Utils.Global;

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
		Global.main = new Thread(this);
		Global.main.start();
	}
	private void stop()
	{
		if(!run)
			return;
		run = false;
		try {
			Global.main.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	private void init() 
	{
		Global.mainWindow = new Window(
				(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
				(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight(),"3DTerrain");
//		Global.mainWindow = new Window(300, 300, "3DTerrain");
		Global.mainWindow.createBufferStrategy(4);
		//ConsoleWindow.init();

		Global.mainWindow.addKeyListener(Global.camera);
		Global.mainWindow.addMouseListener(Global.camera);
		Window.time = System.nanoTime();
	}

	private long lastTime;
	private double fps;
	private boolean run = false;
	
	public double fps()
	{	return fps;	} 
	public void run()
	{
		init();
		Global.frames = fps();

		Graphics3D imgGraphics;
		Buffered3D b;
		b = new Buffered3D(Global.mainWindow.getBufferedImage());
		imgGraphics = new Graphics3D(b);
		float time = 0;
		while(run)
		{
			Window.time = System.nanoTime();
			imgGraphics.render(0, 0, Global.mainWindow.getWidth(), Global.mainWindow.getHeight(), time);
//			t.render(imgGraphics, new Rectangle(0, 0, Global.mainWindow.getWidth(), Global.mainWindow.getHeight()));
			lastTime = Window.time;
			fps = 1000000000.0 / (System.nanoTime() - lastTime); 
			Global.frames = fps();
			lastTime = System.nanoTime();
			//Noise n = new Noise(new Random().nextInt());
			//int x = (int)(GlobalScope.mainWindow.getWidth()*n.noise(Window.time, 0));
		}
		stop();
	}

}
