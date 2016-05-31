package TankGit.GraficsInterface;

import Shapes.GIT.Drawable;
import TankGit.BattleField;
import TankGit.Destroyable;

import java.awt.*;

/**
 * Created by vdohryk on 30.05.2016.
 */
public class Brick implements Drawable, Destroyable{
    private int x;
    private int y;
    private BattleField battleField;

    public Brick(BattleField battleField, int x, int y){
        this.battleField = battleField;
        this.x = x;
        this.y = y;
    }

    @Override
    public void destroy() {
        battleField.updateQuadrant(x, y, " ");
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(new Color(200, 132, 12));
        graphics.fillRect(x, y, 64, 64);
    }
}
