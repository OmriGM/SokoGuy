package controller.commands;

import com.sun.glass.ui.View;

import model.Model;

public class ExitCommand extends Command {
	Model model;
	View view;
	public ExitCommand(Model model) {
		this.model=model;
		this.view=view;
	}

	@Override
	public void Execute() {
//		model.exit();
//		view.exit();
	}
}
