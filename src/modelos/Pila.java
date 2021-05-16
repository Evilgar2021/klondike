package modelos;



public class Pila extends PilaCartasGenerico {
	public static final int NUMERO_PILAS = 7;

	public void print() {
		super.print();
	}

	public boolean movimientoPermitido(Carta carta) {
		assert (carta.isCartaVista());

		boolean permitido = false;;
		if (this.isEmpty()) {
			if (carta.getNumeroCarta().convertiraNumeros() == ValorCartaPalo.REY.convertiraNumeros()) {
				permitido = true;;
			}
		} else if ((getUltimaCarta().getColor() != carta.getColor())
				&& (getUltimaCarta().movimientoPermitido(carta) == 1)) {
			carta.setMovimientoPermitido(true);
                        permitido = carta.isMovimientoPermitido();
		}
		return permitido;
	}


	@Override
	public String toString() {
		return this.getClass().getSimpleName().toString() + ": ";
	}
}