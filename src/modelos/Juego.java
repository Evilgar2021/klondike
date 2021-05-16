package modelos;

import java.util.Collections;
import java.util.List;

public class Juego {

    private Menu menu;
    private Partida partida;

    public Juego() {
        menu = new Menu();
        partida = new Partida();
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public boolean isJuegoTerminado() {
        boolean completed = false;
        for (int i = 0; i < partida.getListaFundaciones().size(); i++) {
            if (partida.getFundacion(i).getListaCartas().size() == ValorCartaPalo
                    .values().length) {
                completed = true;
            } else {
                completed = false;
            }
        }
        return completed;
    }

    public boolean isMayorCartasAMoverqueLongitud(int posicion, int numCartas) {
        return getPartida().isMayorCartasAMoverQLongitudPilas(posicion,
                numCartas);
    }

    public void moverDeBarajaADescarte() {
        assert (!partida.getBaraja().isEmpty());
        if (partida.isMayorCartasAMoverQLongitudBaraja(Descarte.CARTAS_DESCARTE)) {
            for (int i = partida.getBaraja().listaCartas.size(); i > 0; i--) {
                partida.getBaraja().girarUltimaCartas();
                partida.getDescarte().getListaCartas()
                        .add(partida.getBaraja().getUltimaCarta());
                partida.getBaraja().eliminarUltimaCarta();
            }
        } else {
            for (int i = Descarte.CARTAS_DESCARTE; i >0; i--) {
                partida.getBaraja().girarUltimaCartas();
                partida.getDescarte().getListaCartas()
                        .add(partida.getBaraja().getUltimaCarta());
                partida.getBaraja().eliminarUltimaCarta();
            }
        }
    }

    public void moverDeDescarteaBaraja() {
        assert (partida.getBaraja().isEmpty());
        for (int i = 0; i < partida.getDescarte().getListaCartas().size(); i++) {
            partida.getDescarte().getListaCartas().get(i).setCartaVista(false);
        }
        List<Carta> sublist = partida.getDescarte().getSublist(partida.getDescarte().getListaCartas().size());
        Collections.reverse(sublist);
        partida.getBaraja().adicionarSublistaAListaCartas(sublist);
        partida.getDescarte().eliminarSublistaAListaCartas(sublist);
    }

    public void moverDeDescarteAFundacion() {
        assert (!partida.getDescarte().isEmpty());
        if (partida.getFundacionPorPalo(
                partida.getDescarte().getUltimaCarta().getPalo())
                .movimientoPermitido(partida.getDescarte().getUltimaCarta())) {
            partida.getFundacionPorPalo(
                    partida.getDescarte().getUltimaCarta().getPalo())
                    .getListaCartas()
                    .add(partida.getDescarte().getUltimaCarta());
            partida.getDescarte().eliminarUltimaCarta();
        }
    }

    public void moverDeDescarteAPila(int posicion) {
        assert (!partida.getDescarte().isEmpty());
        if (partida.getPila(posicion).movimientoPermitido(partida.getDescarte().getUltimaCarta())) {
            partida.getPila(posicion).listaCartas.add(partida.getDescarte()
                    .getUltimaCarta());
            partida.getDescarte().eliminarUltimaCarta();
        }
    }

    public void moverDePilaAFundacion(int pilaOrigen) {
        assert (!partida.getPila(pilaOrigen).isEmpty());
        if (partida.getFundacionPorPalo(
                partida.getPila(pilaOrigen).getUltimaCarta().getPalo())
                .movimientoPermitido(partida.getPila(pilaOrigen).getUltimaCarta())) {
            partida.getFundacionPorPalo(partida.getPila(pilaOrigen)
                    .getUltimaCarta().getPalo()).listaCartas.add(partida
                    .getPila(pilaOrigen).getUltimaCarta());
            partida.getPila(pilaOrigen).eliminarUltimaCarta();
        }
        if (!partida.isPilasEmpty(pilaOrigen)) {
            partida.getPila(pilaOrigen).getUltimaCarta().setCartaVista(true);
        }
    }

    public void moverDeFundacionAPila(int origen, int destino) {
        assert (!partida.getFundacion(origen).isEmpty());
        if (partida.getPila(destino).movimientoPermitido(
                partida.getFundacion(origen).getUltimaCarta())) {
            partida.getPila(destino).listaCartas.add(partida.getFundacion(
                    origen).getUltimaCarta());
            partida.getFundacion(origen).eliminarUltimaCarta();
        }
    }

    public void moverDePilaAPila(int pilaOrigen, int numCartas, int destino) {
        assert (!partida.getPila(pilaOrigen).isEmpty());
        if (partida.getPila(destino).movimientoPermitido(
                partida.getPila(pilaOrigen).getSublist(numCartas).get(0))) {
            List<Carta> sublist = partida.getPila(pilaOrigen).getSublist(numCartas);
            partida.getPila(destino).adicionarSublistaAListaCartas(sublist);
            partida.getPila(pilaOrigen).eliminarSublistaAListaCartas(sublist);
        }
        if (!partida.isPilasEmpty(pilaOrigen)) {
            partida.getPila(pilaOrigen).getUltimaCarta().setCartaVista(true);
        }
    }
}
