package Renderer;

import MathLogic.Vec3;

public abstract class Graphics3D {
	public abstract void xRotate(double theta);
	public abstract void yRotate(double theta);
	public abstract void zRotate(double theta);
	public abstract void translate(Vec3 v);
}
