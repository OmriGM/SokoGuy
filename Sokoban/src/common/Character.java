package common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import model.data.GameObject;
import model.data.MoveAble;
import model.policy.Policy;

public class Character extends GameObject implements MoveAble {
	private static final long serialVersionUID = 1L;
	
	Policy policy;
	private Image img;
	StringProperty charFileName;
	
	public String getCharFileName() {
		return charFileName.get();
	}

	public void setCharFileName(String charFileName) {
		this.charFileName.set(charFileName); 
	}

	public Character() {
	}

	public Character(Position pos) {
		super(pos);
	}

	public Image getImg() {
		return img;
	}

	public void setImg(String string) {
		setCharFileName(string);
		try {
			img=new Image(new FileInputStream(charFileName.get()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
