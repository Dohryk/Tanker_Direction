package TankGit.day7.bf;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

public class Water extends SimpleBFObject {

	private final static String IMAGE_NAME = "D:\\PAndA\\My_Java\\Tanker\\src\\TankGit\\day7\\img\\water.png";

	public Water(int x, int y) {
		super(x, y);
		color = new Color(0, 0, 255);
		try {
			image = ImageIO.read(new File(IMAGE_NAME));
		} catch (IOException e) {
			System.err.println("Can't find image of Rock: " + IMAGE_NAME);
		}
	}
}
