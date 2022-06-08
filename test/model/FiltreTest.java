package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FiltreTest {
    @Test
    void testFiltre() {
        Filtre filtre = Filtre.DateOuverture;
        Filtre filtre2 = Filtre.fromId(1);
        assertEquals(1, filtre.getId());
    }
}