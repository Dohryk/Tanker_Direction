package TankGit.day7.bf.tanks;

import TankGit.day7.Direction;
import TankGit.day7.bf.Destroyable;
import TankGit.day7.bf.Drawable;

public interface Tank extends Drawable, Destroyable {
	
	public Action setUp();

	public void move();

	public Bullet fire();

	public int getX();

	public int getY();
	
	public Direction getDirection();
	
	public void updateX(int x);

	public void updateY(int y);
	
	public int getSpeed();
	
	public int getMovePath();

	public void attackEagle() throws Exception;
}
