package modelo;

import org.junit.Test;
import static org.junit.Assert.*;

public class AventureroTest {
    @Test
    public void normalizaElNombreYConservaLosDatos() {
        Guerrero heroe = new Guerrero("  Bruna  ", 3, 0, false);
        assertEquals("Bruna", heroe.getNombre());
        assertEquals(3, heroe.getNivel());
        assertEquals(0, heroe.getPuntosVida());
    }

    @Test
    public void rechazaNombreVacioNivelCeroYVidaNegativa() {
        assertThrows(IllegalArgumentException.class, () -> new Guerrero(" ", 1, 0, true));
        assertThrows(IllegalArgumentException.class, () -> new Guerrero("Ada", 0, 10, true));
        assertThrows(IllegalArgumentException.class, () -> new Guerrero("Ada", 1, -1, true));
    }

    @Test
    public void losSettersValidanAntesDeCambiarElEstado() {
        Guerrero heroe = new Guerrero("Ada", 1, 10, false);
        heroe.setNombre("Luz");
        heroe.setNivel(2);
        heroe.setPuntosVida(7);
        assertThrows(IllegalArgumentException.class, () -> heroe.setNivel(-2));
        assertEquals("Luz", heroe.getNombre());
        assertEquals(2, heroe.getNivel());
        assertEquals(7, heroe.getPuntosVida());
    }

    @Test
    public void laFichaPermiteElegirElSeparador() {
        Guerrero heroe = new Guerrero("Luz", 2, 7, true);
        assertEquals("Luz (Guerrero) · Nivel 2 · 7 PV · Armadura pesada: sí", heroe.toString());
        assertEquals(heroe.ficha(), heroe.toString());
        assertEquals("Luz (Guerrero) | Nivel 2 | 7 PV | Armadura pesada: sí", heroe.ficha(" | "));
    }
}
