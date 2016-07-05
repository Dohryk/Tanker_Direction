package TankGit.day7.bf;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Water extends SimpleBFObject {

	private final static String IMAGE_NAME = "src/TankGit/day7/img/water.png";

	public Water(int x, int y) {
		super(x, y);
		color = new Color(0, 0, 255);
		try {
			image = ImageIO.read(new File(IMAGE_NAME));
		} catch (IOException e) {
			System.err.println("Can't find image of Water: " + IMAGE_NAME);
		}
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D graphics2D = (Graphics2D)g;
		Composite original = graphics2D.getComposite();
		Composite tranlucent = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.5f);
		graphics2D.setComposite(tranlucent);
		graphics2D.drawImage(image, getX(), getY(), new ImageObserver() {
			@Override
			public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
				return false;
			}
		});

		graphics2D.setComposite(original);
	}
}
