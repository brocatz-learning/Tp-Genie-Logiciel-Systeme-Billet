package model.state.stateBillet;

import model.dataModel.Billet;

public class StateTravailEnCours extends StateBillet{
    public StateTravailEnCours(Billet billet) {
        super(billet);
    }

    @Override
    public String getCurrentState() {
        return this.getClass().getSimpleName();
    }
}
