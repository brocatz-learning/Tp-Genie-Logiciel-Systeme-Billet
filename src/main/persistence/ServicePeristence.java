package persistence;

import model.Billet;
import model.Projet;
import model.Usager;

public class ServicePeristence {

    private static RegistreUsager registreUsager = RegistreUsager.getInstance();
    private static RegistreProjet registreProjet = RegistreProjet.getInstance();

    private static RegistreBillet registreBillet = RegistreBillet.getInstance();


    public boolean createUsager(Usager usager) {
        return registreUsager.addUsager(usager);
    }

    public boolean createProjet(Projet projet) {
        return registreProjet.addProjet(projet);
    }

    public boolean isEmailDuplicated(String email) {
        return registreUsager.verficationDuplicationUsagerEmail(email);
    }

    public boolean isProjetNameDuplicated(String nomProjet) {
        return registreProjet.verficationDuplicationProjetNom(nomProjet);
    }

    public int getListUsagerSize() {
        return registreUsager.getSize();
    }

    public int getListProjetSize() {
        return registreProjet.getSize();
    }

    public boolean isEmailInEnRegistre (String email) {
        return registreUsager.isEmailInRegistre(email);
    }

    public boolean createBillet(Billet billet) {
        return registreBillet.addBillet(billet);
    }


}


