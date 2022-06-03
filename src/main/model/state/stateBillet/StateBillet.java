package model.state.stateBillet;

import model.Billet;

public abstract class StateBillet {
    Billet billet;

    public StateBillet(Billet billet) {
        this.billet = billet;
    }

    // Definir les methods abstract
}
