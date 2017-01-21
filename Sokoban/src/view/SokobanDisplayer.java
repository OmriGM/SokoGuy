package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import common.Floor;
import common.Level;
import common.Target;
import common.Wall;
import javafx.beans.property.StringProperty;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class SokobanDisplayer extends Canvas {
	
	Level lvl;
	StringProperty characterFileName;
	
	public void setLvl(Level lvl) {
		this.lvl = lvl;
		redraw();
	}
	
	void redraw(){
		if(lvl!=null){
			double W=getWidth();
			double H=getHeight();
			int rowLength=lvl.getMovAbleTable().length;
			int lineLength=lvl.getMovAbleTable()[0].length;
			double w=W/lineLength;
			double h=H/rowLength;
				
			GraphicsContext gc=getGraphicsContext2D();
			
			Image wall=null;
			Image character=null;
			Image box=null;
			Image floor=null;
			Image target=null;
			
			try {
				wall=new Image(new FileInputStream("./resource/wall.jpg"));
				character=new Image(new FileInputStream("./resource/player.jpg"));
				box=new Image(new FileInputStream("./resource/wall.jpg"));
				floor=new Image(new FileInputStream("./resource/wall.jpg"));
				target=new Image(new FileInputStream("./resource/wall.jpg"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
					
			gc.clearRect(0, 0, W, H);
			
			for(int i=0;i<rowLength;i++){
				for(int j=0;j<lineLength;j++){
					if(lvl.getBackgroundObjects(i, j) instanceof Floor)
						if(floor!=null)
							gc.drawImage(floor, j*w, i*h, w, h);
						else 
							gc.fillRect(j*w, i*h, w, h);
					if(lvl.getBackgroundObjects(i, j) instanceof Target)
						if(target!=null)
							gc.drawImage(target, j*w, i*h, w, h);
						else 
							gc.fillRect(j*w, i*h, w, h);
						gc.drawImage(target, j*w, i*h, w, h);
					if(lvl.getBackgroundObjects(i, j) instanceof Wall)
						if(wall!=null)
							gc.drawImage(wall, j*w, i*h, w, h);
						else 
							gc.fillRect(j*w, i*h, w, h);
						gc.drawImage(wall, j*w, i*h, w, h);						
				}
			for(i=0;i<lvl.getBoxArray().size();i++)		
				gc.drawImage(box, lvl.getBoxArray().get(i).getPos().getX(), lvl.getBoxArray().get(i).getPos().getY(), w, h);
			for(i=0;i<lvl.getCharacterArray().size();i++)		
				gc.drawImage(box, lvl.getCharacterArray().get(i).getPos().getX(), lvl.getCharacterArray().get(i).getPos().getY(), w, h);
									
			}						
		}
	}
}	


