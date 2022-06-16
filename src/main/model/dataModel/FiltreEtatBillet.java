package model.dataModel;

public enum FiltreEtatBillet {

    StateOuvert(1),
    StateTravailEnCours(2),
    StateBloque(3),
    StateEnAttente(4),
    StateFerme(5);

    private int value;

    FiltreEtatBillet(int value) {
        this.value = value;
    }

    public static FiltreEtatBillet fromId(int id) {
        for (FiltreEtatBillet filtre : FiltreEtatBillet.values()) {
            if (filtre.value == id) {
                return filtre;
            }
        }
        return null;
    }
}
