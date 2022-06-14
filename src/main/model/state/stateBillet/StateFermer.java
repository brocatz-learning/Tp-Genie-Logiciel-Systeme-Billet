package model.state.stateBillet;

import model.dataModel.Billet;

public class StateFermer extends StateBillet{
    public StateFermer(Billet billet) {
        super(billet);

    }

    @Override
    public String getCurrentState() {
        return this.getClass().getSimpleName();
    }
}
