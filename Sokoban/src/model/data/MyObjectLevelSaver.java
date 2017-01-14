package model.data;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyObjectLevelSaver implements LevelSaver {
	Level lvl;
	public MyObjectLevelSaver(Level lvl	) {
		this.lvl=lvl;
	}
	@Override
	public void saveLevel(OutputStream x) throws IOException {
		ObjectOutputStream out= new ObjectOutputStream(x);
		out.writeObject(lvl);
		out.close();
	}
}
