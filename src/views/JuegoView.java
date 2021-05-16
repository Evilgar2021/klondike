package views;

import controllers.Error;
import controllers.MenuController;
import controllers.MovimientoDeBarajaADescarte;
import controllers.MovimientoDeDescarteAEscalera;
import controllers.MovimientoDeDescarteAFundacion;
import controllers.MovimientoDeEscaleraAEscalera;
import controllers.MovimientoDeEscaleraAFundacion;
import controllers.MovimientoDeFundacionAEscalera;
import controllers.MovimientoDescarteABaraja;
import utils.IO;

public class JuegoView implements controllers.ControllerVisitor {
	private IO io = new IO();
	private final String TO_STAIR_TXT = "A que escalera?";
	private final String FROM_STAIR_TXT = "De que escalera?";
	private final String CARD_QUANTITY_TXT = "Cuantas cartas?";
	private final String FROM_FOUNDATION_TXT = "De que palo?";

	public int interactWithMenu(MenuController menuController) {
		return menuController.accept(this);
	}

	public void interact(controllers.ActionController controller) {
		controller.accept(this);
	}

	public int visitMenu(MenuController menuController) {
		MenuView menuView = new MenuView(menuController);
		return menuView.exploreMenu();
	}

	public void visitMovimientoDeBarajaADescarte(MovimientoDeBarajaADescarte controller) {
		if (controller.getJuego().getPartida().isBarajaEmpty()) {
			io.writeln(Error.getError("ERROR!!! La baraja esta vacia"));
		} else {
			controller.getJuego().moverDeBarajaADescarte();
		}
	}

	public void visitMovimientoDescarteABaraja(MovimientoDescarteABaraja controller) {
		if (!controller.getJuego().getPartida().isBarajaEmpty()) {
			io.writeln(Error.getError("ERROR!!! La baraja aun tiene cartas"));
		} else {
			controller.getJuego().moverDeDescarteaBaraja();
		}
	}

	public void visitMovimientoDeDescarteAFundacion(MovimientoDeDescarteAFundacion controller) {
		if (controller.getJuego().getPartida().isDescarteEmpty()) {
			io.writeln(Error.getError("ERROR!!! No hay descarte"));
		} else {
			controller.getJuego().moverDeDescarteAFundacion();
		}
	}

	public void visitMovimientoDeDescarteAEscalera(MovimientoDeDescarteAEscalera controller) {
		String err;
		if (controller.getJuego().getPartida().isDescarteEmpty()) {
			err = Error.getError("ERROR!!! No hay descarte");
		} else {
			int pilaDestino = new MoveSubDialogView().getRespuesta(
					"A que escalera?", 7)-1;
			err = controller.validaMovimiento(pilaDestino);
		}
		if (err != null) {
			io.writeln(err);
		}
	}

    @Override
	public void visitMovimientoDeEscaleraAEscalera(MovimientoDeEscaleraAEscalera controller) {
		int pilaOrigen = new MoveSubDialogView().getRespuesta(
				"De que escalera?", 7)-1;
		String err;
		if (controller.getJuego().getPartida().isPilasEmpty(pilaOrigen)) {
			err = Error.getError("ERROR!!! Esa escalera esta vacia");
		} else {
			int numCartas = new MoveSubDialogView().getRespuesta(
					"Cuantas cartas?", 13);
			if (controller.getJuego().isMayorCartasAMoverqueLongitud(pilaOrigen, numCartas)) {
				err = Error.getError("ERROR!!! Se han elegido mas cartas de las disponibles en la escalera");
			} else {
				int pilaDestino = new MoveSubDialogView().getRespuesta(
						"A que escalera?", 7)-1;
				err = controller.validaMovimiento(pilaOrigen, numCartas,
						pilaDestino);
			}
			if (err != null) {
				io.writeln(err);
			}
		}
	}

	public void visitMovimientoDeEscaleraAFundacion(
			MovimientoDeEscaleraAFundacion controller) {
		int pilaOrigen = new MoveSubDialogView().getRespuesta(
				"De que escalera?", 7)-1;
		String err;
		if (controller.getJuego().getPartida().isPilasEmpty(pilaOrigen)) {
			err = Error.getError("ERROR!!! Esa escalera esta vacia");
		} else {
			err = controller.validaMovimientoFundacion(pilaOrigen);
		}
		if (err != null) {
			io.writeln(err);
		}
	}

	public void visitMovimientoDeFundacionAEscalera(
			MovimientoDeFundacionAEscalera controller) {
		int origenFundacion = new MoveSubDialogView().getRespuesta(
				"De que palo?", 4)-1;
		String err;
		if (!controller.getJuego().getPartida()
				.isFundacionEmpty(origenFundacion)) {
			int pilaDestino = new MoveSubDialogView().getRespuesta(
					"A que escalera?", 7)-1;
			err = controller.validaMovimiento(origenFundacion, pilaDestino);
		} else {
			err = Error.getError("ERROR!!! Ese palo esta vacio");
		}
		if (err != null) {
			io.writeln(err);
		}
	}
}
