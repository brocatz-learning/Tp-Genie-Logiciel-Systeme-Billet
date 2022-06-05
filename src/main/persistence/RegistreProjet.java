package persistence;

import model.Projet;

import java.util.ArrayList;
import java.util.List;

public class RegistreProjet {

    private List<Projet> listProjet;

    private static RegistreProjet registreProjet;

    private RegistreProjet () {
        listProjet = new ArrayList<>();
    }

    public static RegistreProjet getInstance() {
        if (registreProjet == null) {
            registreProjet = new RegistreProjet();
        }
        return registreProjet;
    }

    public boolean addProjet(Projet projet) {
        return listProjet.add(projet);
    }
}
