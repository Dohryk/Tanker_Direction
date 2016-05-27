package TankGit;

import java.util.Random;

public abstract class AbstractTank {

    public int maxSpeed;
    private int crew;
    private TankColor color;
    private Direction direction;
    private int x;
    public int y;

    public ActionField actionField;
    public BattleField battleField;

    public AbstractTank(){

    }

    public AbstractTank(int maxSpeed, int crew, TankColor color){
        this.maxSpeed = maxSpeed;
        this.crew = crew;
        this.color = color;
    }

    public AbstractTank(ActionField actionField, BattleField battleField) throws Exception {
        this(actionField, battleField, 0, 0, Direction.LEFT);
    }

    public AbstractTank(ActionField actionField, BattleField battleField, int x, int y, Direction direction) throws Exception {
        this.actionField = actionField;
        this.battleField = battleField;
        this.x = x;
        this.y = y;
        this.direction = direction;

        String str = actionField.getQuadrant(x,y);
        int xQuadrant = Integer.valueOf(str.substring(0, str.indexOf("_")));
        int yQuadrant = Integer.valueOf(str.substring(str.indexOf("_") + 1));
        if ((xQuadrant >= 0 && xQuadrant < 9) && (yQuadrant >= 0 && yQuadrant < 9)) {
            if (!battleField.scanQuadrant(xQuadrant, yQuadrant).trim().isEmpty()) {
                battleField.updateQuadrant(xQuadrant, yQuadrant, " ");
            }
        }
    }

    public void turn(Direction direction) throws Exception {
        this.direction = direction;
        actionField.processTurn(this);
    }

    public void move() throws Exception {
        actionField.processMove(this);
    }

    public void moveRandom() throws Exception {
        Random r = new Random();
        while (true){
            int randomDirection = r.nextInt(5);
            if (randomDirection > 0){
                if (randomDirection==1){
                    turn(Direction.UP);
                } else if (randomDirection==2){
                    turn(Direction.DOWN);
                } else if (randomDirection==3){
                    turn(Direction.LEFT);
                } else if (randomDirection==4){
                    turn(Direction.RIGHT);
                }
                move();
            }
        }
    }

    public void moveToQuadrant(int v, int h) throws Exception {
        String str = actionField.getQuadrantXY(v, h);
        int y = Integer.parseInt(str.substring(0, str.indexOf("_")));
        int x = Integer.parseInt(str.substring(str.indexOf("_")+1));

        while(this.x != x){
            if (this.x < x){
                turn(Direction.RIGHT);
                fire();
                move();
            } else {
                turn(Direction.LEFT);
                fire();
                move();
            }
        }
        while(this.y != y){
            if (this.y < y){
                turn(Direction.DOWN);
                fire();
                move();
            } else {
                turn(Direction.UP);
                fire();
                move();
            }
        }
    }

    public void clean() throws Exception {
        moveToQuadrant(1 , 1);

        for(int i = 1; i<=9; i++){
            moveToQuadrant(1, i);
            turn(Direction.DOWN);
            for (int k = 1; k <= 8; k++) {
                if (battleField.scanQuadrant(k, i - 1) == "B") {
                    fire();
                }
            }
            turn(Direction.LEFT);
        }
    }

    void fire() throws Exception {
        Bullet bullet = new Bullet(this, x+25, y+25,direction);
        actionField.processFire(bullet);
    }


    public Direction getDirection() {
        return direction;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public ActionField getActionField() {
        return actionField;
    }

    public BattleField getBattleField() {
        return battleField;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void updateX(int x) {
        this.x += x;
    }

    public void updateY(int Y){
        this.y += y;
    }

    public int getCrew() {
        return crew;
    }

    public TankColor getColor() {
        return color;
    }

    public void destroy(){
        this.updateX(-1000);
        this.updateY(-1000);
        actionField.repaint();
    }
}
