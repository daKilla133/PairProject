package Core;

public class Particle {

	public Point3D pt = new Point3D();
	public float pX, pZ, rotation, pRotation;
	public Particle()
	{
		pt.setLocation(0, 0, 0);
	}
	
	public void tick(int count)
	{
		if(count > 0)
		{
			System.out.println(count);
			pZ = 1;
			pt.setLocation(0, 0, pZ);
		}
	}
}
