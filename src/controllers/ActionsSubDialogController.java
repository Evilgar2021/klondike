package controllers;

import java.util.ArrayList;

public abstract class ActionsSubDialogController extends ActionController {
	private ArrayList<SubDialogController> subdialogControllers;

	protected ActionsSubDialogController(modelos.Juego juego, ArrayList<SubDialogController> subdialogControllers) {
		super(juego);
		assert (subdialogControllers != null);
		this.subdialogControllers = subdialogControllers;
	}

	public ArrayList<SubDialogController> getSubDialogControllers() {
		return subdialogControllers;
	}
}
