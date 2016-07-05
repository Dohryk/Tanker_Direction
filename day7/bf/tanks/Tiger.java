package TankGit.day7.bf.tanks;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import TankGit.day7.Direction;
import TankGit.day7.bf.BattleField;

import javax.imageio.ImageIO;

public class Tiger extends AbstractTank {
	
	private int armor;
	
	public Tiger(BattleField bf) {
		super(bf);
		tankColor = new Color(255, 0, 0);
		towerColor = new Color(0, 255, 0);
		armor = 1;
		setImages();
	}
	
	public Tiger(BattleField bf, int x, int y, Direction direction) {
		super(bf, x, y, direction);
		tankColor = new Color(255, 0, 0);
		towerColor = new Color(0, 255, 0);
		armor = 1;
		setImages();
	}

	private void setImages(){
		image = new Image[4];
		try {
			image[0]= ImageIO.read(new File("src/TankGit/day7/img/tiger_up.png").getAbsoluteFile());
			image[1]= ImageIO.read(new File("src/TankGit/day7/img/tiger_down.png").getAbsoluteFile());
			image[2]= ImageIO.read(new File("src/TankGit/day7/img/tiger_left.png").getAbsoluteFile());
			image[3]= ImageIO.read(new File("src/TankGit/day7/img/tiger_right.png").getAbsoluteFile());
		} catch (IOException e) {
			System.err.println("Can't find image of tank");
		}
	}

	@Override
	public void destroy() {
		if (armor > 0) {
			armor--;
		} else {
			super.destroy();
		}
	}
	
	@Override
	public Action setUp() {
		return Action.FIRE;
	}

	@Override
	public void attackEagle() throws Exception {

	}
}
