package modelo;

import org.junit.Test;
import static org.junit.Assert.*;

public class RasgosTest {
    @Test
    public void ambosValoresDeArmaduraSeDistinguen() {
        assertTrue(new Guerrero("Ada", 1, 8, false).ficha().endsWith("Armadura pesada: no"));
        assertTrue(new Guerrero("Ada", 1, 8, true).ficha().endsWith("Armadura pesada: sí"));
    }

    @Test
    public void elMagoAdmiteCeroEspaciosPeroRechazaNegativos() {
        assertTrue(new Mago("Iria", 2, 9, 0).ficha().endsWith("Espacios de conjuro: 0"));
        assertThrows(IllegalArgumentException.class, () -> new Mago("Iria", 2, 9, -1));
    }

    @Test
    public void elClerigoNecesitaUnDiosYConservaSuNombre() {
        assertTrue(new Clerigo("Sol", 2, 9, "  Selûne ").ficha().endsWith("Dios venerado: Selûne"));
        assertThrows(IllegalArgumentException.class, () -> new Clerigo("Sol", 2, 9, " "));
    }

    @Test
    public void elMonjeValidaSusPuntosKi() {
        assertTrue(new Monje("Tao", 3, 17, 2).ficha().endsWith("Puntos de Ki: 2"));
        assertThrows(IllegalArgumentException.class, () -> new Monje("Tao", 3, 17, -1));
    }
}
