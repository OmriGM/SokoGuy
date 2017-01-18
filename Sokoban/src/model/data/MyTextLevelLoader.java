package model.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import common.Box;
import common.Character;
import common.Level;


public class MyTextLevelLoader implements LevelLoader  {
	
	@Override
	public Level loadLevel(InputStream x) throws IOException  {
		
		BufferedReader reader =  new BufferedReader(new InputStreamReader(x));
			
		String rowcheck;
		int maxrow=0;
		int maxline=0;
		int i=0;
		
		ArrayList<String> ans= new ArrayList<String>();
			//count how many lines and rows there are in the file
			while((rowcheck=reader.readLine())!=null){
				int temp=rowcheck.length();
				if (temp>maxrow)
					maxrow=temp;
				maxline++;
				ans.add(rowcheck);
				
			}
						
			Level lvl=new Level(maxline,maxrow);
						
			for (String result: ans){
				
				for(int j=0;j<result.length();j++){
					
					if(result.charAt(j)=='#'){
						lvl.setBackgroundObjects(new Wall(i,j));
						lvl.getWallArray().add(lvl.getBackgroundObjects(i,j));
						
							
					}
					else if(result.charAt(j)=='o'){
						lvl.setBackgroundObjects(new Target(i,j));
						lvl.getTargetArray().add
							(lvl.getBackgroundObjects(i,j));
					}
					else if(result.charAt(j)==' '){
						lvl.setBackgroundObjects(new Floor(i,j));
						lvl.getFloorArray().add
							(lvl.getBackgroundObjects(i,j));
					}
					else if(result.charAt(j)=='A'){
						lvl.setMovAbleTable(new Character(i,j));
						lvl.getCharacterArray().add
							(lvl.getMovAbleTable(i,j));
						lvl.setBackgroundObjects(new Floor(i,j));
						lvl.getFloorArray().add
							(lvl.getBackgroundObjects(i,j));
						}
					else if(result.charAt(j)=='@'){
						lvl.setMovAbleTable(new Box(i,j));
						lvl.getBoxArray().add
							(lvl.getMovAbleTable(i,j));
						lvl.setBackgroundObjects(new Floor(i,j));
						lvl.getFloorArray().add
							(lvl.getBackgroundObjects(i,j));
						
						}
					else if (result.charAt(j)=='+'){
						lvl.setMovAbleTable(new Box(i,j));
						lvl.setBackgroundObjects(new Target(i,j));
						lvl.getBoxArray().add
							(lvl.getMovAbleTable(i,j));
						lvl.getTargetArray().add
							(lvl.getBackgroundObjects(i,j));
						lvl.setBoxontarget(lvl.getBoxontarget()+1);
						}
					else if (result.charAt(j)=='a'){
						lvl.setMovAbleTable(new Character(i,j));
						lvl.getCharacterArray().add
							(lvl.getMovAbleTable(i,j));
						lvl.setBackgroundObjects(new Target(i,j));
						lvl.getTargetArray().add
							(lvl.getBackgroundObjects(i,j));
						}
					}
				i++;
				}
	
		reader.close();
		return lvl;	
	}
		
}


	
