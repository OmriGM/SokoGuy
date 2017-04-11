package controller.commands;

import java.io.IOException;

import view.View;

public class FinishedCommand extends Command {
	View view;
	
	
	public FinishedCommand(View view) {
		this.view=view;
		
	}
	@Override
	public void Execute() {
		
		view.lvlFinished();
	}

}
