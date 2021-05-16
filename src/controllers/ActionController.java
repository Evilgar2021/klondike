package controllers;

import modelos.Juego;

public abstract class ActionController {
	private Juego juego;

	protected ActionController(Juego juego) {
		assert (juego != null);
		this.juego = juego;
	}

	public Juego getJuego() {
		return juego;
	}

	public boolean isVaciaEscalera(int numEscalera) {
		return juego.getPartida().isPilasEmpty(numEscalera);
	}

	public abstract void accept(ControllerVisitor paramControllerVisitor);
}
