package WindowFrame;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

public class Window extends JFrame{
	private static final long serialVersionUID = 1L;
	public static int index;
	private BufferedImage screen;
	public Window(Dimension size, String title)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(size);
		setTitle(title);
		screen = new BufferedImage(size.width, size.height, BufferedImage.TYPE_4BYTE_ABGR);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public Window(int width, int height, String title)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width, height);
		setTitle(title);
		screen = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public Graphics2D getGraphics()
	{	return (Graphics2D) screen.getGraphics();	}
	public BufferedImage getBufferedImage()
	{	return screen;	}
	
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
