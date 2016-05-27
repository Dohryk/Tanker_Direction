package TankGit;


import java.awt.*;

public class Tiger extends AbstractTank {
    private int maxSpeed = 72;
    private int crew = 3;
    private TankColor color = TankColor.BLACK;
    private int armour = 2;

    public Tiger(ActionField actionField, BattleField battleField, int x, int y, Direction direction) throws Exception {
        super(actionField, battleField, x, y, direction);
    }

    public Tiger(int maxSpeed, int crew, TankColor color, int armour){
        this.maxSpeed = maxSpeed;
        this.crew = crew;
        this.color = color;
        this.armour = armour;
    }

    public int getArmour(){
        return armour;
    }


    public void printInfo(Tiger tank) {

        System.out.println(tank.toString() + "[color:" + tank.getColor() + " , crew:" + tank.getCrew() +
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

    public void draw(Graphics graphics) {

    }
}
