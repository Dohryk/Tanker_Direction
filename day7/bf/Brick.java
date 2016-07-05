package TankGit.day7.bf;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

public class Brick extends SimpleBFObject {
	private final static String IMAGE_NAME = "src/TankGit/day7/img/brick.png";

	public Brick(int x, int y) {
		super(x, y);
		color = new Color(255, 158, 14);
		try {
			image = ImageIO.read(new File(IMAGE_NAME));
		} catch (IOException e) {
			System.err.println("Can't find image of Rock: " + IMAGE_NAME);
		}
	}
}
