package TankGit.Tanks;

/**
 * Created by vdohryk on 27.05.2016.
 */
public enum TankColor {
    BLUE(0), RED(1), BLACK(2), GREY(3), DARK_GREY(4), YELLOW(5), PINK(6), GREEN(7), ORANGE(8), VIOLET(9), MAGENTA(10), BROWN(11), PLUM(12), WHITE(13), GOLD(14), METAL(15);

    private  int id;

    private TankColor(int id){
        this.id = id;
    }

    public TankColor getDefaultColor()
    {
        return BLACK;
    }
}
