package modelo;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class CombateTest {
    @Test
    public void unaColeccionMixtaUsaLaAccionPropiaDeCadaClase() {
        List<Aventurero> grupo = List.of(
                new Guerrero("Bruna", 4, 32, true), new Mago("Iria", 3, 18, 2),
                new Clerigo("Sol", 2, 21, "Selûne"), new Monje("Tao", 3, 17, 4));
        List<String> acciones = grupo.stream().map(IAccionCombate::actuarEnCombate).toList();
        assertEquals(List.of(
                "El Guerrero Bruna usa Oleada de Acción para realizar múltiples ataques físicos continuos.",
                "El Mago Iria gasta un espacio de conjuro para lanzar una poderosa Bola de Fuego.",
                "El Clérigo Sol usa Canalizar Divinidad para curar a sus aliados y expulsar muertos vivientes.",
                "El Monje Tao gasta puntos de Ki para ejecutar una Ráfaga de Golpes y un Ataque Aturdidor."), acciones);
    }
}
