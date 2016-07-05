package TankGit.day7.bf.tanks;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import TankGit.day7.Direction;
import TankGit.day7.bf.BattleField;

import javax.imageio.ImageIO;

public class T34 extends AbstractTank {
	
	public T34(BattleField bf) {
		super(bf, 128, 512, Direction.UP);
		tankColor = new Color(0, 255, 0);
		towerColor = new Color(200, 65, 194);
		setImages();
	}
	
	public T34(BattleField bf, int x, int y, Direction direction) {
		super(bf, x, y, direction);
		tankColor = new Color(0, 255, 0);
		towerColor = new Color(200, 65, 194);
		setImages();
	}

	private Object[] actoins = new Object[] {
		Direction.UP,
		Action.FIRE,
		Action.MOVE,
		Action.FIRE,
		Action.MOVE,
		Action.FIRE,
		Action.FIRE
	};

	private void setImages(){
		image = new Image[4];
		try {
			image[0]= ImageIO.read(new File("src/TankGit/day7/img/t34_up.png").getAbsoluteFile());
			image[1]= ImageIO.read(new File("src/TankGit/day7/img/t34_down.png").getAbsoluteFile());
			image[2]= ImageIO.read(new File("src/TankGit/day7/img/t34_left.png").getAbsoluteFile());
			image[3]= ImageIO.read(new File("src/TankGit/day7/img/t34_right.png").getAbsoluteFile());
		} catch (IOException e) {
			System.err.println("Can't find image of tank");
		}
	}
	
	private int step = 0;
	
	@Override
	public Action setUp() {
		if (step >= actoins.length) {
			step = 0;
		}
		if (!(actoins[step] instanceof Action)) {
			turn((Direction) actoins[step++]);
		}
		if (step >= actoins.length) {
			step = 0;
		}
		return (Action) actoins[step++];
	}

	@Override
	public void attackEagle() throws Exception {

	}
}
