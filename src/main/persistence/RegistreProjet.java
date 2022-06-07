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

    public Projet findByNom(String nomProjet) {
        Projet projet = listProjet
                .stream()
                .filter(p -> p.getNom().equals(nomProjet)).findFirst().orElse(null);
        return projet;
    }

    public boolean verficationDuplicationProjetNom(String nomProjet) {
        return listProjet.stream().anyMatch(projet -> projet.getNom().equals(nomProjet));
    }

    public int getSize() {
        return listProjet.size();
    }
}
