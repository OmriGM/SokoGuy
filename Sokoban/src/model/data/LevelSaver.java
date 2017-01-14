package model.data;

import java.io.IOException;
import java.io.OutputStream;

public interface LevelSaver {
	public void saveLevel(OutputStream x)throws IOException;
}
