package Coordonnateur;

import exception.UserNotVaildExeption;
import model.UsagerDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CoordonnateurTest {

    private static Coordonnateur coordonnateur;

    @BeforeAll
    static void beforeAll() {
        coordonnateur = new Coordonnateur();
    }

    @Test
    void testcreateUsagerInvalidEmail() {
        UsagerDTO usagerDTO = new UsagerDTO();
        usagerDTO.setId(1);
        usagerDTO.setEmail("her.sdss");
        usagerDTO.setNom("Maxi");
        usagerDTO.setPrenom("James");
        usagerDTO.setUsername("jmaxi");
        usagerDTO.setPassword("12345678");
        usagerDTO.setDateCreation(new Date());

        assertThrows(UserNotVaildExeption.class, () -> {
            coordonnateur.createUsager(usagerDTO, 1);
        });
    }

//    @Test
//    void testcreateUsagerEmailValid() {
//        UsagerDTO usagerDTO = new UsagerDTO();
//        usagerDTO.setId(1);
//        usagerDTO.setEmail("adfs@gmail.com");
//        usagerDTO.setNom("Maxi");
//        usagerDTO.setPrenom("James");
//        usagerDTO.setUsername("jmaxi");
//        usagerDTO.setPassword("12345678");
//        usagerDTO.setDateCreation(new Date());
//
//
//    }

    @Test
    void testcreateUsagerDuplicateEmail() {
        UsagerDTO usagerDTO = new UsagerDTO();
        usagerDTO.setId(1);
        usagerDTO.setEmail("super@gmail.com");
        usagerDTO.setNom("Maxi");
        usagerDTO.setPrenom("James");
        usagerDTO.setUsername("jmaxi");
        usagerDTO.setPassword("12345678");

        UsagerDTO usagerDTO2 = new UsagerDTO();
        usagerDTO2.setId(2);
        usagerDTO2.setEmail("super@Gmail.com");
        usagerDTO2.setNom("Jaque");
        usagerDTO2.setPrenom("Donovan");
        usagerDTO2.setUsername("jDonovan");
        usagerDTO2.setPassword("12345678");

        UserNotVaildExeption userNotVaildExeption = assertThrows(UserNotVaildExeption.class, () -> {
            coordonnateur.createUsager(usagerDTO, 1);
            coordonnateur.createUsager(usagerDTO2, 1);
        });

        System.out.println(userNotVaildExeption.getMessage());

    }

}