package modelo;

public final class Mago extends Aventurero {
    private final int espaciosConjuro;

    public Mago(String nombre, int nivel, int puntosVida, int espaciosConjuro) {
        super(nombre, nivel, puntosVida);
        this.espaciosConjuro = noNegativo(espaciosConjuro, "Los espacios de conjuro");
    }

    @Override
    public String clase() {
        return "Mago";
    }

    @Override
    protected String detalle() {
        return "Espacios de conjuro: " + espaciosConjuro;
    }

    @Override
    public String actuarEnCombate() {
        return "El Mago " + getNombre()
                + " gasta un espacio de conjuro para lanzar una poderosa Bola de Fuego.";
    }
}
