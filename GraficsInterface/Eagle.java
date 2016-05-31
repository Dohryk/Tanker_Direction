package TankGit.GraficsInterface;

import Shapes.GIT.Drawable;
import TankGit.BattleField;
import TankGit.Destroyable;

import java.awt.*;

/**
 * Created by vdohryk on 30.05.2016.
 */
public class Eagle implements Drawable, Destroyable {
    private int x;
    private int y;
    private BattleField battleField;

    public Eagle(BattleField battleField, int x, int y){
        this.battleField = battleField;
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics graphics) {
        graphics.setColor(new Color(200, 166, 34));
        graphics.fillRect(x, y, 64, 64);
    }

    @Override
    public void destroy() {
        battleField.updateQuadrant(x, y, " ");
        System.out.println("!!! GAME OVER !!!");
        System.exit(0);
    }
}
