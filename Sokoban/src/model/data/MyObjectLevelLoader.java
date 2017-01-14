package load;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import levels.Level;

public class MyObjectLevelLoader implements LevelLoader {

	@Override
	public Level loadLevel(InputStream x) throws IOException{
		ObjectInputStream in=new ObjectInputStream(x);
		Level lvl = null;
		try {
			lvl=(Level)in.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		in.close();
		return lvl;
	}

}
