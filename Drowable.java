package TankGit;

import java.awt.*;

/**
 * Created by vdohryk on 27.05.2016.
 */
public interface Drowable {
    public void draw(Graphics g, AbstractTank tank);
    /*
    public static void draw(Graphics g, AbstractTank tank){
        g.setColor(new Color(255, 52, 210));

        g.fillRect(tank.getX(), tank.getY(), 64, 64);

        g.setColor(new Color(0, 255, 0));
        if (tank.getDirection() == Direction.UP) {
            g.fillRect(tank.getX() + 20, tank.getY(), 24, 34);
        } else if (tank.getDirection() == Direction.DOWN) {
            g.fillRect(tank.getX() + 20, tank.getY() + 30, 24, 34);
        } else if (tank.getDirection() == Direction.LEFT) {
            g.fillRect(tank.getX(), tank.getY() + 20, 34, 24);
        } else {
            g.fillRect(tank.getX() + 30, tank.getY() + 20, 34, 24);
        }
    }*/
}
