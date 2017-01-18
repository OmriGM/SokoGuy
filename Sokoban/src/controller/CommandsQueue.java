package controller;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import controller.commands.Command;

public class CommandsQueue {
	private BlockingQueue<Command> queue;
	private boolean isStopped=false;
	
	BlockingQueue<Command>  commandsQueue;
	public CommandsQueue() {
		queue=new ArrayBlockingQueue<Command>(10);
	}
	
	void insertCommand(Command command){
		try {
			queue.put(command);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	void start(){
		Thread thread=new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(!isStopped){
					Command cmd;
					try {
						cmd = queue.poll(1, TimeUnit.SECONDS);
						if(cmd!=null)
							try {
								cmd.Execute();
							} catch (IOException e) {
								e.printStackTrace();
							}
					} catch (InterruptedException e) {
						e.printStackTrace();									
					}	
				}
			}
		});
			
		thread.start();
		
		
	}
	void stop(){
		isStopped=true;
		Thread.currentThread().stop();
	}
		
}
