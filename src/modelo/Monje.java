package modelo;

public final class Monje extends Aventurero {
    private final int puntosKi;

    public Monje(String nombre, int nivel, int puntosVida, int puntosKi) {
        super(nombre, nivel, puntosVida);
        this.puntosKi = noNegativo(puntosKi, "Los puntos de Ki");
    }

    @Override
    public String clase() {
        return "Monje";
    }

    @Override
    protected String detalle() {
        return "Puntos de Ki: " + puntosKi;
    }

    @Override
    public String actuarEnCombate() {
        return "El Monje " + getNombre()
                + " gasta puntos de Ki para ejecutar una Ráfaga de Golpes y un Ataque Aturdidor.";
    }
}
