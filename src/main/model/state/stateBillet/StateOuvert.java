package model.state.stateBillet;

import model.Billet;

public class StateOuvert extends StateBillet {

    public StateOuvert(Billet billet) {
        super(billet);
    }

    @Override
    public String getCurrentState() {
        return this.getClass().getSimpleName();
    }
}
