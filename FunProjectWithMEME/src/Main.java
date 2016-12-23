import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Geometry.*;
import WindowFrame.Window;
import WindowFrame.WireFrame;

public class Main {
	Window win;
//	WireFrame frame;
	CoordinateSystem3D c;
	public static void main(String[] args)
	{
		Main m = new Main();
		m.run();
	}
	private void init() {
		 win = new Window(800, 600, "3DTerrain");
		 win.addKeyListener(new Action());
//		 Cube rect = new Cube();
//		 frame = new WireFrame(rect, ((Graphics2D)win.getBufferStrategy().getDrawGraphics()));
		 c = new CoordinateSystem3D(win);
	}
	public void run()
	{
		init();
		while(true)
		{
//			frame.render();
			c.create3DSpace(win);	
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	private class Action implements ActionListener, KeyListener
	{
		public void keyPressed(KeyEvent k) 
		{
			int key = k.getKeyCode();
			switch(key)
			{
			case KeyEvent.VK_W:
				System.out.println("Foward");
				break;
			case KeyEvent.VK_S:
				System.out.println("Backwards");
				break;
			case KeyEvent.VK_A:
				System.out.println("Left");
				break;
			case KeyEvent.VK_D:
				System.out.println("Right");
				break;
			}
		}
		public void keyReleased(KeyEvent k) 
		{
		}

		public void keyTyped(KeyEvent k) 
		{
		}

		public void actionPerformed(ActionEvent arg) 
		{
		}
		
	}
}
