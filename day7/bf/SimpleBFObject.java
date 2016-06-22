package TankGit.day7.bf;

import java.awt.*;
import java.awt.image.ImageObserver;


public abstract class SimpleBFObject implements BFObject {

	// current position on BF
	private int x;
	private int y;
	protected Image image;
	
	protected Color color;

	private boolean isDestroyed = false;
	
	public SimpleBFObject(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void destroy() {
		isDestroyed = true;
	}
	
	@Override
	public void draw(Graphics g) {
		if (!isDestroyed) {
			g.setColor(this.color);
			if (image!=null){
				g.drawImage(image,x,y, new ImageObserver() {
					@Override
					public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
						return false;
					}
				});
			} else {
				g.fillRect(this.getX(), this.getY(), 64, 64);
			}
		}
	}
	
	public boolean isDestroyed() {
		return isDestroyed;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
