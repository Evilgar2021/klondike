package controllers;

import modelos.Juego;

public class MovimientoDeDescarteAEscalera extends ActionController {

	SubDialogController subDialogController;

	protected MovimientoDeDescarteAEscalera(Juego juego,
			SubDialogController subDialogController) {
		super(juego);
		assert (subDialogController != null);
		this.subDialogController = subDialogController;
	}

	public SubDialogController getSubDialogController() {
		return subDialogController;
	}

	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visitMovimientoDeDescarteAEscalera(this);
	}

	public String validaMovimiento(int pilaDestino) {
		String err;
		if (getJuego().getPartida().isDescarteEmpty()) {
			 err = Error.NO_DISCARDS;
		} else {
			if (!getJuego()
					.getPartida()
					.getPila(pilaDestino)
					.movimientoPermitido(
							getJuego().getPartida().getDescarte()
									.getUltimaCarta())) {
				err = Error.PUT_ERROR;
			} else {
				getJuego().moverDeDescarteAPila(pilaDestino);
				err = null;
			}
		}
		return err;
	}
}
