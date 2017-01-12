package Utils;

import java.util.concurrent.locks.ReentrantLock;

import MathLogic.Vec3;
import WindowFrame.Camera;
import WindowFrame.Window;

public class GlobalScope {
	public static Window mainWindow;
	public static Window toolbar;
	public static ReentrantLock frameBufferLock = new ReentrantLock();
	public static ReentrantLock inputLock = new ReentrantLock();
	public static Camera camera = new Camera();
	public static final int MAX_W = 600;
	public static final int MAX_H = 600;
}
