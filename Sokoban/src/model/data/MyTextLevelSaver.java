package model.data;

import java.io.OutputStream;
import java.io.PrintWriter;

import common.Box;
import common.Character;
import common.Level;



public class MyTextLevelSaver implements LevelSaver {
	Level lvl;
	public MyTextLevelSaver(Level lvl) {
		this.lvl=lvl;
	}
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
	@Override
	public void saveLevel(OutputStream x) {
		PrintWriter writer= new PrintWriter(x);
		int rowLength=lvl.getMovAbleTable().length;
		int lineLength=lvl.getMovAbleTable()[0].length;
		for(int i=0;i<rowLength;i++){
			for(int j=0;j<lineLength;j++){
				if(lvl.getMovAbleTable()[i][j]==null)
				{
					writer.print(ObjectToChar(lvl.getBackgroundObjects(i, j)));
				}
				else if(lvl.getMovAbleTable(i, j) instanceof Character && lvl.getBackgroundObjects(i, j) instanceof Target)
				{
					writer.print('a');
				}
				else if(lvl.getMovAbleTable(i, j) instanceof Character){
					writer.print('A');
				}
				else if(lvl.getMovAbleTable(i, j) instanceof Box && lvl.getBackgroundObjects(i, j) instanceof Target)
					writer.print('+');
				else if(lvl.getMovAbleTable(i, j) instanceof Box)
					writer.print('@');
			}
			writer.println();
		}
		writer.close();
	}

}
