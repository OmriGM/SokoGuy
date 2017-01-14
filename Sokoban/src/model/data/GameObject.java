package levels;

import java.io.Serializable;

public class GameObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public GameObject() {
}
	public GameObject(int x, int y) {
		setX(x);
		setY(y);
	}
	protected int x, y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}
