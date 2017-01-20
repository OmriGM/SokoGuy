package model.data;

import java.io.Serializable;

import common.Position;

public class GameObject implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	//Default constructor
	public GameObject() {}
	
	public GameObject(Position pos) {
		this.pos=pos;
	}
	protected Position pos;

	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}

	
	
}
