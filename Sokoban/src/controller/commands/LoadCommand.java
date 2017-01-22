package controller.commands;

import model.Model;

public class LoadCommand extends Command  {
	Model model;

	
public LoadCommand(Model model) {
	this.model=model;
}
	@Override
	public void Execute()  {
		String filename=params.get(0);
		System.out.println(filename);
		model.load(filename);
	}

}
