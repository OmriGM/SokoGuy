package controller.commands;

import java.io.IOException;

import SokoDB.SokoDBManager;
import view.View;

public class ShowLevelCommand extends Command {
	View v;
	
	public ShowLevelCommand(View v) {
		this.v=v;
	}
	@Override
	public void Execute() throws IOException {
		SokoDBManager.getScoreList(params.get(0),"");
	}

}
