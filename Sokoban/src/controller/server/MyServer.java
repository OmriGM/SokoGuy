package controller.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class MyServer {
	private int port;
	private ClientHandler ch;
	private volatile boolean stop;
	
	public MyServer(int port,ClientHandler ch) {
		this.port=port;
		this.ch=ch;
		stop=false;
	}

	public void runServer() throws IOException {
		ServerSocket server=new ServerSocket(port);
		server.setSoTimeout(1000);//timeout of the socket defined to 1 second
		while(!stop){
		try{
		
				Socket aClient=server.accept();
				InputStream inFromClient=aClient.getInputStream();
				OutputStream outToClient=aClient.getOutputStream();
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						try{
						ch.handleClient(inFromClient, outToClient);
						aClient.getInputStream().close();
						aClient.getOutputStream().close();
						aClient.close();
						}catch(IOException e){}
					}
				}).start();
			
			}catch(SocketTimeoutException e){}
		}
		server.close();//close the threads of the server.
	}

	public void start() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try{
					runServer();
				}
				catch(Exception e){}
				
			}
		}).start();
	}
	public void stop(){
		this.stop=true;
	
		
	}
}	//close class
