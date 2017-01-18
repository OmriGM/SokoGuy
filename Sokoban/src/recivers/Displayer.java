package recivers;

import common.Box;
import common.Character;
import common.Level;
import model.data.Floor;
import model.data.GameObject;
import model.data.Target;
import model.data.Wall;

public class Displayer {

	
	public char ObjectToChar(GameObject gameObj) 
	{
		if (gameObj instanceof Wall)
			return '#';
		else if(gameObj instanceof Floor)
		return ' ';
		else if(gameObj instanceof Target)
			return 'o';
		else if(gameObj instanceof Character)
			return 'A';
		else if(gameObj instanceof Box)
			return '@';
		return 0;
	}
	
	public void Display(Level lvl){
		int rowLength=lvl.getMovAbleTable().length;
		int lineLength=lvl.getMovAbleTable()[0].length;
		for(int i=0;i<rowLength;i++){
			for(int j=0;j<lineLength;j++){
				if(lvl.getMovAbleTable()[i][j]==null)
				{
					System.out.print(ObjectToChar(lvl.getBackgroundObjects(i, j)));
				}
				else if(lvl.getMovAbleTable(i, j) instanceof Character && lvl.getBackgroundObjects(i, j) instanceof Target)
				{
					System.out.print('a');
				}
				else if(lvl.getMovAbleTable(i, j) instanceof Character){
					System.out.print('A');
				}
				else if(lvl.getMovAbleTable(i, j) instanceof Box && lvl.getBackgroundObjects(i, j) instanceof Target)
					System.out.print('+');
				else if(lvl.getMovAbleTable(i, j) instanceof Box)
					System.out.print('@');
			}
			System.out.println();
		}
	}
}
