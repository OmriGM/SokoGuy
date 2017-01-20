package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

import common.Character;
import common.Level;
import model.data.LevelLoader;
import model.data.LevelSaver;
import model.data.LoadFactory;
import model.data.SaveFactory;
import model.policy.MyPolicy;
import model.policy.Policy;

public class MyModel extends Observable implements Model {
	Level lvl;
	Policy p=new MyPolicy();
	
	@Override
	public Level GetLvl() {
		return lvl;
	}

	@Override
	public void Move(String direction) {
		boolean moveHappen;
		moveHappen=	(p.move(lvl, direction)>0);
		if (moveHappen){
			if(lvl.Finish()){
				this.setChanged();
				List<String> params=new LinkedList<String>();
				params.add("lvl finished");
				this.notifyObservers(params);
			}
			else{
				this.setChanged();
				List<String> params=new LinkedList<String>();
				params.add("display lvl");
				this.notifyObservers(params);
			}
		}	 
	}
	@Override
	public void load(String fileName){
		String fin;
		InputStream in;
		LoadFactory lf;
		LevelLoader levelLoader;
		lf=new LoadFactory();
		fin=fileName.substring(fileName.length()-3);
		levelLoader=lf.CreateLevel(fin);
		try {
			in=new FileInputStream(fileName);
			lvl=levelLoader.loadLevel(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setChanged();
		List<String> params=new LinkedList<String>();
		params.add("display lvl");
		this.notifyObservers(params);			
	}
	@Override
	public void save(String filename){
		String fin;
		OutputStream out;
		SaveFactory sf;
		LevelSaver levelsaver;
		try {
		out=new FileOutputStream(filename);
		sf=new SaveFactory(lvl);
		fin=filename.substring(filename.length()-3);	
		levelsaver=sf.CreateLevel(fin);
		levelsaver.saveLevel(out);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
