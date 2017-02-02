package Core;

import java.awt.event.KeyEvent;

public class Entity {
	public float xCom, yCom, zCom;
	public float pX, pY, pZ, rotation, pRotation;
	private Math3D m;
	public Entity(){
		m = new Math3D();
	}
	public void tick(boolean[] key, boolean[] mInput)
	{
		m.tick(key, mInput);
	}
	private class Math3D
	{
		public void tick(boolean[] key, boolean[] mouseInput)
		{
			boolean forward = key[KeyEvent.VK_W];
			boolean back = key[KeyEvent.VK_S];
			boolean left = key[KeyEvent.VK_A];
			boolean right = key[KeyEvent.VK_D];
			boolean jump = key[KeyEvent.VK_SPACE];
			boolean mL = mouseInput[1];
			boolean mR = mouseInput[1];
			move(forward, back, left, right, mL, mR, jump);
		}
		private void move(boolean forward, boolean back, boolean left, boolean right, boolean mDragLeft, boolean mDragRight, boolean jump)
		{
			float rotationSpeed = .025f;
			float walkSpeed = 2;
			float x = 0;
			float z = 0;
//			float y = 0;
			if(forward)
				z++;
			if(back)
				z--;
			if(left)
				x--;
			if(right)
				x++;
			if(mDragLeft)
				pRotation += rotationSpeed;
			if(mDragRight)
				pRotation -= rotationSpeed;

			pX = (float) (walkSpeed*(x*Math.cos(rotation)+z*Math.sin(rotation)));
			pZ = (float) (walkSpeed*(z*Math.cos(rotation)-x*Math.sin(rotation)));
			
			xCom += pX;
			zCom += pZ;
//			yCom += pY;
			pX *= .1f;
			pZ *= .1f;
			
			rotation += pRotation;
			pRotation *= .8f;
		}
	}
}
