package Boot;


import SokoDB.SokoDBManager;
import view.GUIRun;


public class Main {

 public static void main(String[] args) { 
  
  Thread t=new Thread(new Runnable() {
   
   @Override
   public void run() {
    SokoDBManager.getInstance();
    
   }
  });
  
  GUIRun gr=new GUIRun();
  t.start();
  gr.runTheGUI(args);
  

 }  
}