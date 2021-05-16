package controllers;

import modelos.Juego;

public class SubDialogController {
	private Juego juego;

	protected SubDialogController(Juego juego) {
		this.juego = juego;
	}

	public Juego getJuego() {
		return juego;
	}

	public String getStringLastDiscard() {
		return getJuego().getPartida().getDescarte().getUltimaCarta()
				.toString();
	}
}