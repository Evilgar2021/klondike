package controllers;

import modelos.Juego;

public class MovimientoDeDescarteAFundacion extends ActionController {
	protected MovimientoDeDescarteAFundacion(Juego juego) {
		super(juego);
	}

	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visitMovimientoDeDescarteAFundacion(this);
	}
}
