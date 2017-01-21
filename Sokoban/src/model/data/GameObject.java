package model.data;

import java.io.Serializable;

import common.Position;
import javafx.scene.image.Image;

public class GameObject implements Serializable{
	private static final long serialVersionUID = 1L;

	protected Position pos;
	//Default constructor
	public GameObject() {}
	
	public GameObject(Position pos) {
		this.pos=pos;
	}
	
	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}

	
	
}
