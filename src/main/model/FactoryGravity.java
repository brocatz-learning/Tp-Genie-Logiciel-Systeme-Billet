package model;

import model.Gravity.*;

public class FactoryGravity {

    public static Gravity getGravityFactory(int choixResponse) {
        Gravity gravity = null;
        if (choixResponse == 1) {
            gravity = Gravity.Faible;
        } else if (choixResponse == 2) {
            gravity = Gravity.Moyenne;
        } else if (choixResponse == 3) {
            gravity = Gravity.Elevee;

        }



        return gravity;
    }

}
