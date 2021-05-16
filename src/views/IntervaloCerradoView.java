package views;

import utils.IntervaloCerrado;

public class IntervaloCerradoView {
	private String titulo;
	private IntervaloCerrado intervaloCerrado;
	private utils.IO io;

	public IntervaloCerradoView(String titulo, IntervaloCerrado intervaloCerrado) {
		assert (titulo != null);
		assert (intervaloCerrado != null);
		this.titulo = titulo;
		this.intervaloCerrado = intervaloCerrado;
		io = new utils.IO();
	}

	public void writln() {
		io.writeln(titulo + " " + toString());
	}

	public String toString() {
		return intervaloCerrado.getMin() + " y " + intervaloCerrado.getMax()
				+ " inclusives";
	}
}