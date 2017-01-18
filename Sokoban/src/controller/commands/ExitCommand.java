package controller.commands;

import model.Model;

public class ExitCommand extends Command {
	Model model;
public ExitCommand(Model model) {
	this.model=model;
}

	@Override
	public void Execute() {
		
		System.out.println("BYE BYE");
	}
}
