package commands;

import levels.Level;
import recivers.Displayer;

public class DisplayLevelCommand implements Command {
	Level lvl;
	Displayer displayer;
	public DisplayLevelCommand(Level lvl) {
		this.lvl=lvl;
		displayer=new Displayer();
	}
	
	
	@Override
	public void Execute() {
		displayer.Display(lvl);
		
	}


}
