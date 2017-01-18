package controller.commands;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import model.Model;
import model.data.LevelSaver;
import model.data.SaveFactory;
import view.CLI;
import view.View;

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
