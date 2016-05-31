package TankGit.Tanks;

import TankGit.ActionField;
import TankGit.BattleField;
import TankGit.Direction;

import java.awt.*;

/**
 * Created by vdohryk on 27.05.2016.
 */
public class BT7 extends AbstractTank {
    private int maxSpeed = 72;
    private int crew = 3;

    public BT7(ActionField actionField, BattleField battleField, int x, int y, Direction direction) throws Exception {
        super(actionField, battleField, x, y, direction);
        this.tankColor = new Color(35, 33, 2);
        this.towerColor = new Color(200, 65, 194);
    }

    public void printInfo(BT7 tank) {

        System.out.println(tank.toString() + "[color:" + tank.getTankColor() + " , crew:" + tank.getCrew() +
                " , maxSpeed:" + tank.getMaxSpeed()+"]");
    }

    @Override
    public String toString() {
        return "BT7 ";
    }

    @Override
    public void move() throws Exception {
        super.move();
    }

}
