package common;

import java.util.concurrent.atomic.AtomicInteger;

import model.data.GameObject;
import model.data.MoveAble;
import model.policy.Policy;

public class Box extends GameObject implements MoveAble {
	//Policy policy;
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
