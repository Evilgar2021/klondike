package modelos;

import java.util.ArrayList;
import java.util.List;

public class PilaCartas  {

	List<Carta> listaCartas = new ArrayList();

	public List<Carta> getListaCartas() {
		assert (listaCartas != null);
		return listaCartas;
	}

	public void setListaCartas(List<Carta> listaCartas) {
		this.listaCartas = listaCartas;
	}

	public boolean isEmpty() {
		assert (listaCartas.isEmpty());
		return listaCartas.isEmpty();
	}

	public List<Carta> getSublist(int numeroCartasMover) {
		assert (numeroCartasMover < listaCartas.size());
		List<Carta> sublist = new ArrayList();
		sublist = listaCartas.subList(listaCartas.size() - numeroCartasMover,
				listaCartas.size());
		return sublist;
	}

	public void adicionarSublistaAListaCartas(List<Carta> sublist) {
		listaCartas.addAll(sublist);
	}

	public Carta getUltimaCarta() {
		assert (!listaCartas.isEmpty());
		return (Carta) listaCartas.get(listaCartas.size() - 1);
	}

	public void eliminarUltimaCarta() {
		assert (!listaCartas.isEmpty());
		listaCartas.remove(getUltimaCarta());
	}

	public void print() {
		String string = this.toString();
		if (isEmpty()) {
			string = toString() + " < vacio > ";
			System.out.print(string);
		} else {
			System.out.print(toString() + " ");
			for (int i = 0; i < listaCartas.size(); i++) {
				string = ((Carta) listaCartas.get(i)).toString();
				System.out.print(string + " ");
			}
		}
		System.out.print("\n");
	}
}
