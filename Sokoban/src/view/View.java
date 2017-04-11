package view;

import common.Level;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public interface View {
	void Exit();
	void displayLevel(Level lvl);
	public void openFile();
	public void saveFile();
	public void showLevelTable();
	void ExitCommand();
	void bindCounter(IntegerProperty stepCounter);
	void bindTimeCounter(IntegerProperty timeCounter);
	void lvlFinished();
	
}
