package modelo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public final class Historial {
    private final Path archivo;

    public Historial(Path archivo) {
        this.archivo = archivo;
    }

    public void anotarRegistro(Aventurero aventurero) throws IOException {
        anexar("REGISTRO | " + aventurero.ficha(" | "));
    }

    private void anexar(String texto) throws IOException {
        Files.writeString(archivo, texto + System.lineSeparator(), StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }
}
