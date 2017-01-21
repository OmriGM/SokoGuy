package view;

import common.Level;
import javafx.stage.Stage;

public interface View {
	//void start(Stage primaryStage);
	void exit();
	void displayLevel(Level lvl);
	public void openFile();
	
}
