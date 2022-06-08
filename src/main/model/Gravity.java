package model;

public enum Gravity {
    Faible(1),
    Moyenne(2),
    Elevee(3)
    ;
    private int value;
    Gravity(int i) {
        this.value = i;
    }

    public static Gravity fromId (int id) {
        for (Gravity gravity : Gravity.values()) {
            if (gravity.value == id) {
                return gravity;
            }
        }
        return null;
    }

    public int getId() {
        return this.value;
    }
}
