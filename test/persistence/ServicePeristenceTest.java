package persistence;

import model.dataModel.*;
import model.state.stateBillet.StateOuvert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ServicePeristenceTest {

    private static ServicePeristence servicePeristence;


    @BeforeAll
    static void beforeAll() {
        servicePeristence = new ServicePeristence();

        Usager usager = new Usager();

//        usager.setId(1);
        usager.setEmail("servicePersistance@gmail.com");
        usager.setNom("Maxi");
        usager.setPrenom("James");
        usager.setUsername("jmaxi");
        usager.setPassword("12345678");
        usager.setDateCreation(new Date());

        Usager usager2 = new Usager(1,"Maxi","James","jmaxi","12345678","suPER@GMAIL.com",new Date());
        Projet projet = new Projet("Service Persistence ","Tp de session");

        Billet billet = new Billet();
        billet.setId(1);
        billet.setNote("Probleme de persistence");
        billet.setDateCreationBillet(new Date());
        billet.setHistoriqueBillets(new ArrayList<HistoriqueBillet>());
        billet.setEtatBillet(new StateOuvert(billet));
        billet.setDemandeur(usager);
        billet.setPersonneEnCharger(usager2);
        billet.setProjet(projet);




        servicePeristence.createUsager(usager);
        servicePeristence.createProjet(projet);
        servicePeristence.createBillet(billet);
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

    @Test
    void addBillet() {
        Billet billet = new Billet();
        billet.setNote("Probleme de la souris");
        billet.setPersonneEnCharger(new Usager(1,"Maxi","James","jmaxi","12345678","",new Date()));
        billet.setDemandeur(new Usager(1,"Maxi","James","jmaxi","12345678","",new Date()));
        billet.setCategory("Bug");
        billet.setGravity(Gravity.Faible);

    }

    @Test
    void createAssignation() {

    }

    @Test
    void updateEtatBilletTravailEnCours() {
       assertTrue(servicePeristence.updateEtatBillet(1, FiltreEtatBillet.StateTravailEnCours,"servicePersistance@gmail.com","Hello"));
       System.out.println(servicePeristence.consulterListeBillet(Filtre.Demandeur, "servicePersistance@gmail.com"));
    }
    @Test
    void updateEtatBilletTravailEnFermer() {
        assertTrue(servicePeristence.updateEtatBillet(1, FiltreEtatBillet.StateFerme,"servicePersistance@gmail.com","Hello"));
 //       System.out.println(servicePeristence.consulterListeBillet(Filtre.Demandeur, "servicePersistance@gmail.com"));
    }

    @Test
    void updateEtatBilletTravailBloquer() {
        assertTrue(servicePeristence.updateEtatBillet(1, FiltreEtatBillet.StateBloque,"servicePersistance@gmail.com","Hello"));
//       System.out.println(servicePeristence.consulterListeBillet(Filtre.Demandeur, "servicePersistance@gmail.com"));
    }

    @Test
    void updateEtatBilletTravailEnAttent() {
        assertTrue(servicePeristence.updateEtatBillet(1, FiltreEtatBillet.StateEnAttente,"servicePersistance@gmail.com","Hello"));
        System.out.println(servicePeristence.consulterListeBillet(Filtre.Demandeur, "servicePersistance@gmail.com"));
    }
}