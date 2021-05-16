package modelos;

public enum Opcion {
	
	MOVE_FROM_DECK_TO_WASTE(1, "Mover de baraja a descarte"), 
	MOVE_FROM_WASTE_TO_DECK(2, "Mover de descarte a baraja"), 
	MOVE_FROM_WASTE_TO_FOUNDATION(3, "Mover de descarte a palo"), 
	MOVE_FROM_WASTE_TO_BOARDSTAIR(4, "Mover de descarte a escalera"), 
	MOVE_FROM_BOARDSTAIR_TO_FOUNDATION(5, "Mover de escalera a palo"), 
	MOVE_FROM_BOARDSTAIR_TO_BOARDSTAIR(6, "Mover de escalera a escalera"), 
	MOVE_FROM_FOUNDATION_TO_BOARDSTAIR(7, "Mover de palo a escalera"), 
	EXIT(8, "Salir");

	int num;
	String texto;

	private Opcion(int num, String texto) {
		this.num = num;
		this.texto = texto;
	}

	public int getNum() {
		return num;
	}

	public String getTexto() {
		return texto;
	}
}