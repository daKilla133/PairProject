package Utils;

import java.util.concurrent.locks.ReentrantLock;

import MathLogic.Vec3;
import WindowFrame.Camera;
import WindowFrame.Window;

public class GlobalScope {
	public static Window mainWindow;
	public static ReentrantLock frameBufferLock = new ReentrantLock();
	public static ReentrantLock inputLock = new ReentrantLock();
	public static Camera camera = new Camera();
	public static Vec3 center = new Vec3(0, 0, 0);
}
