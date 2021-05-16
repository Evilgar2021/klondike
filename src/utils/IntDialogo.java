package utils;

public class IntDialogo {
	private String titulo;

	public IntDialogo(String titulo) {
		assert (titulo != null);
		this.titulo = (titulo + ": ");
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public int read() {
		IO io = new IO();

		int numeroRecibido = io.readInt(titulo);
		return numeroRecibido;
	}
}