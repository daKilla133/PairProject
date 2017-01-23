package Utils;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import WindowFrame.Window;

public class ConsoleWindow {

	public static boolean ts = true;
	private static JCheckBox roam;
	public static void init()
	{
		GlobalScope.toolbar = new Window(300, 300, "Console");
		GlobalScope.toolbar.setLocation(GlobalScope.mainWindow.getWidth() - 300, GlobalScope.mainWindow.getHeight() - 300);
		JLabel label = new JLabel();
		label.setLayout(new GridLayout(8, 8));

		GlobalScope.toolbar.add(label);
		roam = new JCheckBox("Roam");
		roam.setToolTipText("Free Scroll");
		class KeyType implements ActionListener, KeyListener
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

			public void actionPerformed(ActionEvent a)
			{
//				if(a.getID()==roam.getAction().);
			}

		}GlobalScope.toolbar.addKeyListener(new KeyType());
		roam.addActionListener(new KeyType());
		GlobalScope.toolbar.add(roam);
		GlobalScope.toolbar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void run()
	{
		
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
