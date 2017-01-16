package controller.commands;

import model.data.Character;
import model.data.Level;

public class MoveCommand implements Command {
	String direction;
	Character a;
	Level lvl;
	
	//display command for check
	DisplayLevelCommand dlc;
	public MoveCommand(Level lvl,String direction) {
		this.direction=direction;
		this.lvl=lvl;
		this.a=(Character)lvl.getCharacterArray().get(0);
		
	}

	@Override
	public void Execute() {
	a.move(lvl, direction);
	//display command for check
	dlc=new DisplayLevelCommand(lvl);
	dlc.Execute();
	
	if(lvl.Finish())
		System.out.println("level is finished");
	}

}
