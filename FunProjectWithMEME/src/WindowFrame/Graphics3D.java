package WindowFrame;

import java.awt.Graphics2D;

public abstract class Graphics3D extends Graphics2D{
	public abstract void xRotate(double theta);
	public abstract void yRotate(double theta);
	public abstract void zRotate(double theta);
	public abstract void translate();
}
