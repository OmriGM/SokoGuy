package model.data;

import java.beans.XMLDecoder;
import java.io.InputStream;


public class MyXMLLevelLoader implements LevelLoader {

	Level lvl;
	@Override
	public Level loadLevel(InputStream x)  {
		XMLDecoder in = new XMLDecoder(x);
		Level lvl=null;
		lvl=(Level)in.readObject();
		in.close();
		return lvl;
	}

}
