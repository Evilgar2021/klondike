package modelos;

public class Descarte extends PilaCartasGenerico {
	static final int CARTAS_DESCARTE = 3;

	public int getNumeroCartasDescarte() {
		return 3;
	}

	public void girarUltimaCartas() {
		getUltimaCarta().setCartaVista(false);
	}

	public void print() {
		super.print();
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName().toString() + ": " ;
	}
}
