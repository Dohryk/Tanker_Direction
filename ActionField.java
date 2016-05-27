package TankGit;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ActionField extends JPanel {

    private boolean COLORDED_MODE = false;
    private AbstractTank defender;
    private Tiger agressor;
    private BattleField battleField;
    private Bullet bullet;

    public void runTheGame() throws Exception {
        //defender.moveRandom();
        defender.clean();
        /*defender.fire();
        defender.move();
		defender.fire();
        defender.move();
		defender.fire();
        defender.turn(3);
        defender.move();
        defender.fire();*/
    }

    public void processTurn(AbstractTank abstractTank) throws Exception {
        repaint();
    }

    private boolean processInterception() throws Exception {
        String coordinateBullet = getQuadrant(bullet.getX(), bullet.getY());
        int x = Integer.valueOf(coordinateBullet.substring(0, coordinateBullet.indexOf("_")));
        int y = Integer.valueOf(coordinateBullet.substring(coordinateBullet.indexOf("_") + 1));
        if ((x >= 0 && x < 9) && (y >= 0 && y < 9)){
            if (!battleField.scanQuadrant(x, y).trim().isEmpty()) {
                battleField.updateQuadrant(x, y, " ");
                return true;
            }

            if (bullet.getAbstractTank() != agressor) {
                if (checkInterception(getQuadrant(agressor.getX(), agressor.getY()), coordinateBullet)) {
                    agressor.destroy();
                    Thread.sleep(3000);
                    createAgressor();
                    return true;
                }
            }

            if (bullet.getAbstractTank() != defender) {
                if (checkInterception(getQuadrant(defender.getX(), defender.getY()), coordinateBullet)) {
                    defender.destroy();
                    Thread.sleep(3000);
                    createAgressor();
                    return true;
                }
            }
        }

        return false;
    }

    private boolean checkInterception( String coordinateTank, String coordinateBullet){

        int tank_Y = Integer.parseInt(coordinateTank.split("_")[0]);
        int tank_X = Integer.parseInt(coordinateTank.split("_")[1]);

        int bullet_Y = Integer.parseInt(coordinateBullet.split("_")[0]);
        int bullet_X = Integer.parseInt(coordinateBullet.split("_")[1]);

        if ((tank_X >=0) && (tank_X < 9) && (tank_Y >=0) && (tank_Y < 9)) {
            if (tank_X == bullet_X && tank_Y == bullet_Y){
                return true;
            }
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

    public void processMove(AbstractTank abstractTank) throws Exception {
        this.defender = abstractTank;
        int step = 1;
        int covered = 0;
        Direction direction = abstractTank.getDirection();
        int tankY = abstractTank.getY();
        int tankX = abstractTank.getX();

        if ((direction == Direction.UP && abstractTank.getY() == 0) || (direction == Direction.DOWN && abstractTank.getY() >= 512)
                || (direction == Direction.LEFT && abstractTank.getX() == 0) || (direction == Direction.RIGHT && abstractTank.getX() >= 512)) {
            return;
        }

        abstractTank.turn(direction);

        processTurn(abstractTank);

        while (covered < 64) {
            if (direction == Direction.UP) {
                abstractTank.updateY(-step);
            } else if (direction == Direction.DOWN) {
                abstractTank.updateY(step);
            } else if (direction == Direction.LEFT) {
                abstractTank.updateX(-step);
            } else {
                abstractTank.updateX(step);
            }
            covered += step;

            repaint();
            Thread.sleep(abstractTank.getMaxSpeed());
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
        defender = new T34(this, battleField,0,0, Direction.DOWN);

        createAgressor();
        bullet = new Bullet(defender, -100, -100, Direction.NONE);

        JFrame frame = new JFrame("BATTLE FIELD, DAY 2");
        frame.setLocation(750, 150);
        frame.setMinimumSize(new Dimension(battleField.getWidth() + 16,
                battleField.getHeight() + 38));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
    }

    private void createAgressor() throws Exception {
        Random r = new Random();
        int randomX = r.nextInt(3)+1;

        agressor = new Tiger(this, battleField,randomX*64,randomX*64,Direction.DOWN);
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
        g.setColor(new Color(255, 52, 210));
        defender.draw(g);

        g.setColor(new Color(255, 0, 0));
        agressor.draw(g);

        g.setColor(new Color(255, 255, 0));
        g.fillRect(bullet.getX(), bullet.getY(), 14, 14);
    }
}



