package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

import common.Level;
import javafx.beans.property.IntegerProperty;
import model.data.LevelLoader;
import model.data.LevelSaver;
import model.data.LoadFactory;
import model.data.SaveFactory;
import model.policy.MyPolicy;
import model.policy.Policy;

public class MyModel extends Observable implements Model {
	Level lvl;
	Policy p=new MyPolicy();
	Timer t=null;
	TimerTask tt;
	@Override
	public Level GetLvl() {
		return lvl;
	}

	@Override
	public void Move(String direction) {
		boolean moveHappen;
		moveHappen=	(p.move(lvl, direction)>0);
		if (moveHappen){
			lvl.setStepCounter(lvl.getStepCounter()+1);
			if(lvl.Finish()){
				t.cancel();
				this.setChanged();
				List<String> params=new LinkedList<String>();
				params.add("display lvl");
				this.notifyObservers(params);
				this.setChanged();
				params=new LinkedList<String>();
				params.add("lvl finished");
				this.notifyObservers(params);
				params.add("stop timer");
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
		if(t!=null)
			t.cancel();
		t=new  Timer();
		t.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {		
				lvl.setTimeCount(lvl.getTimeCount().get()+1);
				//Counter.set(""+(lvl.setTimeCount(lvl.getTimeCount()+1)));
			}
		}, 0, 1000);
		
		
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

	@Override
	public void Exit() {
		if(t!=null)
			
			t.cancel();
		
	}


}
