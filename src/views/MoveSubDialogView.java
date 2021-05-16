package views;

import utils.LimitIntDialogo;

public class MoveSubDialogView {
	public int getRespuesta(String texto, int max) {
		return new LimitIntDialogo(texto, max).read();
	}
}