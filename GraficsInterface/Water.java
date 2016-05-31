package TankGit.GraficsInterface;

import Shapes.GIT.Drawable;
import TankGit.BattleField;
import TankGit.Destroyable;

import java.awt.*;

/**
 * Created by vdohryk on 30.05.2016.
 */
public class Water implements Drawable, Destroyable {
    private int x;
    private int y;
    private BattleField battleField;

    public Water(BattleField battleField, int x, int y){
        this.battleField = battleField;
        this.x = x;
        this.y = y;
    }


    @Override
    public void destroy() {

    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(new Color(59, 130, 200));
        graphics.fillRect(x, y, 64, 64);
    }
}
