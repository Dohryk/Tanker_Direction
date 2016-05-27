package TankGit;

import java.awt.*;

public class T34 extends AbstractTank {
    private int maxSpeed = 50;
    private int crew = 4;
    private TankColor color = TankColor.GREEN;

    public T34(ActionField actionField, BattleField battleField, int x, int y, Direction direction) throws Exception {
        super(actionField, battleField, x, y, direction);
    }
    public T34(int maxSpeed, int crew, TankColor color){
        this.maxSpeed = maxSpeed;
        this.crew = crew;
        this.color = color;
    }

    public void printInfo(T34 tank) {

        System.out.println(tank.toString() + "[color:" + tank.getColor() + " , crew:" + tank.getCrew() +
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

    public void draw(Graphics g) {
        g.setColor(new Color(255, 52, 210));

        g.fillRect(getX(), getY(), 64, 64);

        g.setColor(new Color(0, 255, 0));
        if (getDirection() == Direction.UP) {
            g.fillRect(getX() + 20, getY(), 24, 34);
        } else if (getDirection() == Direction.DOWN) {
            g.fillRect(getX() + 20, getY() + 30, 24, 34);
        } else if (getDirection() == Direction.LEFT) {
            g.fillRect(getX(), getY() + 20, 34, 24);
        } else {
            g.fillRect(getX() + 30, getY() + 20, 34, 24);
        }
    }
}
