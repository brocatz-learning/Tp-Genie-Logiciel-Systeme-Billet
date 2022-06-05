package model.state.stateBillet;

import model.Billet;

public class StateTravailEnCours extends StateBillet{
    public StateTravailEnCours(Billet billet) {
        super(billet);
    }

    @Override
    public String getCurrentState() {
        return this.getClass().getSimpleName();
    }
}
