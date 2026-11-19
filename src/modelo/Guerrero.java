package modelo;

public final class Guerrero extends Aventurero {
    private final boolean armaduraPesada;

    public Guerrero(String nombre, int nivel, int puntosVida, boolean armaduraPesada) {
        super(nombre, nivel, puntosVida);
        this.armaduraPesada = armaduraPesada;
    }

    @Override
    public String clase() {
        return "Guerrero";
    }

    @Override
    protected String detalle() {
        return "Armadura pesada: " + (armaduraPesada ? "sí" : "no");
    }

    @Override
    public String actuarEnCombate() {
        return "El Guerrero " + getNombre()
                + " usa Oleada de Acción para realizar múltiples ataques físicos continuos.";
    }
}
