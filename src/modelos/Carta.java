package modelos;

public class Carta {
	Palos palo;
	ValorCartaPalo numeroCarta;
	boolean cartaVista;
	Color color;
        boolean permitido;

	public Carta(Palos palo, ValorCartaPalo numeroCarta) {
		this.palo = palo;
		this.numeroCarta = numeroCarta;
		color = palo.getColor();
		cartaVista = false;
                boolean permitido = false;
	}

	public Carta() {
	}

	public Palos getPalo() {
		return palo;
	}

	public ValorCartaPalo getNumeroCarta() {
		return numeroCarta;
	}

	public boolean isCartaVista() {
		return cartaVista;
	}

	public Color getColor() {
		return color;
	}

	public void setCartaVista(boolean cartaVista) {
		this.cartaVista = cartaVista;
	}

	public int movimientoPermitido(Carta otraCarta) {
		assert (isCartaVista());
		assert (otraCarta.isCartaVista());

		int permitido = 0;
		if ((numeroCarta.convertiraNumeros()
				- otraCarta.getNumeroCarta().convertiraNumeros() == 0)
				|| (numeroCarta.convertiraNumeros()
						- otraCarta.getNumeroCarta().convertiraNumeros() < -1)
				|| (numeroCarta.convertiraNumeros()
						- otraCarta.getNumeroCarta().convertiraNumeros() > 1)) {
			permitido = 0;
		} else if (numeroCarta.convertiraNumeros()
				- otraCarta.getNumeroCarta().convertiraNumeros() == -1) {
			permitido = -1;
		} else {
			permitido = 1;
		}
		return permitido;
	}

	public boolean isMovimientoPermitido() {
		return permitido;
	}

	public void setMovimientoPermitido(boolean permitido) {
            this.permitido = permitido;
	}

	public String toString() {
		String string;
		if (!isCartaVista()) {
			string = "XX ";
		} else {
			string = numeroCarta.convertiraNumeros() + " " + palo + " " + color
					+ "  ";
		}
		return string;
	}
}
