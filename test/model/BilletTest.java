package model;

import model.state.stateBillet.StateEnAttenteDeploy;
import model.state.stateBillet.StateFermer;
import model.state.stateBillet.StateTravailEnCours;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BilletTest {
    @Test
    void testBilletAffichageEtatTravailEnCour() {
        Billet billet1 = new Billet("Probleme d'affichage", new Usager(), new Usager(),Category.Feature,Gravity.Moyenne);

        billet1.setEtatBillet(new StateTravailEnCours(billet1));


        String etat = billet1.getEtatBillet().getCurrentState();
        assertEquals(StateTravailEnCours.class.getSimpleName(), etat);
    }

    @Test
    void testChangerEtatEnCour() {

    }

}