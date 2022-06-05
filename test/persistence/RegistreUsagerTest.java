package persistence;

import exception.UserNotVaildExeption;
import model.Usager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class RegistreUsagerTest {

    static RegistreUsager registreUsager;

    @BeforeAll
    static void beforeAll() {
       registreUsager  = RegistreUsager.getInstance();
    }

    @BeforeEach
    void beforeEach() {
        registreUsager.clear();
    }

    @Test
    void testverficationDuplicationUsagerEmail() throws UserNotVaildExeption {

        Usager usager = new Usager();

        usager.setId(1);
        usager.setEmail("super@gmail.com");
        usager.setNom("Maxi");
        usager.setPrenom("James");
        usager.setUsername("jmaxi");
        usager.setPassword("12345678");
        usager.setDateCreation(new Date());

        Usager usager2 = new Usager(1,"Maxi","James","jmaxi","12345678","suPER@GMAIL.com",new Date());


        registreUsager.addUsager(usager);
        assertTrue(registreUsager.verficationDuplicationUsagerEmail(usager2.getEmail()));
    }


    @Test
    void testaddUsager() {
        Usager usager = new Usager();

        usager.setId(1);
        usager.setEmail("super@gmail.com");
        usager.setNom("Maxi");
        usager.setPrenom("James");
        usager.setUsername("jmaxi");
        usager.setPassword("12345678");
        usager.setDateCreation(new Date());

        Usager usager2 = new Usager(1,"Maxi","James","jmaxi","12345678","suPER@GMAIL.com",new Date());


        registreUsager.addUsager(usager);
        assertFalse(registreUsager.addUsager(usager2), usager.toString() + " " + usager2.toString());
        assertTrue(registreUsager.getSize() == 1, "size = " + registreUsager.getSize());


    }

    @Test
    void testAddUsagerFail() {
        Usager usager = new Usager();

        usager.setId(1);
        usager.setEmail("supergm.sdsdail.com");
        usager.setNom("Maxi");
        usager.setPrenom("James");
        usager.setUsername("jmaxi");
        usager.setPassword("12345678");
        usager.setDateCreation(new Date());


        assertEquals(registreUsager.addUsager(usager), false);
    }

}