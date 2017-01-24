package view;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

import common.Level;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.event.Event;
import javafx.event.EventDispatchChain;
import javafx.event.EventDispatcher;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class SokobanViewer extends Observable implements View,Initializable {
	@FXML
	SokobanDisplayer sokobanDisplayer;
	@FXML
	Label stepCounter;
	SokobanSounds sounds;
    boolean finishedLvl=false;
	Level lvl;
	Stage stage;
	
	public SokobanViewer() {
		sounds=new SokobanSounds();
		sounds.backGroundSound();
		
	}

	@Override
	public void bindCounter(IntegerProperty stepCounter) {
		this.stepCounter.textProperty().bind(stepCounter.asString());	
	}

	@Override
	public void displayLevel(Level lvl) {
		sokobanDisplayer.setLvl(lvl);	
		
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
			finishedLvl=false;
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
	
	public void setStage(Stage primaryStage) {
		
		stage=primaryStage;	
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			
			@Override
			public void handle(WindowEvent event) {
			if	(event.getEventType()==WindowEvent.WINDOW_CLOSE_REQUEST){
				ExitCommand();
				}
			}
		});
	}
	
	@Override
	public void Exit() {	
		stage.close();
	}
	
	public void lvlFinished(){
		finishedLvl=true;
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				Alert alert = new Alert(AlertType.INFORMATION);
		        alert.setTitle("Level Finished");
		        alert.setHeaderText("You Won! Congrats!");
		        alert.setContentText("Press OK and load a new level");
		        alert.showAndWait();				
			}
		});
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		sokobanDisplayer.setFocusTraversable(true);
		//	sokobanDisplayer.addEventFilter(MouseEvent.MOUSE_CLICKED,(e)->sokobanDisplayer.requestFocus());
		
			sokobanDisplayer.setOnKeyPressed(new EventHandler<KeyEvent>() {
				
				@Override
				public void handle(KeyEvent event) {
					if(event.getCode()==KeyCode.ESCAPE){
						List<String> params=new ArrayList<String>();
						params.add("exit");
						setChanged();
						notifyObservers(params);
					}
					if(!finishedLvl){
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
				}			
			});	
		
	}

	
}
