package model.policy;

import java.util.concurrent.atomic.AtomicInteger;

import common.Box;
import common.Level;
import common.Position;
import common.Target;
import common.Wall;
import model.data.GameObject;

public class MyPolicy implements Policy {
	
	@Override
	public int move(Level lvl, String direction) {
		Position charPos=lvl.getCharacterArray().get(0).getPos();
		GameObject moveObj= lvl.getCharacterArray().get(0);
		GameObject nearObj=lvl.getNearObj(charPos,direction);
		
		int i =nearObj.getPos().getX();
		int j =nearObj.getPos().getY();
		
				
				//if area clear
				if(!(nearObj instanceof Wall)&&!(nearObj instanceof Box))
				{
		
					lvl.getMovAbleTable()[i][j]=moveObj;
					lvl.getMovAbleTable()[charPos.getX()][charPos.getY()]=null;
					charPos.setX(i);
					charPos.setY(j);
					return 1;
				}
				//if there is a wall
				else if(nearObj instanceof Wall){
					return -1;
				}

				//if there is a box
				else if(nearObj instanceof Box){
					GameObject nearObjX2=lvl.getNearObj(nearObj.getPos(), direction);
					if(nearObjX2 instanceof Wall||nearObjX2 instanceof Box)
						return -1;
					else{
					System.out.println("grosman");
					lvl.getMovAbleTable()[nearObjX2.getPos().getX()][nearObjX2.getPos().getY()]=nearObj;
					lvl.getMovAbleTable()[i][j]=null;
					nearObj.setPos(nearObjX2.getPos());
					
					lvl.getMovAbleTable()[i][j]=moveObj;
					lvl.getMovAbleTable()[charPos.getX()][charPos.getY()]=null;
					charPos.setX(i);
					charPos.setY(j);
					}
					
					if(lvl.getBackgroundObjects(i, j)instanceof Target)
						lvl.setBoxontarget(lvl.getBoxontarget()-1);
					
					if(nearObjX2 instanceof Target){
						lvl.setBoxontarget(lvl.getBoxontarget()+1);
						return 4;
					}
					
					return 3;
				}
				return -1;
			}
}
