package Tanker;

public class BT7 extends Tank {

    private int maxSpeed = 72;
    private int crew = 3;
    private TankColor color = TankColor.BLACK;
   
    public BT7(ActionField actionField, BattleField battleField, int x, int y, Direction direction){
        super(actionField, battleField, x, y, direction);
    }

    public BT7(int maxSpeed, int crew, TankColor color){
        this.maxSpeed = maxSpeed;
        this.crew = crew;
        this.color = color;
    }

    public void printInfo(BT7 tank) {

        System.out.println(tank.toString() + "[color:" + tank.getColor() + " , crew:" + tank.getCrew() +
                " , maxSpeed:" + tank.getMaxSpeed()+"]");
    }

    @Override
    public String toString() {
        return "BT7 ";
    }

    @Override
    public void move() throws Exception {
        super.move();
    }

}
