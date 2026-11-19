package modelo;

public final class Clerigo extends Aventurero {
    private final String diosVenerado;

    public Clerigo(String nombre, int nivel, int puntosVida, String diosVenerado) {
        super(nombre, nivel, puntosVida);
        this.diosVenerado = textoObligatorio(diosVenerado, "dios venerado");
    }

    @Override
    public String clase() {
        return "Clérigo";
    }

    @Override
    protected String detalle() {
        return "Dios venerado: " + diosVenerado;
    }

    @Override
    public String actuarEnCombate() {
        return "El Clérigo " + getNombre()
                + " usa Canalizar Divinidad para curar a sus aliados y expulsar muertos vivientes.";
    }
}
