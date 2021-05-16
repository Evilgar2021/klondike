package modelos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Partida {
	List<Fundacion> listaFundaciones;
	List<Pila> listaPilas;
	Baraja baraja;
	Descarte descarte;

	public Partida() {
		baraja = new Baraja();
		listaFundaciones = new ArrayList();
		listaPilas = new ArrayList();
		descarte = new Descarte();

		iniciaBaraja();
		iniciaFundaciones();
		iniciaPila();
	}

	public void iniciaBaraja() {
		Collections.shuffle(baraja.listaCartas);
	}

	public void iniciaFundaciones() {
		for (int i = 0; i < Palos.values().length; i++) {
			listaFundaciones.add(new Fundacion(Palos.values()[i]));
		}
	}

	public void iniciaPila() {
		Carta[] reparto = null;
		Pila pila = null;
		for (int i = 0; i < 7; i++) {
			pila = new Pila();
			reparto = new Carta[i + 1];
			for (int j = 0; j < reparto.length; j++) {
				reparto[j] = baraja.getUltimaCarta();
				baraja.eliminarUltimaCarta();
				Carta carta = reparto[j];
				pila.getListaCartas().add(carta);
			}
			pila.getUltimaCarta().setCartaVista(true);
			listaPilas.add(pila);
		}
	}

	public Pila getPila(int posicion) {
		assert (posicion >= 0);
		assert (posicion < 7);
		return (Pila) listaPilas.get(posicion);
	}

	public Fundacion getFundacion(int posicion) {
		assert (posicion >= 0);
		assert (posicion < 4);
		return (Fundacion) listaFundaciones.get(posicion);
	}

	public Baraja getBaraja() {
		assert (!baraja.isEmpty());
		return baraja;
	}

	public boolean isDescarteEmpty() {
		assert (descarte.isEmpty());
		return descarte.isEmpty();
	}

	public boolean isBarajaEmpty() {
		assert (baraja.isEmpty());
		return baraja.isEmpty();
	}

	public boolean isPilasEmpty(int posicion) {
		assert (posicion >= 0);
		assert (posicion < 7);
		return listaPilas.get(posicion).isEmpty();
	}

	public boolean isFundacionEmpty(int posicion) {
		assert (posicion >= 0);
		assert (posicion < 4);
		return listaFundaciones.get(posicion).isEmpty();
	}

	public void setBaraja(Baraja baraja) {
		assert (baraja != null);
		this.baraja = baraja;
	}

	public void setDescarte(Descarte descarte) {
		assert (descarte != null);
		this.descarte = descarte;
	}

	public Descarte getDescarte() {
		return descarte;
	}

	public void descarteString() {
		getDescarte().print();
	}

	public void barajaString() {
		getBaraja().print();
	}

	public void fundacionString(int posicion) {
		getFundacion(posicion).print();
	}

	public void pilaString(int posicion) {
		getPila(posicion).print();
	}

	public List<Fundacion> getListaFundaciones() {
		return listaFundaciones;
	}

	public List<Pila> getListaPilas() {
		return listaPilas;
	}

	public boolean isMayorCartasAMoverQLongitudPilas(int posicion, int numCartas) {
		boolean isMayor = false;
		if (listaPilas.get(posicion).getListaCartas().size() < numCartas) {
			isMayor = true;
		}
		return isMayor;
	}
	
	public boolean isMayorCartasAMoverQLongitudBaraja(int numCartas) {
		boolean isMayor = false;
		if (getBaraja().getListaCartas().size() < numCartas) {
			isMayor = true;
		}
		return isMayor;
	}

	public Fundacion getFundacionPorPalo(Palos palo) {
		Fundacion fundacion = null;
		for (int i = 0; i < Palos.values().length; i++) {
			if (getFundacion(i).getPalo() == palo) {
				fundacion = getFundacion(i);
			}
		}
		return fundacion;
	}
}