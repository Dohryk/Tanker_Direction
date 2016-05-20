package Tanker;


public class Tiger extends Tank {
    private int maxSpeed = 72;
    private int crew = 3;
    private TankColor color = TankColor.BLACK;
    private int armour = 2;

    Tiger(){
        super();
    }

    public Tiger(int maxSpeed, int crew, TankColor color, int armour){
        this.maxSpeed = maxSpeed;
        this.crew = crew;
        this.color = color;
        this.armour = armour;
    }

    public int getArmour(){
        return armour;
    }

    public void printInfo(Tiger tank) {

        System.out.println(tank.toString() + "[color:" + tank.getColor() + " , crew:" + tank.getCrew() +
                " , maxSpeed:" + tank.getMaxSpeed() + " , arnor:" + tank.getArmour()+"]");
    }

    @Override
    public String toString() {
        return "Tiger ";
    }

    @Override
    public void move() throws Exception {
        super.move();
    }
}
