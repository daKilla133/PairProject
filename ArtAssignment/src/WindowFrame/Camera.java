package WindowFrame;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Camera implements KeyListener, MouseMotionListener, MouseListener, FocusListener {

	public boolean[] key = new boolean[68836];
	
	public void mouseClicked(MouseEvent e) {}

	
	public void mouseEntered(MouseEvent e) {}

	
	public void mouseExited(MouseEvent e) {}

	
	public void mousePressed(MouseEvent e) {}

	
	public void mouseReleased(MouseEvent e) {}

	
	public void mouseDragged(MouseEvent e) {
	}

	
	public void mouseMoved(MouseEvent e) {}

	
	public void keyPressed(KeyEvent e) 
	{
		int keyCode = e.getKeyCode();
		if(keyCode > 0 && keyCode < key.length)
			key[keyCode] = true;
	}
	public void keyReleased(KeyEvent e) 
	{
		int keyCode = e.getKeyCode();
		if(keyCode > 0 && keyCode < key.length)
			key[keyCode] = false;
	}	
	public void keyTyped(KeyEvent e) {}

	public void focusGained(FocusEvent e) {}

	public void focusLost(FocusEvent e) 
	{
		for(boolean k : key)
			k = false;
	}

}
