package commands;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import levels.Level;
import save.LevelSaver;
import save.SaveFactory;

public class SaveCommand implements Command {
	String filename;
	String fin;
	CLI cli;
	OutputStream out;
	SaveFactory sf;
	LevelSaver levelsaver;
	
	
public SaveCommand(String filename,CLI cli) throws FileNotFoundException {
	this.filename=filename;
	this.cli=cli;
	out=new FileOutputStream(filename);
	sf=new SaveFactory(cli.lvl.get(cli.lvlnumber-1));
	fin=filename.substring(filename.length()-3);
}
		


	@Override
	public void Execute() throws IOException {
		levelsaver=sf.CreateLevel(fin);
		levelsaver.saveLevel(out);

	}

}
