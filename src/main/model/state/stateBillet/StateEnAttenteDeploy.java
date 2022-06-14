package model.state.stateBillet;

import model.dataModel.Billet;

public class StateEnAttenteDeploy extends StateBillet {


    public StateEnAttenteDeploy(Billet billet) {
        super(billet);
         this.getClass().getSimpleName();
    }

    @Override
    public String getCurrentState() {
        return this.getClass().getSimpleName();
    }


}
