package model;

import model.dataModel.*;
import model.state.stateBillet.StateFermer;
import model.state.stateBillet.StateTravailEnCours;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BilletTest {
    @Test
    void testBilletAffichageEtatTravailEnCour() {
        Billet billet1 = new Billet("Probleme d'affichage", new Usager(), new Usager(),"Bug", Gravity.Moyenne, new Projet());

        billet1.setEtatBillet(new StateTravailEnCours(billet1));


        String etat = billet1.getEtatBillet().getCurrentState();
        assertEquals(StateTravailEnCours.class.getSimpleName(), etat);
    }

    @Test
    void testChangerEtatAFermer() {
        Billet billet1 = new Billet("Probleme d'affichage", new Usager(), new Usager(),"Support",Gravity.Moyenne, new Projet());
        billet1.getEtatBillet().fermerBillet(new Usager(),"Probleme reglee");

        assertEquals(StateFermer.class.getSimpleName(), billet1.getEtatBillet().getCurrentState());
    }

    @Test
    void testHistoriqueBIllet() {
        Billet billet1 = new Billet("Probleme d'affichage", new Usager(), new Usager(),"Feature",Gravity.Moyenne,new Projet("Projet1","Description1"));
        billet1.getEtatBillet().mettreEnTravailEnCours(new Usager(),"Travail en cours");
        billet1.getEtatBillet().mettreEnAttenteDeployement(new Usager(),"En attente de deployement");
        billet1.getEtatBillet().fermerBillet(new Usager(),"Probleme reglee");


        List<HistoriqueBillet> historiqueBilletList = billet1.getHistoriqueBillets();

        assertTrue(historiqueBilletList.size() == 3);

    }

}