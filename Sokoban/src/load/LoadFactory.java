package load;

import java.util.HashMap;

public class LoadFactory {
	HashMap<String,LoadCreator> LevelCreators ;
	
	private interface LoadCreator{
		public LevelLoader create();
	}
	public class TxtCreator implements LoadCreator
	{

		@Override
		public LevelLoader create()
		{
			return new MyTextLevelLoader();
		
		}
	}
	public class XmlCreator implements LoadCreator
	{
			@Override
			public LevelLoader create()
				{
				return new MyXMLLevelLoader();
				}
	}
	public class ObjCreator implements LoadCreator
	{
				@Override
			public LevelLoader create()
					{
				return new MyObjectLevelLoader();
				}
	}
			
	public LoadFactory() {
		LevelCreators=new HashMap<String,LoadCreator>();
		LevelCreators.put("txt", new TxtCreator());
		LevelCreators.put("xml", new XmlCreator());
		LevelCreators.put("obj", new ObjCreator());
	}	
	
	public LevelLoader CreateLevel(String type){
		LoadCreator l= LevelCreators.get(type);
		if (l!=null)	return l.create();
		return null;
	}
	
}

