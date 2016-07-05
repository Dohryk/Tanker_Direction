package TankGit.day7.bf;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

public class Eagle extends SimpleBFObject {
	private final static String IMAGE_NAME = "src/TankGit/day7/img/eagle.png";

	public Eagle(int x, int y) {
		super(x, y);
		color = new Color(255, 255, 0);

		try {
			image = ImageIO.read(new File(IMAGE_NAME));
		} catch (IOException e) {
			System.err.println("Can't find image of Rock: " + IMAGE_NAME);
		}
	}
}
