package controllers;

import java.util.ArrayList;

import modelos.Juego;

public class MovimientoDeEscaleraAFundacion extends ActionsSubDialogController {
	protected MovimientoDeEscaleraAFundacion(Juego juego, ArrayList<SubDialogController> subdialogControllers) {
		super(juego, subdialogControllers);
	}

	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visitMovimientoDeEscaleraAFundacion(this);
	}

	public String validaMovimientoFundacion(int pilaOrigen) {
		String err = "";
		if (getJuego().getPartida().getPila(pilaOrigen).isEmpty()) {
			err = Error.STAIR_EMPTY;
		} else {
			if (!getJuego().getPartida().getFundacionPorPalo(
						getJuego().getPartida().getPila(pilaOrigen)
								.getUltimaCarta().getPalo())
				.movimientoPermitido(
						getJuego().getPartida().getPila(pilaOrigen)
								.getUltimaCarta())){
				System.out.print("estoy aqui " + getJuego().getPartida().getFundacionPorPalo(
						getJuego().getPartida().getPila(pilaOrigen)
								.getUltimaCarta().getPalo()).toString());
				err = Error.PUT_ERROR;
			}else{
			getJuego().moverDePilaAFundacion(pilaOrigen);
			System.out.println("he pasado por aqui");
			err = null;
			}
		}
		System.out.println(err);
		return err;
	}
}
