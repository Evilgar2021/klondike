package modelos;

public class Baraja extends PilaCartasGenerico {
	public Baraja() {
		for (int i = 0; i < Palos.values().length; i++) {
			for (int j = 0; j < ValorCartaPalo.values().length; j++) {
				getListaCartas()
						.add(new Carta(Palos.values()[i], ValorCartaPalo
								.values()[j]));
			}
		}
	}

	public void girarUltimaCartas() {
		getUltimaCarta().setCartaVista(true);
	}

	public void print() {
		super.print();
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName().toString() + ": Quedan " + this.listaCartas.size() + " cartas" + " ";
	}
}
