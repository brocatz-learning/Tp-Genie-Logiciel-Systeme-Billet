package model;

public class FactoryUsagerTechnique {

    public static Usager getUsagerFactory(int choixResponse) {
        Usager usager = null;
        if (choixResponse == 1) {
            usager = new Client();
        } else  {
            usager = new Programmeur();
        }

        return usager;
    }
}
