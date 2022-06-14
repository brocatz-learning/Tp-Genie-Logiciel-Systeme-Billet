package model.state.stateBillet;

import model.dataModel.Billet;
import model.dataModel.HistoriqueBillet;
import model.dataModel.Usager;

import java.util.Date;

public abstract class StateBillet {
    protected Billet billet;

//    protected String currentState;

    public StateBillet(Billet billet) {
        this.billet = billet;
    }

    // Definir les methods abstract

    public abstract String getCurrentState();

    public void fermerBillet(Usager usager,String commentaire) {
        billet.setEtatBillet(new StateFermer(billet));
        insertHistoriqueBillet(usager,commentaire,billet.getEtatBillet());

    }
    public void ouvrirBillet(Usager usager,String commentaire) {
        billet.setEtatBillet(new StateOuvert(billet));
        insertHistoriqueBillet(usager,commentaire,billet.getEtatBillet());
    }

    public void bloquerBillet(Usager usager,String commentaire) {
        billet.setEtatBillet(new StateBloque(billet));
        insertHistoriqueBillet(usager, commentaire, billet.getEtatBillet());
    }


    public  void mettreEnAttenteDeployement(Usager usager,String commentaire) {
        insertHistoriqueBillet(usager,commentaire,billet.getEtatBillet());
    }
    public void mettreEnTravailEnCours(Usager usager,String commentaire) {
        insertHistoriqueBillet(usager,commentaire,billet.getEtatBillet());
    }


    private void insertHistoriqueBillet(Usager usager, String commentaire,StateBillet stateBillet) {
        HistoriqueBillet historiqueBillet = new HistoriqueBillet(billet.getEtatBillet(), usager, commentaire, new Date());
        billet.getHistoriqueBillets().add(historiqueBillet);
    }




}
