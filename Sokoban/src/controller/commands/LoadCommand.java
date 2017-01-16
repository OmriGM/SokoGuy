package controller.commands;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import model.data.Level;
import model.data.LevelLoader;
import model.data.LoadFactory;

public class LoadCommand implements Command  {
	String filename;
	String fin;
	InputStream in;
	LoadFactory lf;
	LevelLoader levelloader;
	CLI cli;
	Level lvl;
public LoadCommand(String filename,CLI cli) throws FileNotFoundException {
	this.filename=filename;
	in=new FileInputStream(filename);
	lf=new LoadFactory();
	this.cli=cli;
	fin=filename.substring(filename.length()-3);
	
}
	@Override
	public void Execute() throws IOException {
		levelloader=lf.CreateLevel(fin);
		lvl=levelloader.loadLevel(in);
		cli.lvl.add(lvl);
	}

}
