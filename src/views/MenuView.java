package views;

import controllers.MenuController;
import utils.IO;
import utils.LimitIntDialogo;

public class MenuView {
	MenuController menuController;
	private IO io = new IO();

	public MenuView(MenuController menuController) {
		this.menuController = menuController;
	}

	public int exploreMenu() {
		printBoard();
		return new LimitIntDialogo("Opcion?", 8).read();
	}

	private void printBoard() {
		io.writeln("____________________________");
		printBaraja();
		printDescarte();
		printFundaciones();
		printPilas();
		io.writeln("_____________________________");
		printMenu();
	}

	private void printBaraja() {
		menuController.getStringBaraja();
	}

	private void printDescarte() {
		menuController.getStringDescarte();
	}

	private void printFundaciones() {
		menuController.printStringFundaciones();
	}

	private void printPilas() {
		menuController.printStringPilas();
	}

	private void printMenu() {
		io.write(menuController.getStringOptionsMenu());
	}
}