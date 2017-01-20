package Utils;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import WindowFrame.Window;

public class ConsoleWindow {

	public static boolean ts = true;
	public static void init()
	{
		GlobalScope.toolbar = new Window(300, 300, "Console");
		GlobalScope.toolbar.setLocation(GlobalScope.mainWindow.getWidth() - 300, GlobalScope.mainWindow.getHeight() - 300);
		JLabel label = new JLabel();
		label.setLayout(new GridLayout(8, 8));

		GlobalScope.toolbar.add(label);
		class KeyType implements KeyListener
		{
			public void keyPressed(KeyEvent k)
			{
				if(k.getKeyCode() == KeyEvent.VK_Z)
				{
					if(ts)
					{
						ConsoleWindow.close();	
						ts = false;
					}
					else {ConsoleWindow.open();	 ts = true;}
				}
			}

			public void keyReleased(KeyEvent k) {}

			public void keyTyped(KeyEvent k) {}

		}GlobalScope.toolbar.addKeyListener(new KeyType());
		GlobalScope.toolbar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void open()
	{
		GlobalScope.toolbar.setVisible(true);
	}
	public static void close()
	{
		GlobalScope.toolbar.setVisible(false);
	}
}
