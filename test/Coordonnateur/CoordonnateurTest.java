package Coordonnateur;

import exception.CategoryAlreadyExistExeception;
import exception.ProjetNotValidExeception;
import exception.UserNotVaildExeption;
import model.*;
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
    void testCreateUsagerDuplicateEmail() {
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

    @Test
    void testProjetNotValid() {
        assertThrows(ProjetNotValidExeception.class, () -> {
            ProjetDTO projetDTO = new ProjetDTO();
            projetDTO.setNom("");
            projetDTO.setDescription("");
            coordonnateur.createProjet(projetDTO);
        });
    }

    @Test
    void testProjetDuplicate() {
        ProjetDTO projetDTO = new ProjetDTO();
        projetDTO.setNom("Projet1");
        projetDTO.setDescription("Description1");
        ProjetDTO projetDTO2 = new ProjetDTO();
        projetDTO2.setNom("Projet1");
        projetDTO2.setDescription("Description1");

        assertThrows(ProjetNotValidExeception.class, () -> {
            coordonnateur.createProjet(projetDTO);
            coordonnateur.createProjet(projetDTO2);
        });

    }

    @Test
    void testBilletNotCreatable () {
        Billet billet1 = new Billet("Probleme d'affichage", new Usager(), new Usager(), "Bug",Gravity.Moyenne, new Projet("Projet1", "Description1"));
        BilletDTO billetDTO1 = new BilletDTO();
        billetDTO1.setNote("Probleme d'affichage");
        billetDTO1.setPersonneEnCharger(new UsagerDTO());
        billetDTO1.setDemandeur(new UsagerDTO());
        billetDTO1.setCategory("Bug");
        billetDTO1.setGravity(Gravity.Moyenne);
        billetDTO1.setProjet(new ProjetDTO());

        Exception exception = assertThrows(Exception.class, () ->{
            coordonnateur.createBillet(billetDTO1);
        });

        System.out.println(exception.getMessage());

    }

    @Test
    void createCategorie() {
        String categorie = "Gestion";

        assertDoesNotThrow(() -> {
            coordonnateur.createCategorie(categorie);
        });
    }

    @Test
    void createCategorieExeception() {
        String categorie = "Bug";

        assertThrows(CategoryAlreadyExistExeception.class, () -> {
                coordonnateur.createCategorie(categorie);
        });
    }



    @Test
    void createBillet() {

        ProjetDTO projetDTO = new ProjetDTO();
        projetDTO.setNom("Projet5");
        projetDTO.setDescription("Description1");

        UsagerDTO usagerDTO = new UsagerDTO();
        usagerDTO.setId(1);
        usagerDTO.setEmail("maxi@gmail.com" );
        usagerDTO.setNom("Maxi");
        usagerDTO.setPrenom("James");
        usagerDTO.setUsername("jmaxi");
        usagerDTO.setPassword("12345678");


        BilletDTO billetDTO = new BilletDTO();
        billetDTO.setNote("Probleme d'affichage");
        billetDTO.setDemandeur(usagerDTO);
        billetDTO.setPersonneEnCharger(usagerDTO);
        billetDTO.setCategory("Bug");
        billetDTO.setGravity(Gravity.Moyenne);
        billetDTO.setProjet(projetDTO);



        assertDoesNotThrow(() -> {
            coordonnateur.createUsager(usagerDTO, 1);
            coordonnateur.createProjet(projetDTO);
            coordonnateur.createBillet(billetDTO);
        });

    }
}