package persistence;

import model.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RegistreBilletTest {

    private static RegistreBillet registreBillet;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        registreBillet = RegistreBillet.getInstance();

        Usager usager1 = new Usager();
        usager1.setEmail("super@gmail.com");
        usager1.setNom("Dupont");
        usager1.setPrenom("Jean");
        usager1.setPassword("azerty");

        Usager usager2 = new Usager();
        usager2.setEmail("grave@gmail.com");
        usager2.setNom("Alain");
        usager2.setPrenom("Robert");
        usager2.setPassword("azerty");

        Projet projet1 = new Projet("Projet1", "Description1");

        Billet billet1 = new Billet("Billet1", usager1, usager2, "Nuclear", Gravity.Moyenne, projet1);
        billet1.getEtatBillet().fermerBillet(usager1,"Fermer");
        boolean isBilletAdded = registreBillet.addBillet(billet1);





    }


    @Test
    void testFiltreDemandeurBillet() {
        List<Billet> billetList = registreBillet.filtreBillet(Filtre.Demandeur, "grave@gmail.com");
        System.out.println(billetList.size());
        assertTrue(billetList.size() > 0);
    }

    @Test
    void testFiltrePersonneEnChangeBillet() {
        List<Billet> billetList = registreBillet.filtreBillet(Filtre.PersonneEnCharge, "super@gmail.com");
        assertTrue(billetList.size() > 0);
    }

    @Test
    void testFiltreEtatBillet() {
        List<Billet> billetList = registreBillet.filtreBillet(Filtre.Etat, "statefermer");
        assertTrue(billetList.size() > 0);
    }

    @Test
    void testFiltreProjetBillet() {
        List<Billet> billetList = registreBillet.filtreBillet(Filtre.Projet, "projet1");
        assertTrue(billetList.size() > 0);
    }

    @Test
    void testFiltreCategoryBillet() {
        List<Billet> billetList = registreBillet.filtreBillet(Filtre.Category, "nuclear");
        assertTrue(billetList.size() > 0);
    }

    @Test
    void testFiltreGravityBillet() {
        List<Billet> billetList = registreBillet.filtreBillet(Filtre.Gravity, "moyenne");
        assertTrue(billetList.size() > 0);
    }

    @Test
    void testAddBillet() {
        Billet billet = new Billet("Billet1", null, null, "Nuclear", Gravity.Moyenne, null);

        assertTrue(registreBillet.addBillet(billet));
    }


    ///



}