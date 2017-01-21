package Boot;

import controller.MyController;
import model.MyModel;
import view.GUIRun;
import view.SokobanViewer;

public class Main {
	public static void main(String[] args) {
		GUIRun gr=new GUIRun();
		SokobanViewer ui= new SokobanViewer();
		MyModel model = new MyModel();
		MyController c= new MyController(ui,model);
		model.addObserver(c);
		ui.addObserver(c);
		gr.runTheGUI(args);
	}		
}
