package controller.commands;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import common.Level;
import model.Model;
import model.data.LevelLoader;
import model.data.LoadFactory;
import view.CLI;
import view.View;

public class LoadCommand extends Command  {
	Model model;

	
public LoadCommand(Model model) {
	this.model=model;
}
	@Override
	public void Execute()  {
		String filename=params.get(0);
		model.load(filename);
	}

}
