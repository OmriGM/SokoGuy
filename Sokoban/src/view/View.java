package view;

import common.Level;
import javafx.beans.property.IntegerProperty;

public interface View {
	void Exit();
	void displayLevel(Level lvl);
	public void openFile();
	public void saveFile();
	void ExitCommand();
	void bindCounter(IntegerProperty stepCounter);
	
}
