package modelos;

enum ValorCartaPalo {
	AS("1"), DOS("2"), TRES("3"), CUATRO("4"), CINCO("5"), SEIS("6"), SIETE("7"), OCHO(
			"8"), NUEVE("9"), DIEZ("10"), SOTA("11"), CABALLO("12"), REY("13");

	String numeroCartaPalo;

	private ValorCartaPalo(String numeroCartaPalo) {
		this.numeroCartaPalo = numeroCartaPalo;
	}

	public String getNumeroCartaPalo() {
		return numeroCartaPalo;
	}

	public void setNumeroCartaPalo(String numeroCartaPalo) {
		this.numeroCartaPalo = numeroCartaPalo;
	}

	public int convertiraNumeros() {
		int valorNumerico = 0;

		for (int i = 0; i < values().length; i++) {
			valorNumerico = Integer.parseInt(numeroCartaPalo);
		}
		return valorNumerico;
	}
}
