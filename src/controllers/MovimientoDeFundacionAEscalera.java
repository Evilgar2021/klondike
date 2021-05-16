package controllers;

import modelos.Juego;
import modelos.Pila;

public class MovimientoDeFundacionAEscalera extends ActionsSubDialogController {
	protected MovimientoDeFundacionAEscalera(Juego juego,
			java.util.ArrayList<SubDialogController> subdialogControllers) {
		super(juego, subdialogControllers);
	}

	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visitMovimientoDeFundacionAEscalera(this);
	}

	public boolean isFoundationEmpty(int origenFundacion) {
		return getJuego().getPartida().isFundacionEmpty(origenFundacion);
	}

	public String validaMovimiento(int numFundacion, int pilaDestino) {
		String err = "";
		if (getJuego().getPartida().isFundacionEmpty(numFundacion)) {
			err = Error.FOUNDATION_EMPTY;
		} else {
			if (!getJuego().getPartida().getPila(pilaDestino).movimientoPermitido(getJuego().getPartida().getFundacion(numFundacion).getUltimaCarta()))
				{
					err = Error.PUT_ERROR;
				}
				getJuego().moverDeFundacionAPila(numFundacion, pilaDestino);
				err = null;
			}
		System.out.println(err);
		return err;
	}
}
