package TankGit;

/**
 * Created by vdohryk on 27.05.2016.
 */
public class BattleField {

    int BF_width;
    int BF_height;

    String [][] battleField = {
            {"B", "B", "B", "B", "B", "B", "B", "B","B"},
            {"B", "B", "B", "B", "B", "W", "B", " ","B"},
            {" ", "B", "B", "W", " ", "B", "B", "B","B"},
            {"B", "B", " ", "B", "B", "B", " ", "W","B"},
            {" ", "B", "B", "B", "B", "R", "R", " ","R"},
            {"B", "B", " ", "B", "B", "B", "B", "R","B"},
            {"B", " ", "B", "B", " ", "B", " ", "W","W"},
            {"B", "B", " ", "B", "B", " ", "B", " ","B"},
            {"B", " ", " ", "B", "E", "B", "B", "B","B"},
    };

    public BattleField(){

    }

    public BattleField(String [][] battleField) {
        this.battleField = battleField;
    }

    public String scanQuadrant(int x, int y) throws Exception{

        return  battleField[x][y];
    }

    public void updateQuadrant(int x, int y, String updateValue) {
        if ((x > battleField.length) || (y > battleField.length)) {
            return;
        }

        battleField[x][y] = updateValue;
    }

    public int getDimetionX(){
        return battleField.length;
    }

    public int getDimetionY(){
        return battleField.length;
    }

    public int getHeight() {
        return BF_height;
    }

    public int getWidth() {
        return BF_width;
    }
}
