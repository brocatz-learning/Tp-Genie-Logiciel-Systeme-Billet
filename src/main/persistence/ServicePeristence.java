package persistence;

import model.Billet;
import model.Filtre;
import model.Projet;
import model.Usager;

import java.util.List;

public class ServicePeristence {

    private static RegistreUsager registreUsager = RegistreUsager.getInstance();
    private static RegistreProjet registreProjet = RegistreProjet.getInstance();

    private static RegistreBillet registreBillet = RegistreBillet.getInstance();
    private static RegistreCategorie registreCategorie = RegistreCategorie.getInstance();


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

//        Usager personneEnCharge = registreUsager.findByEmail(billet.getPersonneEnCharger().getEmail());
        Usager demandeur = registreUsager.findByEmail(billet.getDemandeur().getEmail());
        Projet projet = registreProjet.findByNom(billet.getProjet().getNom());

        if (demandeur == null || projet == null) {
            return false;
        }

        billet.setDemandeur(demandeur);
        billet.setProjet(projet);


        return registreBillet.addBillet(billet);
    }

    public boolean isCateogrieInRegistre(String categorie) {
        return registreCategorie.isCategorieInRegistre(categorie);
    }


    public boolean createCategorie(String category) {
        return registreCategorie.addCategorie(category);
    }

    public Usager findByEmail(String email) {
        return registreUsager.findByEmail(email);
    }


    public boolean createAssignation(String nomProjet, String emailUsager) {
        Usager usager = registreUsager.findByEmail(emailUsager);
        Projet projet = registreProjet.findByNom(nomProjet);

        if (usager == null || projet == null) {
            return false;
        }

        return projet.addUsager(usager);
    }



    public List<Billet> consulterListeBillet(Filtre filtre, int choix) {


        return null;
    }
}


