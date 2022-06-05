package model.state.stateBillet;

import model.Billet;

public abstract class StateBillet {
    protected Billet billet;

//    protected String currentState;

    public StateBillet(Billet billet) {
        this.billet = billet;
    }

    // Definir les methods abstract

    public abstract String getCurrentState();

    public void fermerBillet() {
        billet.setEtatBillet(new StateFermer(billet));


    }
    public void ouvrirBillet() {
        billet.setEtatBillet(new StateOuvert(billet));
    }
    public  void mettreEnAttenteDeployement() {
        billet.setEtatBillet(new StateEnAttenteDeploy(billet));
    }
    public void mettreEnTravailEnCours() {
        billet.setEtatBillet(new StateTravailEnCours(billet));
    }





}
