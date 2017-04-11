package view;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Optional;
import java.util.ResourceBundle;

import SokoDB.Score;
import SokoDB.SokoDBManager;
import common.Level;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
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
	@FXML
	Label timeCounter;
	SokobanSounds sounds;
    boolean finishedLvl=false;
	Level lvl;
	Stage stage;
	LevelTableViewer lvlTableViewer;
	Score score;
	String levelName;
	
	public SokobanViewer() {
		sounds=new SokobanSounds();
		sounds.backGroundSound();
		
		
	}
	@Override
	public void bindTimeCounter(IntegerProperty timeCounter) {
		this.timeCounter.textProperty().bind(timeCounter.asString());
		
	}


	@Override
	public void bindCounter(IntegerProperty stepCounter) {
		this.stepCounter.textProperty().bind(stepCounter.asString());	
		this.stepCounter.setTranslateY(240);
		this.stepCounter.setTranslateX(50);
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
			levelName=choosen.getName().substring(0,choosen.getName().length()-4 );
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
	public void showLevelTable() {
		
		lvlTableViewer=new LevelTableViewer(levelName);
		lvlTableViewer.start(new Stage());
		
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
				TextInputDialog dialog = new TextInputDialog("");
				dialog.setTitle("Level Finished");
				dialog.setHeaderText("You Won! Congrats! took you only "+stepCounter.getText()+" moves");
				dialog.setContentText("Please enter your name:");

				// Traditional way to get the response value.
				Optional<String> result = dialog.showAndWait();
				if (result.isPresent()){
				    System.out.println("Your name: " + result.get());
				    int steps= Integer.parseInt(stepCounter.getText());
				    int time= Integer.parseInt(timeCounter.getText());
					score = new Score(result.get(), levelName, steps, time);
					SokoDBManager.getInstance().addScore(score);
				}
				
				
			}
		});
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		sokobanDisplayer.setFocusTraversable(true);
		
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
