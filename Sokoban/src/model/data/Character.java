package model.data;

import java.util.concurrent.atomic.AtomicInteger;

import model.policy.Policy;

public class Character extends GameObject implements MoveAble {
	Policy policy;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public Character() {
	// TODO Auto-generated constructor stub
}

	public Character(int x,int y) {
		super(x,y);
	}
	

	public void directionToXY(AtomicInteger x,AtomicInteger y,String direction){
		switch (direction) {
		case "Up":
		case "up":
			x.set(x.intValue()-1);
			
			break;
		case "Down":
		case "down":
			x.set(x.intValue()+1);
			break;
		case "Left":
		case "left":
			y.set(y.intValue()-1);
			break;
		case "Right":
		case "right":
			y.set(y.intValue()+1);
			break;
		default:
			break;
		}
	}
	@Override
	public boolean move(Level lvl,String direction) {
		int i,j;
		//sending atomic int to directiontoxy
		AtomicInteger a,b;
		a=new AtomicInteger(this.getX());
		b=new AtomicInteger(this.getY());
		directionToXY(a, b, direction);
		i=a.get();
		j=b.get();

		policy=lvl.getPolicy();
		GameObject gameobj= getNearObj(lvl, direction);

		
		//if area clear
		if(!(gameobj instanceof Wall)&&!(gameobj instanceof Box))
		{

			lvl.getMovAbleTable()[i][j]=this;
			lvl.getMovAbleTable()[this.getX()][this.getY()]=null;
			this.setX(i);
			this.setY(j);
			return true;
		}
		//if there is a wall
		else if((gameobj instanceof Wall)&&policy.wallPolicy()){
			lvl.getMovAbleTable()[i][j]=this;
			lvl.getMovAbleTable()[this.getX()][this.getY()]=null;
			this.setX(i);
			this.setY(j);
			return true;
		}
		//if there is a box
		else if((gameobj instanceof Box)&&((Box)gameobj).move(lvl,direction)){
			lvl.getMovAbleTable()[i][j]=this;
			lvl.getMovAbleTable()[this.getX()][this.getY()]=null;
			this.setX(i);
			this.setY(j);
			if(lvl.getBackgroundObjects(i, j)instanceof Target)
				lvl.setBoxontarget(lvl.getBoxontarget()-1);
			return true;
		}
		return false;
	}


	@Override
	public GameObject getNearObj(Level lvl, String direction) {
		int i,j;
		AtomicInteger a,b;
		a=new AtomicInteger(this.getX());
		b=new AtomicInteger(this.getY());
		directionToXY(a, b, direction);
		i=a.get();
		j=b.get();
		if (lvl.movAbleTable[i][j]==null)
			return lvl.getBackgroundObjects(i, j);
		else return lvl.getMovAbleTable(i, j);
	}

}
