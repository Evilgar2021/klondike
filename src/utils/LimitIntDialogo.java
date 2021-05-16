package utils;

import views.IntervaloCerradoView;

public class LimitIntDialogo {
	IntDialogo intDialogo;
	IntervaloCerrado intervaloCerrado;
	IntervaloCerradoView intervaloCerradoView;

	public LimitIntDialogo(String titulo, int min, int max) {
		assert (titulo != null);
		intDialogo = new IntDialogo(titulo);
		intervaloCerrado = new IntervaloCerrado(min, max);
		intervaloCerradoView = new IntervaloCerradoView(
				"ERROR!!! La opcion debe ser entre ", intervaloCerrado);
		intDialogo.setTitulo(titulo + " [" + intervaloCerrado + "]: ");
	}

	public LimitIntDialogo(String titulo, int max) {
		this(titulo, 1, max);
	}

	public int read() {
		IO io = new IO();
		int numRecibido;
		boolean ok;
		do {
			numRecibido = io.readInt(intDialogo.getTitulo());
			ok = intervaloCerrado.isComprendidoEnIntervalo(numRecibido);
			if (!ok) {
				intervaloCerradoView.writln();
			}
		} while (!ok);
		return numRecibido;
	}
}
