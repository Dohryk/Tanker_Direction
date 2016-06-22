package TankGit.day7.bf.tanks;

import java.awt.Color;

import TankGit.day7.Direction;
import TankGit.day7.bf.BattleField;

public class T34 extends AbstractTank {
	
	public T34(BattleField bf) {
		super(bf, 128, 512, Direction.UP, "t34");
		tankColor = new Color(0, 255, 0);
		towerColor = new Color(200, 65, 194);
	}
	
	public T34(BattleField bf, int x, int y, Direction direction) {
		super(bf, x, y, direction, "t34");
		tankColor = new Color(0, 255, 0);
		towerColor = new Color(200, 65, 194);
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
