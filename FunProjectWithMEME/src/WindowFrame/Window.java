package WindowFrame;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends JFrame{
	private static final long serialVersionUID = 1L;
	public static int index;
	public Window(Dimension size, String title)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(size);
		setTitle(title);
		this.createBufferStrategy(1);

		setLocationRelativeTo(null);
		setVisible(true);
	}
	public Window(int width, int height, String title)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width, height);
		setTitle(title);
		this.createBufferStrategy(1);

		setLocationRelativeTo(null);
		setVisible(true);
	}
	public void setScreen(boolean full)
	{
		if(full)
		{
			setExtendedState(JFrame.MAXIMIZED_BOTH); 
			setUndecorated(true);
		}
		else
			setUndecorated(false);
	}
}
