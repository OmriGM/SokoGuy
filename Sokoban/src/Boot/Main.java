package Boot;


import view.GUIRun;


public class Main {
	public static void main(String[] args) {
		GUIRun gr=new GUIRun();
		gr.runTheGUI(args);
//		SokobanViewer ui=gr.getLoader().getController();
//		System.out.println(ui);
//	
//		MyModel model = new MyModel();
//		MyController c= new MyController(ui,model);
//		model.addObserver(c);
//		ui.addObserver(c);
//	
	}		
}
