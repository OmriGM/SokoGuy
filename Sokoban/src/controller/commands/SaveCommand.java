package controller.commands;

import model.Model;

public class SaveCommand extends Command {
	Model model;
		
public SaveCommand(Model model) {
	this.model=model;
}
	@Override
	public void Execute() {
		String filename=params.get(0);
		model.save(filename);
	}
}
