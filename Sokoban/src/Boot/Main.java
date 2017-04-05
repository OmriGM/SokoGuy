package Boot;


import java.util.logging.Level;
import java.util.logging.Logger;

import SokoDB.Score;
import SokoDB.SokoDBManager;
import view.GUIRun;


public class Main {

	public static void main(String[] args) {
//		//DB check:
//		Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
//		
//		SokoDBManager manager = SokoDBManager.getInstance();
//		Score score=new Score("Omri",  "Grossman",  36,  78);
//		manager.addScore(score);
//		System.out.println("Player name: " + score.getUserName());
//		System.out.println("Level name: " + score.getLevelName());
//		manager.close();
		
		
		
		GUIRun gr=new GUIRun();
		gr.runTheGUI(args);
		
		
		
	}		
}
