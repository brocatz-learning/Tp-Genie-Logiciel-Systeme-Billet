package model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RegistreBilletTest {

    static RegistreBillet registreBillet;


    @BeforeAll
    static void beforeAll() {
        registreBillet = RegistreBillet.getInstance();

        List.of(new Billet[] {
                new Billet("Probleme d'affichage dans la page web", new Usager("i"))
        });

        registreBillet.getListBillet();
    }

    @Test
    void testGetInstance() {
        RegistreBillet registreBillet1 = RegistreBillet.getInstance();
        RegistreBillet registreBillet2 = RegistreBillet.getInstance();

        assertEquals(registreBillet1,registreBillet2);
    }


    @Test
    void testFiltre() {

    }
}