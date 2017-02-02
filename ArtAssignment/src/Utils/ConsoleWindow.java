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
		Global.toolbar = new Window(300, 300, "Console");
		Global.toolbar.setLocation(Global.mainWindow.getWidth() - 300, Global.mainWindow.getHeight() - 300);
		JLabel label = new JLabel();
		label.setLayout(new GridLayout(8, 8));

		Global.toolbar.add(label);
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

		}Global.toolbar.addKeyListener(new KeyType());
		roam.addActionListener(new KeyType());
		Global.toolbar.add(roam);
		Global.toolbar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void open()
	{
		Global.toolbar.setVisible(true);
	}
	public static void close()
	{
		Global.toolbar.setVisible(false);
	}
}
