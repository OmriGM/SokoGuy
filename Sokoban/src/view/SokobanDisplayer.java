package view;

import java.io.FileInputStream;

import common.Box;
import common.Character;
import common.Level;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import model.data.Floor;
import model.data.GameObject;
import model.data.Target;
import model.data.Wall;

public class SokobanDisplayer extends Canvas {
	
	Level lvl;
	public void setLvl(Level lvl) {
		this.lvl = lvl;
	}
	
	void redraw(){
		if(lvl!=null){
			double W=getWidth();
			double H=getHeight();
			double w=W/lvl.getBackgroundObjects()[0].length;
			double h=H/lvl.getBackgroundObjects().length;
			
			GraphicsContext gc=getGraphicsContext2D();
			
			Image wall=null;
			Image character=null;
			Image box=null;
			Image floor=null;
			Image target=null;
			
			wall=new Image(new FileInputStream("./resource/wall.jpg"));
			character=new Image(new FileInputStream("./resource/wall.jpg"));
			box=new Image(new FileInputStream("./resource/wall.jpg"));
			floor=new Image(new FileInputStream("./resource/wall.jpg"));
			target=new Image(new FileInputStream("./resource/wall.jpg"));
			
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
	
	
	GraphicsContext objToImg(GameObject gameObj) 
	{
		if (gameObj instanceof Wall)
			return gc.drawImage(wall, j*w, i*h, w, h);
		else if(gameObj instanceof Floor)
		return ' ';
		else if(gameObj instanceof Target)
			return 'o';
		else if(gameObj instanceof Character)
			return 'A';
		else if(gameObj instanceof Box)
			return '@';
		return 0;
	})
	
}
