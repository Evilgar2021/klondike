package controllers;

import modelos.Juego;
import modelos.Opcion;
import modelos.Palos;

public class MenuController {
	private Juego juego;

	public MenuController(Juego juego) {
		this.juego = juego;
	}

	public Juego getJuego() {
		return juego;
	}

	public int getNumCartasEnBaraja() {
		return getJuego().getPartida().getBaraja().getListaCartas().size();
	}

	public int getNumCartasEnDescarte() {
		return getJuego().getPartida().getDescarte().getListaCartas().size();
	}

	public void getStringBaraja() {
		getJuego().getPartida().barajaString();
	}

	public void getStringDescarte() {
		getJuego().getPartida().descarteString();
	}

	public void printStringFundaciones() {
		for (int i = 0; i < Palos.values().length; i++) {
			 getJuego().getPartida().fundacionString(i);
		}
	}

	public void printStringPilas() {
		for (int i = 0; i < getJuego().getPartida().getListaPilas().size(); i++) {
			System.out.print((i +1) +  ". ");
            getJuego().getPartida().pilaString(i);
		}
	}

	public String getStringOpcionesEnumerado() {
		String string = "";
		Opcion opcion = null;
		for (int i = 0; i < Opcion.values().length; i++) {
			string = string + i + ". " + opcion.getTexto() + "\n";
			i++;
		}
		return string;
	}

	public String getStringOptionsMenu() {
		String string = "";
		int i = 1;
		for (Opcion opcion : Opcion.values()) {
			string = string + i + ". " + opcion.getTexto() + "\n";
			i++;
		}
		return string;
	}

	public int accept(ControllerVisitor controllerVisitor) {
		return controllerVisitor.visitMenu(this);
	}
}
