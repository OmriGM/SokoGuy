package model;

import common.Level;

public interface Model {
	Level GetLvl();
	void Move (String direction);
	public void load(String fileName);
	public void save(String filename);
	public void Exit();
}
