package aplicacion;

import controlador.ControladorGremio;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import javax.swing.SwingUtilities;
import modelo.Aventurero;
import vista.VentanaGremio;

public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaGremio vista = new VentanaGremio();
            ControladorGremio controlador = new ControladorGremio();
            controlador.conectar(vista, Main::reportePorClase);
            vista.setVisible(true);
        });
    }

    public static String reportePorClase(List<Aventurero> grupo) {
        Map<String, Integer> cantidades = new TreeMap<>();
        for (Aventurero aventurero : grupo) {
            cantidades.merge(aventurero.clase(), 1, Integer::sum);
        }
        String detalle = cantidades.entrySet().stream()
                .map(e -> e.getKey() + ": " + e.getValue())
                .collect(Collectors.joining("\n"));
        return "Aventureros por clase\n" + (detalle.isEmpty() ? "Gremio vacío." : detalle);
    }
}
