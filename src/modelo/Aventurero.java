package modelo;

public abstract class Aventurero implements IAccionCombate {
    public static final int NIVEL_MINIMO = 1;
    private String nombre;
    private int nivel;
    private int puntosVida;

    protected Aventurero(String nombre, int nivel, int puntosVida) {
        setNombre(nombre);
        setNivel(nivel);
        setPuntosVida(puntosVida);
    }

    public final String getNombre() {
        return nombre;
    }

    public final int getNivel() {
        return nivel;
    }

    public final int getPuntosVida() {
        return puntosVida;
    }

    public final void setNombre(String nombre) {
        this.nombre = textoObligatorio(nombre, "nombre");
    }

    public final void setNivel(int nivel) {
        if (nivel < NIVEL_MINIMO) {
            throw new IllegalArgumentException("El nivel debe ser mayor o igual que 1.");
        }
        this.nivel = nivel;
    }

    public final void setPuntosVida(int puntosVida) {
        this.puntosVida = noNegativo(puntosVida, "Los puntos de vida");
    }

    protected static int noNegativo(int cantidad, String campo) {
        if (cantidad < 0) {
            throw new IllegalArgumentException(campo + " deben ser mayores o iguales que 0.");
        }
        return cantidad;
    }

    protected static String textoObligatorio(String texto, String campo) {
        if (texto == null || texto.isBlank()) {
            throw new IllegalArgumentException("Completa el campo " + campo + ".");
        }
        return texto.strip();
    }

    public abstract String clase();

    protected abstract String detalle();

    public final String ficha() {
        return ficha(" · ");
    }

    public final String ficha(String separador) {
        return String.join(separador, nombre + " (" + clase() + ")",
                "Nivel " + nivel, puntosVida + " PV", detalle());
    }

    @Override
    public final String toString() {
        return ficha();
    }
}
