package view;
import controller.MyController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.MyModel;


public class GUIRun extends Application implements Runnable{
		private String[] args;
		private boolean stop=false;
		
		

		public void setStop(boolean stop) {
			this.stop = stop;
		}


			public void runTheGUI(String[] args){
				
			
				this.args=args;
				this.run();
				
				
			}
			@Override
			public void start(Stage primaryStage) {
				try {
					FXMLLoader fxmlLoader = new FXMLLoader(SokobanViewer.class.getResource("SokobanWindow.fxml"));
					BorderPane root = fxmlLoader.load();
					Scene scene = new Scene(root,600,500);
					SokobanViewer ui = fxmlLoader.getController();
					
					
					MyModel model = new MyModel();
					MyController c= new MyController(ui,model);
					model.addObserver(c);
		            ui.addObserver(c);
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					primaryStage.setScene(scene);
					primaryStage.show();
					
		
					
					
					
					
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			@Override
			public void run() {
				launch(args);				
			}	
}

		
//		CLI commandline=new CLI();
//		
//		System.out.println("\nWelcome to our Sokoban Game!\n\n"
//				+ "*******************************************************************************************\n"
//				+ "The objective of the Sokoban game is to move boxes to designated locations by pushing them.\n"
//				+ "*******************************************************************************************\n");
//		System.out.println("\t\t\t\t\tMenu\n"
//				+ "1.Load filename.xxx  		 -(txt,xml,obj,etc) you can load as many levels as you want\n"
//				+ "2.Display 	      		 - displays the current level beeing played\n"
//				+ "3.Play level X       		 -(for exmaple: 'Play level 1', for playing the first level that was loaded\n"
//				+ "4.Move (up,down,right,left)      - moves the character to the dierction you pick\n"
//				+ "5.Save filename.xxx   		 -(txt,xml,obj,etc) saves the current level\n"
//				+ "6.Exit                		 - Ends the game\n\n"
//				+ "Have fun!\n");
//						
//		
//		commandline.commands();
//
//		
//	}
//		
//}