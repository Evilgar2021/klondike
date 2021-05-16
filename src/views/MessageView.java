package views;

import utils.IO;

public class MessageView {
	private String message;
	private IO io = new IO();

	public MessageView(String message) {
		io = new IO();
		this.message = message;
	}

	public void printMessage() {
		io.writeln("----------------------------------");
		io.writeln(message);
		io.writeln("----------------------------------");
	}
}