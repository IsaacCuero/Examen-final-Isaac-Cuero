package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import modelo.Aventurero;
import modelo.Clerigo;
import modelo.Guerrero;
import modelo.Historial;
import modelo.Mago;
import modelo.Monje;
import vista.VentanaGremio;

public final class ControladorGremio {
    private final List<Aventurero> aventureros = new ArrayList<>();
    private final Historial historial;

    public ControladorGremio(Historial historial) {
        this.historial = historial;
    }

    public void conectar(VentanaGremio vista, Function<List<Aventurero>, String> reportes) {
        vista.alCambiarClase(e -> vista.pedirRasgo(etiquetaRasgo(vista.clase())));
        vista.alRegistrar(e -> {
            try {
                Aventurero nuevo = crear(vista);
                registrar(nuevo);
                vista.mostrarGremio(listado());
                vista.limpiarRegistro();
                vista.mostrarResultado("Se registró a " + nuevo.getNombre() + ".");
            } catch (IllegalArgumentException ex) {
                vista.mostrarResultado(ex.getMessage());
            } catch (IOException ex) {
                vista.mostrarResultado("No se guardó el registro. Revisa registro_gremio.txt.\n" + ex.getMessage());
            }
        });
        vista.alSimular(e -> {
            try {
                vista.mostrarResultado(simularCombate());
            } catch (IOException ex) {
                vista.mostrarResultado("No se guardó el combate. Revisa registro_gremio.txt.\n" + ex.getMessage());
            }
        });
        vista.alPedirReportes(e -> vista.mostrarResultado(reportes.apply(List.copyOf(aventureros))));
        vista.pedirRasgo(etiquetaRasgo(vista.clase()));
        vista.mostrarGremio(listado());
    }

    public void registrar(Aventurero nuevo) throws IOException {
        historial.anotarRegistro(nuevo);
        aventureros.add(nuevo);
    }

    public String listado() {
        if (aventureros.isEmpty()) {
            return "Aún no hay aventureros registrados.";
        }
        return aventureros.stream().map(Aventurero::toString)
                .collect(Collectors.joining("\n"));
    }

    public String simularCombate() throws IOException {
        String acciones = aventureros.isEmpty() ? "No hay aventureros para combatir."
                : aventureros.stream().map(Aventurero::actuarEnCombate)
                        .collect(Collectors.joining("\n"));
        historial.anotarCombate(acciones);
        return acciones;
    }

    private static String etiquetaRasgo(String clase) {
        return switch (clase) {
            case "Guerrero" -> "Armadura pesada (sí/no)";
            case "Mago" -> "Espacios de conjuro";
            case "Clérigo" -> "Dios venerado";
            case "Monje" -> "Puntos de Ki";
            default -> throw new IllegalArgumentException("Elige una clase.");
        };
    }

    private static Aventurero crear(VentanaGremio vista) {
        String nombre = vista.nombre();
        int nivel = entero(vista.nivel(), "Nivel");
        int vida = entero(vista.vida(), "Puntos de vida");
        String rasgo = vista.rasgo().strip();
        return switch (vista.clase()) {
            case "Guerrero" -> new Guerrero(nombre, nivel, vida, leerArmadura(rasgo));
            case "Mago" -> new Mago(nombre, nivel, vida, entero(rasgo, "Espacios de conjuro"));
            case "Clérigo" -> new Clerigo(nombre, nivel, vida, rasgo);
            case "Monje" -> new Monje(nombre, nivel, vida, entero(rasgo, "Puntos de Ki"));
            default -> throw new IllegalArgumentException("Elige una clase.");
        };
    }

    private static int entero(String texto, String campo) {
        try {
            return Integer.parseInt(texto.strip());
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Escribe un número entero en " + campo + ".");
        }
    }

    private static boolean leerArmadura(String texto) {
        if ("sí".equalsIgnoreCase(texto) || "si".equalsIgnoreCase(texto)) {
            return true;
        }
        if ("no".equalsIgnoreCase(texto)) {
            return false;
        }
        throw new IllegalArgumentException("En armadura pesada escribe sí o no.");
    }
}
