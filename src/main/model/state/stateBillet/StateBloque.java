package model.state.stateBillet;

import model.dataModel.Billet;

public class StateBloque extends StateBillet {

    public StateBloque(Billet billet) {
        super(billet);
    }

    @Override
    public String getCurrentState() {
        return this.getClass().getSimpleName();
    }


}

