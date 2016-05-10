package Tanker;

public class Bullet {

    private long speed = 5;
    private int x;
    private int y;
    private Direction direction;

    public Bullet(int x, int y, Direction direction) {

        this.x = x;
        this.y = y;
        this.direction = direction;

    }

    public int getX(){
        return this.x;
    }

    public int getY() {
        return y;
    }

    public void updateX(int x){
        this.x += x;
    }

    public void updateY(int y) {
        this.y+=y;
    }

    public long getSpeed() {
        return speed;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void destroy(){
        this.x = -100;
        this.y = -100;
    }
}
