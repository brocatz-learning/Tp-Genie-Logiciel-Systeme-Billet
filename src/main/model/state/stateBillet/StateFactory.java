package model.state.stateBillet;

import model.dataModel.Billet;
import model.dataModel.FiltreEtatBillet;

public class StateFactory {

    public static StateBillet buildState(Billet billet, FiltreEtatBillet filtre) {
        StateBillet state = null;
        switch (filtre) {
            case StateOuvert:
                state = new StateOuvert(billet);
                break;
            case StateTravailEnCours:
                state = new StateTravailEnCours(billet);
                break;
            case StateBloque:
                state = new StateBloque(billet);
            break;
            case StateEnAttente:
                state = new StateEnAttenteDeploy(billet);
            break;
            case StateFerme:
                state = new StateFermer(billet);
                break;
        }

        return state;


    }
}
