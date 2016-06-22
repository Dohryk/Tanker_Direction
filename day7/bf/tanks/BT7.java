package TankGit.day7.bf.tanks;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import TankGit.day7.Direction;
import TankGit.day7.bf.BattleField;

import javax.imageio.ImageIO;

public class BT7 extends AbstractTank {

	private int step = 0;

	private Object[] actoins = new Object[] {
			Action.MOVE,
			Action.ATTACK,
			Action.FIRE
	};
	
	public BT7(BattleField bf) {
		super(bf);
		tankColor = new Color(255, 0, 0);
		towerColor = new Color(0, 255, 0);
		movePath = 2;
		setImages();
	}
	
	public BT7(BattleField bf, int x, int y, Direction direction) {
		super(bf, x, y, direction);
		tankColor = new Color(255, 0, 0);
		towerColor = new Color(0, 255, 0);
		movePath = 2;
		setImages();
	}

	private void setImages(){
		image = new Image[4];
		try {
			image[0]= ImageIO.read(new File("D:\\PAndA\\My_Java\\Tanker\\src\\TankGit\\day7\\img\\bt7_up.png").getAbsoluteFile());
			image[1]= ImageIO.read(new File("D:\\PAndA\\My_Java\\Tanker\\src\\TankGit\\day7\\img\\bt7_down.png").getAbsoluteFile());
			image[2]= ImageIO.read(new File("D:\\PAndA\\My_Java\\Tanker\\src\\TankGit\\day7\\img\\bt7_left.png").getAbsoluteFile());
			image[3]= ImageIO.read(new File("D:\\PAndA\\My_Java\\Tanker\\src\\TankGit\\day7\\img\\bt7_right.png").getAbsoluteFile());
		} catch (IOException e) {
			System.err.println("Can't find image of tank");
		}
	}
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

	public void attackEagle() throws Exception {
		String eagleQuadrant = super.getBf().getEagleLocation();
		int v = Integer.parseInt(eagleQuadrant.split("_")[0]);
		int h = Integer.parseInt(eagleQuadrant.split("_")[1]);
		moveToQuadrant(v,h);
	}

}
