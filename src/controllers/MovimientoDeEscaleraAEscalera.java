package controllers;

import java.util.ArrayList;

import modelos.Juego;

public class MovimientoDeEscaleraAEscalera extends ActionsSubDialogController {
	protected MovimientoDeEscaleraAEscalera(Juego juego,ArrayList<SubDialogController> subdialogControllers) {
		super(juego, subdialogControllers);
	}

	public boolean isPilaVacia(int posicion) {
		return getJuego().getPartida().isPilasEmpty(posicion);
	}

    @Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visitMovimientoDeEscaleraAEscalera(this);
	}

	public String validaMovimiento(int origen, int numCartas, int destino) {
		String err = "";
		if (getJuego().getPartida().isPilasEmpty(origen)){
			err = Error.STAIR_EMPTY;
		}else {
			if (!getJuego().getPartida().getPila(destino).movimientoPermitido(
							getJuego().getPartida().getPila(origen)
									.getSublist(numCartas).get(0))) {
				err = Error.PUT_ERROR;
			}
		getJuego().moverDePilaAPila(origen, numCartas, destino);
		err = null;
		}
		System.out.println(err);
		return err;
	}
}
