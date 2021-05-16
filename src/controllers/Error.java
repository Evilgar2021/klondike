package controllers;

public final class Error {
	public static final String DECK_EMPTY = "ERROR!!! La baraja esta vacia";

	public static final String DECK_WITH_CARDS = "ERROR!!! La baraja aun tiene cartas";
	public static final String NO_DISCARDS = "ERROR!!! No hay descartes";
	public static final String FOUNDATION_EMPTY = "ERROR!!! Ese palo esta vacio";
	public static final String ISNT_ACE = "ERROR!!! La primera carta de un palo debe ser un as";
	public static final String PUT_ERROR = "ERROR!!! No se puede poner %o sobre %d";
	public static final String ISNT_KING = "ERROR!!! La primera carta de una escalera debe ser un rey";
	public static final String STAIR_EMPTY = "ERROR!!! Esa escalera esta vacia";
	public static final String MORE_CARDS_THAN_STAIR = "ERROR!!! Se han elegido mas cartas de las disponibles en la escalera";
	public static final String CANT_FLIP = "ERROR!!! No se puede voltear una carta descubierta";

	public static final String getError(String errorKey) {
		return errorKey;
	}
}