package controller.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class MyClientHandler extends Observable implements ClientHandler {

	@Override
	public void handleClient(InputStream inFromClient, OutputStream outFromClient) {
		BufferedReader reader =  new BufferedReader(new InputStreamReader(inFromClient));
		String clientInput;
		try {
			clientInput = reader.readLine();
		
		if(clientInput.equals("exit")){
			List<String> params=new ArrayList<String>();
			params.add("exit");	
			setChanged();
			notifyObservers(params);	
			}
		
		if(clientInput.equals("display")){
			List<String> params=new ArrayList<String>();
			params.add("display");	
			setChanged();
			notifyObservers(params);
		}
		
		if (clientInput.startsWith("load")){
			
			List<String> params=new ArrayList<String>();
			params.add("load");	
			clientInput.substring(5);
			params.add(clientInput);
			setChanged();
			notifyObservers(params);
	
			
		
			}
		if (clientInput.startsWith("save")){
			List<String> params=new ArrayList<String>();
			params.add("save");	
			clientInput.substring(5);
			params.add(clientInput);
			setChanged();
			notifyObservers(params);

			}
		if (clientInput.startsWith("move")){
			List<String> params=new ArrayList<String>();

			if(clientInput.split(" ")[1]!=null){
			String key=clientInput.split(" ")[1];
			switch (key) {
			case "Up":
			case "up":
			case "down":
			case "Down":
			case "Right":
			case "right":
			case "Left":
			case "left":
				params.add("move");	
				clientInput.substring(5);
				params.add(clientInput);
				setChanged();
				notifyObservers(params);
				break;
			default:
				System.out.println("bad key");
				break;
				}
		
			}
			
		}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
