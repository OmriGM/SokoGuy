package view;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

import common.Level;
import javafx.beans.property.IntegerProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SokobanViewer extends Observable implements View,Initializable {
	@FXML
	SokobanDisplayer sokobanDisplayer;
	Level lvl;
	@FXML
	Label stepCounter;
	@Override
	public void bindCounter(IntegerProperty stepCounter) {
		this.stepCounter.textProperty().bind(stepCounter.asString());
		
	}


	@Override
	public void displayLevel(Level lvl) {
		sokobanDisplayer.setLvl(lvl);	
		this.lvl=lvl;
	}

	public void openFile(){
		//System.out.println("Opens file!");
		FileChooser fc=new FileChooser();
		fc.setTitle("Open Level File");
		fc.setInitialDirectory(new File("./resources"));
		File choosen=fc.showOpenDialog(null);
		if (choosen!=null){			
			List<String> params=new ArrayList<String>();
			params.add("load");				
			String filename=choosen.getPath();
				params.add(filename);
			setChanged();		
			notifyObservers(params);
		}
	}

	public void saveFile() {
		FileChooser fc=new FileChooser();
		fc.setTitle("Save Level");
		fc.setInitialDirectory(new File("./resources"));
		File file = fc.showSaveDialog(null);
		if (file!=null){			
			List<String> params=new ArrayList<String>();
			params.add("save");		
			params.add(file.getPath());
			setChanged();			
			notifyObservers(params);
		}
		
	}
	@Override
	public void ExitCommand() {
		List<String> params=new ArrayList<String>();
		params.add("exit");	
		setChanged();
		notifyObservers(params);	
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//sokobanDisplayer.setLvl(lvl);
		sokobanDisplayer.setFocusTraversable(true);
	//	sokobanDisplayer.addEventFilter(MouseEvent.MOUSE_CLICKED,(e)->sokobanDisplayer.requestFocus());
		sokobanDisplayer.setOnKeyPressed(new EventHandler<KeyEvent>() {
			
			@Override
			public void handle(KeyEvent event) {
				
				if(event.getCode()==KeyCode.UP){
					List<String> params=new ArrayList<String>();
					params.add("move");	
					params.add("up");
					setChanged();
					notifyObservers(params);					
				}
				if(event.getCode()==KeyCode.DOWN){
					List<String> params=new ArrayList<String>();
					params.add("move");	
					params.add("down");
					setChanged();
					notifyObservers(params);					
				}
				if(event.getCode()==KeyCode.LEFT){
					List<String> params=new ArrayList<String>();
					params.add("move");	
					params.add("left");
					setChanged();
					notifyObservers(params);					
				}
				if(event.getCode()==KeyCode.RIGHT){
					List<String> params=new ArrayList<String>();
					params.add("move");	
					params.add("right");
					setChanged();
					notifyObservers(params);					
				}

			}
			
		});
	}

	@Override
	public void Exit() {
		
		
	}

	

}







