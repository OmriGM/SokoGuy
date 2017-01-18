package controller.commands;

import common.Level;
import model.Model;
import recivers.Displayer;
import view.View;

public class DisplayLevelCommand extends Command {
	Model model;
	View view;
	//Displayer displayer;
	
	public DisplayLevelCommand(Model model,View view) {
		this.model=model;
		this.view=view;
		//displayer=new Displayer();
	}
	
	
	@Override
	public void Execute() {
		Level lvl = model.GetLvl();
		view.displayLevel(lvl);
	}


}
