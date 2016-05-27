package TankGit;


import java.awt.*;

public class Tiger extends AbstractTank {
    private int maxSpeed = 72;
    private int crew = 3;
    //private TankColor color = TankColor.BLACK;
    private int armour = 2;

    public Tiger(ActionField actionField, BattleField battleField, int x, int y, Direction direction) throws Exception {
        super(actionField, battleField, x, y, direction);
        this.tankColor = new Color(200, 20, 32);
        this.towerColor = new Color(200, 199, 26);
    }

    public int getArmour(){
        return armour;
    }


    public void printInfo(Tiger tank) {

        System.out.println(tank.toString() + "[color:" + tank.getTankColor() + " , crew:" + tank.getCrew() +
                " , maxSpeed:" + tank.getMaxSpeed() + " , arnor:" + tank.getArmour()+"]");
    }

    @Override
    public String toString() {
        return "Tiger ";
    }

    @Override
    public void move() throws Exception {
        super.move();
    }

    @Override
    public void destroy() {

        if (armour ==0) {
            super.destroy();
        } else armour--;

    }
}
