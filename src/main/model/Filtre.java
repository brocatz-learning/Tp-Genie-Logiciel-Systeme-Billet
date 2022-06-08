package model;

public enum Filtre {
    DateOuverture(1),
    Demandeur(2),
    Etat(3),
    PersonneEnCharge(4),
    Projet(5),
    Category(6),
    Gravity(7),
    ;

    private int value;

    Filtre(int i) {
        this.value = i;
    }

    public static Filtre fromId (int id) {
        for (Filtre filtre : Filtre.values()) {
            if (filtre.value == id) {
                return filtre;
            }
        }
        return null;
    }

   public int getId() {
       return this.value;
   }
}
