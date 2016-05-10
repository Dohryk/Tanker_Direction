package Tanker;

import java.util.Random;

public class Tank {

    public int maxSpeed;
    private int crew;
    private TankColor color;
    private Direction direction;
    private int x;
    public int y;

    public ActionField actionField;
    public BattleField battleField;

    public Tank(){

    }

    public Tank(int maxSpeed, int crew, TankColor color){
        this.maxSpeed = maxSpeed;
        this.crew = crew;
        this.color = color;
    }

    public Tank(ActionField actionField, BattleField battleField){
        this(actionField, battleField, 128, 512, Direction.UP);
    }

    public Tank(ActionField actionField, BattleField battleField, int x, int y, Direction direction){
        this.actionField = actionField;
        this.battleField = battleField;
        this.x = x;
        this.y = y;
        this.direction = direction;
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
        String str = actionField.getQuadrant(v, h);
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
        for(int i = 2; i<=9; i++){
            for(int j = 1; j<=9; j++){
                moveToQuadrant(j, i);
                if(j==1&&j<=9&&i!=1){
                    moveToQuadrant(1, i++);
                }
            }
        }
    }

    void fire() throws Exception {
        Bullet bullet = new Bullet(x+25, y+25,direction);
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
        this.x = x;
    }

    public void updateY(int Y){
        this.y = y;
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
