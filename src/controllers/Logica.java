package controllers;

import java.util.ArrayList;
import modelos.Juego;

public class Logica {
	Juego juego;
	MenuController menuController;
	ArrayList<ActionController> actionsControllers;

	public Logica() {
		assert (juego != null);
		juego = new Juego();
		initMenuController();
		initActionControllers();
	}

	public Juego getJuego() {
		return juego;
	}

	public modelos.Partida getPartida() {
		return juego.getPartida();
	}

	private void initMenuController() {
		menuController = new MenuController(juego);
	}

	public boolean isTheEnd() {
		return juego.isJuegoTerminado();
	}

	public MenuController getMenuController() {
		return menuController;
	}

	private void initActionControllers() {
		actionsControllers = new ArrayList();
		actionsControllers.add(new MovimientoDeBarajaADescarte(juego));
		actionsControllers.add(new MovimientoDescarteABaraja(juego));
		actionsControllers.add(new MovimientoDeDescarteAFundacion(juego));
		actionsControllers.add(new MovimientoDeDescarteAEscalera(juego,
				new SubDialogController(juego)));

		ArrayList<SubDialogController> subdialogControllers = new ArrayList(1);
		subdialogControllers.add(new SubDialogController(juego));
		actionsControllers.add(new MovimientoDeEscaleraAFundacion(juego,
				subdialogControllers));

		subdialogControllers = new ArrayList(3);
		subdialogControllers.add(new SubDialogController(juego));
		subdialogControllers.add(new SubDialogController(juego));
		subdialogControllers.add(new SubDialogController(juego));
		actionsControllers.add(new MovimientoDeEscaleraAEscalera(juego,
				subdialogControllers));

		subdialogControllers = new ArrayList(2);
		subdialogControllers.add(new SubDialogController(juego));
		subdialogControllers.add(new SubDialogController(juego));
		actionsControllers.add(new MovimientoDeFundacionAEscalera(juego,
				subdialogControllers));
	}

	public ActionController getActionController(int opcion) {
		assert (opcion > 0);
		if (opcion == 8) {
			System.exit(0);
		}
		return (ActionController) actionsControllers.get(opcion - 1);
	}
}
