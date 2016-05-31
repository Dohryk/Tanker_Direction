package TankGit.GraficsInterface;

import Shapes.GIT.Drawable;
import TankGit.BattleField;
import TankGit.Interfaces.Destroyable;

import java.awt.*;

/**
 * Created by vdohryk on 30.05.2016.
 */
public class Rock implements Drawable, Destroyable {
    private int x;
    private int y;
    private BattleField battleField;

    public Rock(BattleField battleField, int x, int y){
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
        graphics.setColor(new Color(100, 116, 120));
        graphics.fillRect(x, y, 64, 64);
    }
}
