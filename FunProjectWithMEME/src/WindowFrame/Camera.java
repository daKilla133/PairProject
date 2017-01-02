package WindowFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import Geometry.Vec3;
import Utils.GlobalScope;

public class Camera implements KeyListener, MouseMotionListener, MouseListener
{
	public Vec3 pos = new Vec3();
	public float pitch;
	public float yaw;
	public float roll;

	private float sensitivity = 0.005f;
	private float speed = 1.f;

	private int lastX;
	private int lastY;
	private boolean pressed = false;

	public void setSensitivity(float sensitivity)
	{
		this.sensitivity = sensitivity;
	}

	public void setSpeed(float speed)
	{
		this.speed = speed;
	}

	public void keyPressed(KeyEvent k) 
	{
		GlobalScope.inputLock.lock();
		if(k.getKeyCode() == KeyEvent.VK_A)
		{
			Vec3 direction = Vec3.eulerConversion(yaw + (float)(Math.PI / 2.f), 0, roll, speed);
			pos.setLocation(pos.getX()+direction.getX(), pos.getY()+direction.getY(), pos.getZ()+direction.getZ());
		}
		if(k.getKeyCode() == KeyEvent.VK_D)
		{
			Vec3 direction = Vec3.eulerConversion(yaw + (float)(Math.PI / 2.f), 0, roll, speed);
			pos.setLocation(pos.getX()-direction.getX(), pos.getY()-direction.getY(), pos.getZ()-direction.getZ());

		}
		if(k.getKeyCode() == KeyEvent.VK_W)
		{
			Vec3 direction =  Vec3.eulerConversion(yaw, pitch, roll, speed);
			pos.setLocation(pos.getX()+direction.getX(), pos.getY()+direction.getY(), pos.getZ()+direction.getZ());
		}
		if(k.getKeyCode() == KeyEvent.VK_S)
		{
			Vec3 direction = Vec3.eulerConversion(yaw, pitch, roll, speed);
			pos.setLocation(pos.getX()-direction.getX(), pos.getY()-direction.getY(), pos.getZ()-direction.getZ());
		}

		GlobalScope.inputLock.unlock();
	}

	public void keyReleased(KeyEvent k) {}

	public void keyTyped(KeyEvent k) {}

	public void mouseDragged(MouseEvent e) 
	{
		if(pressed)
		{
			pressed = false;
			lastX = e.getXOnScreen();
			lastY = e.getYOnScreen();
		}
		GlobalScope.inputLock.lock();
		pitch += (float)(e.getYOnScreen() - lastY) * sensitivity;
		yaw -= (float)(e.getXOnScreen() - lastX) * sensitivity;
		if(pitch < -(Math.PI / 2.f))
			GlobalScope.camera.pitch = (float) (-Math.PI / 2.f);
		if(pitch > (Math.PI / 2.f))
			pitch = (float) (Math.PI / 2.f);

		GlobalScope.inputLock.unlock();
		lastX = e.getXOnScreen();
		lastY = e.getYOnScreen();
	}

	public void mouseMoved(MouseEvent e) {}

	public void mouseClicked(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}

	public void mousePressed(MouseEvent e) 
	{
		pressed = true;
	}
}
