package commands;

public class ExitCommand implements Command {
	CLI c;
public ExitCommand(CLI c) {
	this.c=c;
}
	@Override
	public void Execute() {
		c.gamerun=false;
		System.out.println("BYE BYE");
	}
}
