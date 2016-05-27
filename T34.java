package TankGit;

import java.awt.*;

public class T34 extends AbstractTank {
    private int maxSpeed = 50;
    private int crew = 4;

    public T34(ActionField actionField, BattleField battleField, int x, int y, Direction direction) throws Exception {
        super(actionField, battleField, x, y, direction);
        tankColor = new Color(55, 180, 11);
        towerColor = new Color(200, 166, 34);
    }
    public T34(int maxSpeed, int crew){
        this.maxSpeed = maxSpeed;
        this.crew = crew;
       // this.color = color;
    }

    public void printInfo(T34 tank) {

        System.out.println(tank.toString() + "[color:" + tank.getTankColor() + " , crew:" + tank.getCrew() +
                " , maxSpeed:" + tank.getMaxSpeed()+"]");
    }

    @Override
    public String toString() {
        return "T34 ";
    }

    @Override
    public void move() throws Exception {
        super.move();
    }

}
