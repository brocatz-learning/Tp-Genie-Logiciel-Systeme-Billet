package persistence;

import model.dataModel.*;

import model.state.stateBillet.StateBillet;
import model.state.stateBillet.StateFactory;

import java.util.Date;
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



    public List<Billet> consulterListeBillet(Filtre filtre, String valeur) {
        return registreBillet.filtreBillet(filtre, valeur);
    }

    public boolean isBilletExist(int idBillet) {
        return registreBillet.isBilletExist(idBillet);
    }

    public boolean createAssignationBillet(int idBillet, String emailUsagerTechique) {
        Usager usager = registreUsager.findByEmail(emailUsagerTechique);
        Billet billet = registreBillet.findById(idBillet);

        if (usager == null || billet == null) {
            return false;
        }
        billet.setDateAssignationBillet(new Date());
        billet.setPersonneEnCharger(usager);

        return true;
    }

    public boolean updateEtatBillet(int idBillet, FiltreEtatBillet choixEtat, String emailUsagerTechique, String note) {
        Billet billet = registreBillet.findById(idBillet);
        Usager usager = registreUsager.findByEmail(emailUsagerTechique);
        if (billet == null && usager == null) {
            return false;
        }

        StateBillet state = StateFactory.buildState(billet, choixEtat);

        if (billet.getEtatBillet().getCurrentState() == state.getCurrentState()) {
            return false;
        }



        switch (choixEtat) {
            case StateOuvert:
                billet.getEtatBillet().ouvrirBillet(usager, note);
                break;
            case StateTravailEnCours:
                billet.getEtatBillet().mettreEnTravailEnCours(usager, note);
                break;
            case StateBloque:
                billet.getEtatBillet().bloquerBillet(usager, note);
                break;
            case StateEnAttente:
                billet.getEtatBillet().mettreEnAttenteDeployement(usager, note);
                break;
            case StateFerme:
                billet.getEtatBillet().fermerBillet(usager, note);
        }

        return true;
    }

    public Billet consulterDetailBilletParId(int idBillet) {
        return registreBillet.findById(idBillet);
    }

    public int getLastBilletId() {
        return registreBillet.getSize();
    }
}


