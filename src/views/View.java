package views;

import controllers.ActionController;
import controllers.ControllerVisitor;
import controllers.MenuController;

public abstract interface View extends ControllerVisitor {
	public abstract int interactWithMenu(MenuController paramMenuController);

	public abstract void interact(ActionController paramActionController);

	public abstract void showTheEndOfGameMessage();
}
