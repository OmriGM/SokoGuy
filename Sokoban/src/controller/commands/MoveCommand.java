package controller.commands;



import common.Character;
import common.Level;
import model.Model;


public class MoveCommand extends Command {

	Model model;
	Character a;
	Level lvl;
	
	public MoveCommand(Model model) {
		this.model=model;	
	}

	@Override
	public void Execute() {
		String direction=params.get(0);
		model.Move(direction);
	}
}
