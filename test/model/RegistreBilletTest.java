package model;

import model.state.stateBillet.StateEnAttenteDeploy;
import model.state.stateBillet.StateFermer;
import model.state.stateBillet.StateOuvert;
import model.state.stateBillet.StateTravailEnCours;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import persistence.RegistreBillet;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.*;

class RegistreBilletTest {

    static RegistreBillet registreBillet;


    @BeforeAll
    static void beforeAll() {
        registreBillet = RegistreBillet.getInstance();

        Billet billet = new Billet("Probleme d'affichage", new Usager(), new Usager(),"Bug",Gravity.Faible, new Projet());
        Billet billet1 = new Billet("Probleme d'affichage", new Usager(), new Usager(),"Bug",Gravity.Moyenne, new Projet());
        Billet billet2 = new Billet("Probleme d'affichage", new Usager(), new Usager(),"Bug",Gravity.Elevee, new Projet());
        Billet billet3 = new Billet("Probleme d'affichage", new Usager(), new Usager(),"Bug",Gravity.Moyenne, new Projet());
        Billet billet4 = new Billet("Probleme d'affichage", new Usager(), new Usager(),"Bug",Gravity.Elevee, new Projet());
        Billet billet5 = new Billet("Probleme d'affichage", new Usager(), new Usager(),"Bug",Gravity.Faible, new Projet());
        Billet billet6 = new Billet("Probleme d'affichage", new Usager(), new Usager(),"Bug",Gravity.Faible, new Projet());


        billet1.setEtatBillet(new StateTravailEnCours(billet));
        billet2.setEtatBillet(new StateFermer(billet2));
        billet3.setEtatBillet(new StateEnAttenteDeploy(billet3));
        billet4.setEtatBillet(new StateTravailEnCours(billet4));
        billet5.setEtatBillet(new StateTravailEnCours(billet5));
        billet6.setEtatBillet(new StateFermer(billet6));

        registreBillet.getListBillet().addAll(
                of(billet,billet1,billet2,billet3,billet4,billet5,billet6)
        );



        Usager usager = new Usager();

//        UsagerDTO usagerDTO
//
//        List.of(new Billet[] {
//                new Billet("Probleme d'affichage dans la page web",)
//        });


    }

    @Test
    void testGetInstance() {
        RegistreBillet registreBillet1 = RegistreBillet.getInstance();
        RegistreBillet registreBillet2 = RegistreBillet.getInstance();

        assertEquals(registreBillet1,registreBillet2);
    }


    @Test
    void testFiltreEtat() {
        List<Billet> listResulat_StateOuvert = registreBillet.getListBillet()
                .stream()
                .filter(billet -> billet.getEtatBillet() instanceof StateOuvert).collect(Collectors.toList());

        List<Billet> listResulat_StateFermer = registreBillet.getListBillet()
                .stream()
                .filter(billet -> billet.getEtatBillet() instanceof StateFermer).collect(Collectors.toList());

        List<Billet> listResulat_StateTravailEnCours = registreBillet.getListBillet()
                .stream()
                .filter(billet -> billet.getEtatBillet() instanceof StateTravailEnCours).collect(Collectors.toList());

        List<Billet> listResulat_EnAttente = registreBillet.getListBillet()
                .stream()
                .filter(billet -> billet.getEtatBillet() instanceof StateEnAttenteDeploy).collect(Collectors.toList());

        assertTrue(listResulat_EnAttente.size() > 0, "");
        assertTrue(listResulat_StateOuvert.size() > 0, "");
        assertTrue(listResulat_StateFermer.size() > 0, "");
        assertTrue(listResulat_StateTravailEnCours.size() == 3, "");
        assertTrue(listResulat_EnAttente.size() > 0, "");
    }

    @Test
    void testFiltre () {}
}