package view;

import java.util.Observable;

import common.Level;

public class GUI extends Observable implements View {

	@Override
	public void start() {
		Thread thread=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
		thread.start();
		
	}


	@Override
	public void displayLevel(Level lvl) {
		// TODO Auto-generated method stub
		
	}

	
}
