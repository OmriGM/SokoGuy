package view;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//import common.Level;
//import controller.commands.Command;
//import controller.commands.DisplayLevelCommand;
//import controller.commands.ExitCommand;
//import controller.commands.LoadCommand;
//import controller.commands.MoveCommand;
//import controller.commands.SaveCommand;
//
public class CLI {
//	Command c;
//	ArrayList<Level> lvl;
//
//	int lvlnumber;
//	boolean gamerun;
//	public CLI() {
//		lvl=new ArrayList<Level>();
//		lvlnumber=1;
//		gamerun=true;
//	}
//	
//	public void commands(){
//	try{
//	 while(gamerun){
//		
//		 Scanner in= new Scanner(System.in);
//		 String command=null;
//	
//			 command=in.nextLine();
//		 
//		if(command.equals("Exit")||command.equals("exit")){
//			c=new ExitCommand(this);
//			c.Execute();
//			}
//		
//		if(command.equals("Display")||command.equals("display")){
//			
//			c=new DisplayLevelCommand(lvl.get(lvlnumber-1));
//			c.Execute();
//		}
//		
//		if (command.startsWith("Load")||command.startsWith("load")){
//			
//			
//			try {
//				c=new LoadCommand(command.substring(5),this);
//				c.Execute();
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		
//			}
//		if (command.startsWith("Save")||command.startsWith("save")){
//			c=new SaveCommand(command.substring(5),this);
//			c.Execute();
//			
//			}
//		if (command.startsWith("Move")||command.startsWith("move")){
//			String key=command.split(" ")[1];
//			switch (key) {
//			case "Up":
//			case "up":
//			case "down":
//			case "Down":
//			case "Right":
//			case "right":
//			case "Left":
//			case "left":
//				c=new MoveCommand(lvl.get(lvlnumber-1),key);
//				c.Execute();
//				break;
//			default:
//				System.out.println("bad key");
//				break;
//						}
//			}
//		 if (command.startsWith("Play")||command.startsWith("play")){
//			
//			 switch (command.split(" ")[1]) {
//			case "level":
//			case "lvl":
//			case "Level":
//				
//				 lvlnumber= Integer.parseInt(command.split(" ")[2]);
//				break;
//			case "last":
//			case "Last":
//				
//				lvlnumber=lvl.size();
//			default:
//				System.out.println("bad key");
//				break;
//			}
//			
//		 }
//		
//		}
//	
//	
//	}
//	catch (IOException e)
//	{
//		e.printStackTrace();
//	
//	}
//}
}
