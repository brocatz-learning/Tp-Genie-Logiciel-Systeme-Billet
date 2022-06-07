package persistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistreCategorieTest {

    private static RegistreCategorie registreCategorie;

    @BeforeAll
    static void setUpBeforeClass() {
        registreCategorie = RegistreCategorie.getInstance();

    }

    @Test
    void testIsCategorieInRegistre() {
        String categorie = "Bug";


        assertTrue(registreCategorie.isCategorieInRegistre(categorie));
    }

    @Test
    void testAddCategorie() {
        String neoCategorie = "Gestion";
        assertTrue(registreCategorie.addCategorie(neoCategorie));
    }

    @Test
    void testNotAddCategorie() {
        String categorie = "Bug";
        assertFalse(registreCategorie.addCategorie(categorie));
    }
}