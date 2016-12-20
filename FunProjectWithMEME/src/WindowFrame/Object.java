package WindowFrame;

public class Object {

	private int state;
	private int action;
	public void projectObject(ObjectState key)
	{
		if(key == ObjectState.SPECTRE)
			state = 1;
		else if(key == ObjectState.SOLID)
			state = 2;
		else
			state = -1;
		if(key == ObjectState.SPECTRE)
			action = 1;
		else if(key == ObjectState.SPECTRE)
			action = 2;
		else
			action = -1;
	}
	public int getAction()
	{
		return action;
	}
	public int getState()
	{
		return state;
	}
	
}
