package modelos;

public enum Palos {
	CORAZONES(Color.ROJO), TREBOLES(Color.NEGRO), ROMBOS(Color.ROJO), PICAS(Color.NEGRO);

	Color color;

	private Palos(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}