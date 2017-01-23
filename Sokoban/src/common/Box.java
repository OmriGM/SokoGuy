package common;

import model.data.GameObject;
import model.data.MoveAble;

public class Box extends GameObject implements MoveAble {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Box() {
	}
	public Box(Position pos) {
		super(pos);
		
	}
	
}
