package model.data;

import java.io.IOException;
import java.io.InputStream;

import common.Level;

public  interface LevelLoader {
	public  Level  loadLevel(InputStream x) throws IOException;
	 
}
