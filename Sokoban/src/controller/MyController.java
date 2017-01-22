package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import controller.commands.Command;
import controller.commands.DisplayLevelCommand;
import controller.commands.ExitCommand;
import controller.commands.FinishedCommand;
import controller.commands.LoadCommand;
import controller.commands.MoveCommand;
import controller.commands.SaveCommand;
import model.Model;
import view.View;

public class MyController implements Controller,Observer{
	private View view;
	private Model model;
	private CommandsQueue cq;
	private Map<String, Command> commands;
	
	public MyController(View v, Model m) {
		this.view=v;
		this.model=m;
		initCommands();
		cq=new CommandsQueue();
		cq.start();
	}
	protected void initCommands() {
		commands=new HashMap<String,Command>();
		commands.put("move", new MoveCommand(model));
		commands.put("display lvl", new DisplayLevelCommand(model,view));
		commands.put("load", new LoadCommand(model));
		commands.put("save", new SaveCommand(model));
	//	commands.put("exit", new ExitCommand(model,view));
		commands.put("lvl finished", new FinishedCommand(view));
		
	}
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Checking if  i got here(Update function)");
		List<String> params=(List<String>)arg;
		String commandkey=params.remove(0);
		Command c= commands.get(commandkey);
		//TO DO: display error when c is null
		if(c==null)
		{
			return;
		}
		c.setParams(params);
		cq.insertCommand(c);
	}

}
