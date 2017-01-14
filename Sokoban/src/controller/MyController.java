package controller;

import java.util.Observable;
import java.util.Observer;

import model.Model;
import view.View;

public class MyController implements Controller,Observer{
	View ui;
	Model model;
	public MyController(View ui, Model m) {
		this.ui=ui;
		this.model=m;
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
