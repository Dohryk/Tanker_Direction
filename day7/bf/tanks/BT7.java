package TankGit.day7.bf.tanks;

import java.awt.Color;

import TankGit.day7.Direction;
import TankGit.day7.bf.BattleField;

public class BT7 extends AbstractTank {

	private int step = 0;

	private Object[] actoins = new Object[] {
			Action.MOVE,
			Action.ATTACK,
			Action.FIRE
	};
	
	public BT7(BattleField bf) {
		super(bf, "bt7");
		tankColor = new Color(255, 0, 0);
		towerColor = new Color(0, 255, 0);
		movePath = 2;
	}
	
	public BT7(BattleField bf, int x, int y, Direction direction) {
		super(bf, x, y, direction, "bt7");
		tankColor = new Color(255, 0, 0);
		towerColor = new Color(0, 255, 0);
		movePath = 2;
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
