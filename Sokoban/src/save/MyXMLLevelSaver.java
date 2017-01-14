package save;

import java.beans.XMLEncoder;
import java.io.OutputStream;

import levels.Level;

public class MyXMLLevelSaver implements LevelSaver {
	Level lvl;
	public MyXMLLevelSaver(Level lvl) {
		this.lvl=lvl;
	}
	@Override
	public void saveLevel(OutputStream x) {
		XMLEncoder xml=new XMLEncoder(x);
		
		xml.writeObject(lvl);
		xml.close();

	}

}
