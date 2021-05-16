package controllers;

import modelos.Juego;

public class MovimientoDescarteABaraja extends ActionController {
	protected MovimientoDescarteABaraja(Juego juego) {
		super(juego);
	}

	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visitMovimientoDescarteABaraja(this);
	}
}