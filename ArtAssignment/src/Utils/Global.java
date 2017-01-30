package Utils;

import java.util.concurrent.locks.ReentrantLock;

import MathLogic.Vec3;
import WindowFrame.Camera;
import WindowFrame.Window;

public class Global {
	public static Window mainWindow;
	public static Window toolbar;
	public static ReentrantLock frameBufferLock = new ReentrantLock();
	public static ReentrantLock inputLock = new ReentrantLock();
	public static Camera camera = new Camera();
	public static double frames;
	public static Thread main;
}
