package Core;

import java.awt.event.KeyEvent;

public class Entity {
	public float xCom, yCom, zCom;
	public float pX, pZ, pY, rotation, pRotation;
	private Math3D m;
	public Entity(){
		m = new Math3D();
	}
	public void tick(boolean[] key)
	{
		m.tick(key);
	}
	private class Math3D
	{
		public void tick(boolean[] key)
		{
			boolean forward = key[KeyEvent.VK_W];
			boolean back = key[KeyEvent.VK_S];
			boolean left = key[KeyEvent.VK_A];
			boolean right = key[KeyEvent.VK_D];
			boolean jump = key[KeyEvent.VK_SPACE];
			boolean mL = key[KeyEvent.VK_LEFT];
			boolean mR = key[KeyEvent.VK_RIGHT];
			move(forward, back, left, right, mL, mR, jump);
		}
		private void move(boolean forward, boolean back, boolean left, boolean right, boolean mDragLeft, boolean mDragRight, boolean jump)
		{
			float rotationSpeed = .01f;
			float walkSpeed = 2;
			float x = 0;
			float z = 0;
			float y = 0;
			float gravity = 1;
			if(forward)
				z++;
			if(back)
				z--;
			if(left)
				x--;
			if(right)
				x++;
			if(jump)
				y++;
			if(mDragLeft)
				pRotation -= rotationSpeed;
			if(mDragRight)
				pRotation += rotationSpeed;

			pX = (float) (walkSpeed*(x*Math.cos(rotation)+z*Math.sin(rotation)));
			pZ = (float) (walkSpeed*(z*Math.cos(rotation)-x*Math.sin(rotation)));
			pY = (float) (-gravity*(y*Math.cos(rotation)-y*Math.sin(rotation)));
			xCom += pX;
			yCom += pY;
			zCom += pZ;
			pY *= .1f;
			pX *= .1f;
			pZ *= .1f;
			
			rotation += pRotation;
			pRotation *= .8f;
		}
	}
}
