package modelo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import static org.junit.Assert.*;

public class HistorialTest {
    @Rule
    public TemporaryFolder carpeta = new TemporaryFolder();

    @Test
    public void creaElArchivoConLosDatosCompletos() throws IOException {
        Path ruta = carpeta.getRoot().toPath().resolve("registro_gremio.txt");
        new Historial(ruta).anotarRegistro(new Clerigo("Álvaro", 4, 30, "Selûne"));
        assertEquals(List.of("REGISTRO | Álvaro (Clérigo) | Nivel 4 | 30 PV | Dios venerado: Selûne"),
                Files.readAllLines(ruta));
    }
}
