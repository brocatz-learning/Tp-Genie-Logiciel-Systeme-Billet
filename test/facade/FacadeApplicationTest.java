package facade;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FacadeApplicationTest {

    private static FacadeApplication facadeApplication;

    @BeforeAll
    private static void beforeAll() {
        facadeApplication = new FacadeApplication();
    }

    @BeforeEach
    private void beforeEach() {
        facadeApplication = new FacadeApplication();
    }

    @Test
    void createCategorie() {
        String categorie = "Gestion";
        assertTrue(facadeApplication.createCategorie(categorie), "La categorie existe deja");
    }

    @Test
    void createNotCategorie() {
        String categorie = "Bug";
        assertFalse(facadeApplication.createCategorie(categorie), "La categorie n'existe pas");
    }
}