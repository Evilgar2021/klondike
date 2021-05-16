package modelos;

import java.util.ArrayList;

public class Menu {
	private ArrayList<Opcion> opciones;

	public Menu() {
		opciones = new ArrayList();
		initMenuOptions();
	}

	private void initMenuOptions() {
       for (Opcion opcion : opciones) {
         opciones.add(opcion);
         }
       }

	public Opcion getOpcion(int num) {
		assert (num > 0);
		return (Opcion) opciones.get(num - 1);
	}
}