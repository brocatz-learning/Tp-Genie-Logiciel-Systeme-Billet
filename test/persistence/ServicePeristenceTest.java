package persistence;

import model.Projet;
import model.Usager;
import model.UsagerDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ServicePeristenceTest {

    private static ServicePeristence servicePeristence;


    @BeforeAll
    static void beforeAll() {
        servicePeristence = new ServicePeristence();

        Usager usager = new Usager();

        usager.setId(1);
        usager.setEmail("super@gmail.com");
        usager.setNom("Maxi");
        usager.setPrenom("James");
        usager.setUsername("jmaxi");
        usager.setPassword("12345678");
        usager.setDateCreation(new Date());

        Usager usager2 = new Usager(1,"Maxi","James","jmaxi","12345678","suPER@GMAIL.com",new Date());
        Projet projet = new Projet("TP Genie Logiciel","Tp de session");

        servicePeristence.createUsager(usager);
        servicePeristence.createProjet(projet);
    }

    @BeforeEach
    void beforeEach() {
        servicePeristence = new ServicePeristence();
    }


    //
    @Test
    void testCreateUsager () {
        Usager usager = new Usager();

        usager.setId(1);
        usager.setEmail("superSuper@gmail.com");
        usager.setNom("Maxi");
        usager.setPrenom("James");
        usager.setUsername("jmaxi");
        usager.setPassword("12345678");
        usager.setDateCreation(new Date());

        assertTrue(servicePeristence.createUsager(usager), "L'usager n'a pas été créé");

    }

    @Test
    void testCreateCategorie() {
        String nomCategorie = "Gestion";
        assertTrue(servicePeristence.createCategorie(nomCategorie), "La categorie existe deja");
    }

    @Test
    void testNotCreateCategorie() {
        String nomCategorie = "Bug";
        assertFalse(servicePeristence.createCategorie(nomCategorie), "La categorie n'existe pas");;
    }

    ////////////////
    ///////////////
    @Test
    void testFailCreateAssignation() {
        String email = "james@gmail.com";
        String nomProjet = "Tp Genie Logiciel";
        assertFalse(
                servicePeristence.createAssignation(email, nomProjet)
                , "L'assignation existe deja");
    }
}