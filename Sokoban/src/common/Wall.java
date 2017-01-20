package common;

import javafx.scene.image.Image;
import model.data.GameObject;

public class Wall extends GameObject {
	/**
	 * 
	 */
	Image wallImage;
	public Image getWallImage() {
		return wallImage;
	}

	public void setWallImage(Image wallImage) {
		this.wallImage = wallImage;
	}

	private static final long serialVersionUID = 1L;
	
	public Wall() {
	}
	
	public Wall(Position pos) {
		super(pos);

	}

}
