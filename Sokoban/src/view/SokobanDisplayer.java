package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import common.Box;
import common.Character;
import common.Floor;
import common.Level;
import common.Target;
import common.Wall;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class SokobanDisplayer extends Canvas {
	
	Level lvl;
	StringProperty characterFileName=new SimpleStringProperty();
	StringProperty boxFileName=new SimpleStringProperty();
	StringProperty wallFileName=new SimpleStringProperty();
	StringProperty floorFileName=new SimpleStringProperty();
	StringProperty targetFileName=new SimpleStringProperty();

	public String getBoxFileName() {
		return boxFileName.get();
	}

	public void setBoxFileName(String boxFileName) {
		this.boxFileName.set(boxFileName);
	}

	public String getWallFileName() {
		return wallFileName.get();
	}

	public void setWallFileName(String wallFileName) {
		this.wallFileName.set(wallFileName);
	}

	public String getFloorFileName() {
		return floorFileName.get();
	}

	public void setFloorFileName(String floorFileName) {
		this.floorFileName.set(floorFileName);
	}

	public String getTargetFileName() {
		return targetFileName.get();
	}

	public void setTargetFileName(String targetFileName) {
		this.targetFileName.set(targetFileName);
	}


	public String getCharacterFileName() {
		return characterFileName.get();
	}

	public void setCharacterFileName(String characterFileName) {
		this.characterFileName.set(characterFileName);
	}

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
				wall=new Image(new FileInputStream(wallFileName.get()));
				character=new Image(new FileInputStream(characterFileName.get()));
				box=new Image(new FileInputStream(boxFileName.get()));
				floor=new Image(new FileInputStream(floorFileName.get()));
				target=new Image(new FileInputStream(targetFileName.get()));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			gc.clearRect(0, 0, W, H);	
			
			for(int i=0;i<rowLength;i++){
				for(int j=0;j<lineLength;j++){
					//draws floors
					if(lvl.getBackgroundObjects(i, j) instanceof Floor)			
						if(floor!=null)
							gc.drawImage(floor, j*w, i*h, w, h);
						else {
							gc.setFill(Color.BLUEVIOLET);
							gc.fillRect(j*w, i*h, w, h);
						}
					//draws targets
					if(lvl.getBackgroundObjects(i, j) instanceof Target)
						if(target!=null)
							gc.drawImage(target, j*w, i*h, w, h);
						else {
							gc.setFill(Color.BLUE);
							gc.fillRect(j*w, i*h, w, h);							
						}
					//draws walls
					if(lvl.getBackgroundObjects(i, j) instanceof Wall){
						//System.out.println("wall");
						if(wall!=null)
							gc.drawImage(wall, j*w, i*h, w, h);
						else 
							gc.setFill(Color.GREEN);
							gc.fillRect(j*w, i*h, w, h);
						gc.drawImage(wall, j*w, i*h, w, h);		
					}
					//draw boxes
					if(lvl.getMovAbleTable(i, j) instanceof Box){
						if(box!=null)
							gc.drawImage(box,j*w,i*h, w, h);
						else{
							gc.setFill(Color.YELLOW);
							gc.fillOval(j*w,i*h, w, h);
						}
					}
					//draw characters
					if(lvl.getMovAbleTable(i, j) instanceof Character){
						if(character!=null)
							gc.drawImage(character,j*w,i*h, w, h);
						else{
							gc.setFill(Color.YELLOW);
							gc.fillOval(j*w,i*h, w, h);			
						}
					}
				}
			}							
		}
	}
}	


