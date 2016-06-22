package TankGit.day7.bf;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Rock extends SimpleBFObject {
	private final static String IMAGE_NAME = "D:\\PAndA\\My_Java\\Tanker\\src\\TankGit\\day7\\img\\rock.png";

	public Rock(int x, int y) {
		super(x, y);

		color = new Color(99, 103, 120);
		try {
			image = ImageIO.read(new File(IMAGE_NAME));
		} catch (IOException e) {
			System.err.println("Can't find image of Rock: " + IMAGE_NAME);
		}
	}
}
