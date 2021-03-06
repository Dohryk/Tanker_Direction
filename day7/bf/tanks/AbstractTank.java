package TankGit.day7.bf.tanks;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import TankGit.day7.ActionField;
import TankGit.day7.Direction;
import TankGit.day7.bf.BattleField;

import javax.imageio.ImageIO;

public abstract class AbstractTank implements Tank {
	
	private int speed = 10;
	protected int movePath = 1;
	protected Image[] image;
	protected String tankName;
	protected ActionField actionField;
	private static String IMAGE_NAME = "src/TankGit/day7/img/";

	// 1 - up, 2 - down, 3 - left, 4 - right
	private Direction direction;

	// current position on BF
	private int x;
	private int y;
	
	private boolean destroyed;
	
	private BattleField bf;
	
	protected Color tankColor;
	protected Color towerColor;
	
	public AbstractTank(BattleField bf) {
		this(bf, 128, 512, Direction.UP);
	}
	
	public AbstractTank(BattleField bf, int x, int y, Direction direction) {
		this.bf = bf;
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.destroyed = false;
		turn(direction);
	}

	public void turn(Direction direction) {
		this.direction = direction;

	}

	public void move() {
	}
	
	public Bullet fire() {
		int bulletX = -100;
		int bulletY = -100;
		if (direction == Direction.UP) {
			bulletX = x + 25;
			bulletY = y - 64;
		} else if (direction == Direction.DOWN) {
			bulletX = x + 25;
			bulletY = y + 64;
		} else if (direction == Direction.LEFT) {
			bulletX = x - 64;
			bulletY = y + 25;
		} else if (direction == Direction.RIGHT) {
			bulletX = x + 64;
			bulletY = y + 25;
		}
		return new Bullet(bulletX, bulletY, direction);
	}
	
	public void draw(Graphics g) {
		if (!destroyed) {
			g.setColor(tankColor);

			if (image != null) {
				g.drawImage(image[getDirection().getId()],x,y, new ImageObserver() {
					@Override
					public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
						return false;
					}
				});
			}
			else {
				g.fillRect(this.getX(), this.getY(), 64, 64);

				g.setColor(towerColor);
				if (this.getDirection() == Direction.UP) {
					g.fillRect(this.getX() + 20, this.getY(), 24, 34);
				} else if (this.getDirection() == Direction.DOWN) {
					g.fillRect(this.getX() + 20, this.getY() + 30, 24, 34);
				} else if (this.getDirection() == Direction.LEFT) {
					g.fillRect(this.getX(), this.getY() + 20, 34, 24);
				} else {
					g.fillRect(this.getX() + 30, this.getY() + 20, 34, 24);
				}
			}
		}
	}
	
	@Override
	public boolean isDestroyed() {
		return destroyed;
	}

	public void destroy() {
		destroyed = true;
	}
	
	public void moveToQuadrant(int v, int h) throws Exception {
		String coordinates = bf.getQuadrantXY(v, h);
		int y = Integer.parseInt(coordinates.split("_")[0]);
		int x = Integer.parseInt(coordinates.split("_")[1]);

		if (this.x < x) {
			while (this.x != x) {
				turn(Direction.RIGHT);
				fire();
				move();
			}
		} else {
			while (this.x != x) {
				turn(Direction.LEFT);
				fire();
				move();
			}
		}

		if (this.y < y) {
			while (this.y != y) {
				turn(Direction.DOWN);
				fire();
				move();
			}
		} else {
			while (this.y != y) {
				turn(Direction.UP);
				fire();
				move();
			}
		}
	}
	
	public void moveRandom() throws Exception { 
	}

	public void clean() throws Exception {
	}

	public void updateX(int x) {
		this.x += x;
	}

	public void updateY(int y) {
		this.y += y;
	}

	public Direction getDirection() {
		return direction;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	@Override
	public int getMovePath() {
		return movePath;
	}

	public BattleField getBf() {
		return bf;
	}
}