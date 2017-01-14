package load;

import java.io.IOException;
import java.io.InputStream;

import levels.Level;

public  interface LevelLoader {
	public  Level  loadLevel(InputStream x) throws IOException;
	 
}
