package controllers;

import modelos.Juego;

public class MovimientoDeBarajaADescarte extends ActionController {
	protected MovimientoDeBarajaADescarte(Juego juego) {
		super(juego);
	}

	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visitMovimientoDeBarajaADescarte(this);
	}
}
