package aplicacion;

import controlador.ControladorGremio;
import javax.swing.SwingUtilities;
import vista.VentanaGremio;

public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaGremio vista = new VentanaGremio();
            ControladorGremio controlador = new ControladorGremio();
            controlador.conectar(vista);
            vista.setVisible(true);
        });
    }
}
