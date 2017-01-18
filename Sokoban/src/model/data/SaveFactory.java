package model.data;

import java.util.HashMap;

import common.Level;

public class SaveFactory {
	Level lvl;
	HashMap<String,SaveCreator> LevelCreators ;
	
	
	private interface SaveCreator{
		public LevelSaver create();
	}
	public class TxtCreator implements SaveCreator
	{

		@Override
		public LevelSaver create()
		{
			return new MyTextLevelSaver(lvl);
		
		}
	}
	public class XmlCreator implements SaveCreator
	{
			@Override
			public LevelSaver create()
				{
				return new MyXMLLevelSaver(lvl);
				}
	}
	public class ObjCreator implements SaveCreator
	{
				@Override
			public LevelSaver create()
					{
				return new MyObjectLevelSaver(lvl);
				}
	}
			
	public SaveFactory(Level lvl) {
		this.lvl=lvl;
		LevelCreators=new HashMap<String,SaveCreator>();
		LevelCreators.put("txt", new TxtCreator());
		LevelCreators.put("xml", new XmlCreator());
		LevelCreators.put("obj", new ObjCreator());
	}	
	
	public LevelSaver CreateLevel(String type){
		SaveCreator l= LevelCreators.get(type);
		if (l!=null)	return l.create();
		return null;
	}
	
}

