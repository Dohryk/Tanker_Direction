package Tanker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ActionField extends JPanel {

    private boolean COLORDED_MODE = false;
    private Tank tank;
    private BT7 agressor;
    private BattleField battleField;
    private Bullet bullet;

    public void runTheGame() throws Exception {
        //tank.moveRandom();
        tank.clean();
        /*tank.fire();
        tank.move();
		tank.fire();
        tank.move();
		tank.fire();
        tank.turn(3);
        tank.move();
        tank.fire();*/
    }

    public void processTurn(Tank tank) throws Exception {
		repaint();
    }

    private boolean processInterception() throws Exception {
        String str = getQuadrant(bullet.getX(), bullet.getY());
        int x = Integer.valueOf(str.substring(0, str.indexOf("_")));
        int y = Integer.valueOf(str.substring(str.indexOf("_") + 1));
        if (!battleField.scanQuadrant(x, y).trim().isEmpty()) {
            battleField.updateQuadrant(x, y, " ");
            return true;
        }
        return false;
    }

    public void processFire(Bullet bullet) throws Exception {
        this.bullet = bullet;
        int step = 1;
        while ((bullet.getX()>-14 && bullet.getX() <598)
                && (bullet.getY()>-14 && bullet.getY() < 598)){
            if (bullet.getDirection()==Direction.UP){
                bullet.updateY(-step);
            } else if (bullet.getDirection()==Direction.DOWN){
                bullet.updateY(step);
            } else if (bullet.getDirection()==Direction.LEFT){
                bullet.updateX(-step);
            } else {
                bullet.updateX(step);
            }

            if (processInterception()){
                bullet.destroy();
            }

            repaint();
            Thread.sleep(bullet.getSpeed());
        }
    }

    public void processMove(Tank tank) throws Exception {
        this.tank = tank;
        int step = 1;
        int covered = 0;
        Direction direction = tank.getDirection();
        int tankY = tank.getY();
        int tankX = tank.getX();

        if ((direction == Direction.UP && tank.getY() == 0) || (direction == Direction.DOWN && tank.getY() >= 512)
                || (direction == Direction.LEFT && tank.getX() == 0) || (direction == Direction.RIGHT && tank.getX() >= 512)) {
            return;
        }

        tank.turn(direction);

        processTurn(tank);

        while (covered < 64) {
            if (direction == Direction.UP) {
                tank.updateY(-step);
            } else if (direction == Direction.DOWN) {
                tank.updateY(step);
            } else if (direction == Direction.LEFT) {
                tank.updateX(-step);
            } else {
                tank.updateX(step);
            }
            covered += step;

            repaint();
            Thread.sleep(tank.getMaxSpeed());
        }
    }

    public String getQuadrantXY(int v, int h) {
        return (v - 1) * 64 + "_" + (h - 1) * 64;
    }

    public String getQuadrant(int x, int y) {
        return y / 64 + "_" + x / 64;
    }

    public ActionField() throws Exception {

        battleField = new BattleField();
        tank = new Tank(this, battleField);

        Random r = new Random();
        int randomX = r.nextInt(3)+1;

        agressor = new BT7(this, battleField,randomX*64,0,Direction.DOWN);
        bullet = new Bullet(-100, -100, Direction.NONE);

        JFrame frame = new JFrame("BATTLE FIELD, DAY 2");
        frame.setLocation(750, 150);
        frame.setMinimumSize(new Dimension(battleField.getWidth() + 16,
                battleField.getHeight() + 38));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int i = 0;
        Color cc;
        for (int v = 0; v < 9; v++) {
            for (int h = 0; h < 9; h++) {
                if (COLORDED_MODE) {
                    if (i % 2 == 0) {
                        cc = new Color(252, 241, 177);
                    } else {
                        cc = new Color(233, 243, 255);
                    }
                } else {
                    cc = new Color(180, 180, 180);
                }
                i++;
                g.setColor(cc);
                g.fillRect(h * 64, v * 64, 64, 64);
            }
        }

        for (int j = 0; j < battleField.getDimetionY(); j++) {
            for (int k = 0; k < battleField.getDimetionX(); k++) {
                try {
                    if (battleField.scanQuadrant(j, k).equals("B")) {
                        String coordinates = getQuadrantXY(j + 1, k + 1);
                        int separator = coordinates.indexOf("_");
                        int y = Integer.parseInt(coordinates
                                .substring(0, separator));
                        int x = Integer.parseInt(coordinates
                                .substring(separator + 1));
                        g.setColor(new Color(0, 0, 255));
                        g.fillRect(x, y, 64, 64);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        g.setColor(new Color(255, 0, 0));
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

        g.setColor(new Color(255, 255, 0));
        g.fillRect(bullet.getX(), bullet.getY(), 14, 14);
    }
}
