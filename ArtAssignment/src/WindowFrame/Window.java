package WindowFrame;
import java.awt.Dimension;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Window extends JFrame{
	private static final long serialVersionUID = 1L;
	public static float time;
	private BufferedImage screen;
	public Window(Dimension size, String title)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(size);
		setTitle(title);
		screen = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_RGB);
		
		setLocationRelativeTo(null);
		
		setResizable(false);
		setVisible(true);
	}
	public Window(int width, int height, String title)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width, height);
		setTitle(title);
		screen = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
	
		setLocationRelativeTo(null);
		
		setResizable(false);
		setVisible(true);
	}
	public BufferedImage getBufferedImage()
	{	return screen;	}	
}
