package WindowFrame;

import Geometry.CoordinateSystem3D;

public class ObjectHandler {
	private Object player;
	static final int VEL = 10;
	CoordinateSystem3D pos;
	
	public ObjectHandler()
	{
		player = new Object();
	}
	public void run(ObjectState key)
	{
		player.projectObject(key);
		if(player.getAction() == 1)
		{
		
		}
	}
	
	
	
}
