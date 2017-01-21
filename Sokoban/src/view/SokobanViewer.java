package view;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

import common.Level;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;

public class SokobanViewer extends Observable implements View,Initializable {
	SokobanDisplayer sokobanDisplayer;
	Level lvl;
	public static SokobanViewer sv;
	
	
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
			String[] array=choosen.getName().split(" ");
			for(String s : array)
				params.add(s);
			this.setChanged();
			
			System.out.println(this.countObservers());
			//params.add(choosen.getName());
			notifyObservers(params);
//			for(String s : params)
//				System.out.println(s); //Level file name 
		}
	}


	@Override
	public void exit() {
		
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}







