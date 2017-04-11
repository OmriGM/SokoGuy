package controller.commands;

import java.io.IOException;

import model.Model;

public class KillTimerCommand extends Command {
	Model m;
	KillTimerCommand(Model m){
		this.m=m;	
	}
	@Override
	public void Execute() throws IOException {
		m.Exit();

	}

}
