package modelos;

public class Fundacion extends PilaCartasGenerico {

    private Palos palo;

    public Fundacion(Palos palo) {
        this.palo = palo;
    }

    public Palos getPalo() {
        return palo;
    }

    public boolean movimientoPermitido(Carta carta) {
        boolean permitido = false;
        assert this.getPalo() == carta.getPalo();
        if (this.isEmpty()) {
            if (carta.getNumeroCarta().convertiraNumeros() == ValorCartaPalo.AS.convertiraNumeros()) {
                permitido = true;
            }
        } else {
            if (getUltimaCarta().movimientoPermitido(carta) == -1) {
                this.getUltimaCarta().setMovimientoPermitido(true);
                permitido = this.getUltimaCarta().isMovimientoPermitido();
            }
        }
        return permitido;
    }

    public void print() {
        super.print();
    }

    @Override
    public String toString() {
        return this.getPalo().toString() + ": ";
    }
}
