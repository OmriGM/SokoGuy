package controller.commands;


import controller.Controller;
import model.Model;
import view.View;

public class ExitCommand extends Command {
	Model model;
	View view;
	Controller controller;
	public ExitCommand(Controller controller,Model model,View view) {
		this.model=model;
		this.view=view;
		this.controller=controller;
	}

	@Override
	public void Execute() {
		
		model.Exit();
		view.Exit();
		controller.Stop();
	}
}
