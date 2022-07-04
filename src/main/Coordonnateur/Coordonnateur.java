package Coordonnateur;

import exception.*;
import facade.FacadeApplication;
import model.dataModel.Filtre;
import model.dataModel.FiltreEtatBillet;
import model.dto.BilletDTO;
import model.dto.ProjetDTO;
import model.dto.UsagerDTO;

import java.util.List;

/**
 *
 * @author Maxi
 *
 * */
public class Coordonnateur {

    private FacadeApplication facadeApplication = new FacadeApplication();

    /**
     * Validation des champs de l'usagerDTO fournis par l'utilisateur du systeme
     * Si l'usager est valide, aucune exception n'est levée
     *
     * @param usagerDTO
     * @throws UserNotVaildExeption
     */

     // 1- TODO Completed Coordonnateur Creation Compte Usager
    // Completed
    public void createUsager (UsagerDTO usagerDTO, int choixResponse) throws UserNotVaildExeption {
        ValidationUsager.validationUsagerDTO(usagerDTO);

        //boolean isEmailDuplicated = facadeApplication.isEmailDuplicated(usagerDTO.getEmail());
        boolean isEmailDuplicated = facadeApplication.isEmailInEnRegistre(usagerDTO.getEmail());

        if (isEmailDuplicated) {
            throw new UserNotVaildExeption("Email dupliqué");
        }

        boolean isUsagerCree = facadeApplication.createUsager(usagerDTO, choixResponse);
        if (isUsagerCree == false) {
            throw new UserNotVaildExeption("Erreur interne Usager non créé");
        }
    }

    // 2 TODO Coordoonateur Creation Projet
    // Completed
    public void createProjet(ProjetDTO projetDTO) throws ProjetNotValidExeception {
        ValidationProjet.validationProjetDTO(projetDTO);

        boolean isProjetDuplicated = facadeApplication.isProjetDuplicated(projetDTO.getNom());
        if (isProjetDuplicated) {
            throw new ProjetNotValidExeception("Projet duplicated");
        }


        boolean isProjetCree = facadeApplication.createProjet(projetDTO);
        if (isProjetCree == false) {
            throw new ProjetNotValidExeception("Erreur interne Projet non créé");
        }
    }

    /**
     * Verification avant de creer le billet
     * Verification de l'existence d'un projet et d'un usager
     *
     * @param
     * @throws UserNotVaildExeption
     */
    public void verifyBilletCreatable() throws BilletNotCreatableExeception {
        int nbUsager = facadeApplication.getListUsagerSize();
        int nbProjet = facadeApplication.getListProjetSize();

        if (nbUsager == 0 || nbProjet == 0) {
            throw new BilletNotCreatableExeception("Au moins un projet et un usager doit exister");
        }
    }

    // 5 TODO Completed : Coordonnateur Creation Billet
    public void createBillet (BilletDTO billetDTO) throws UserNotVaildExeption, BilletNotCreatableExeception, ProjetNotValidExeception {

        //Verification avant de creer le billet
        ValidationBillet.validationBilletDTO(billetDTO);

        boolean isDemandeurExist = facadeApplication.isEmailInEnRegistre(billetDTO.getDemandeur().getEmail());
//        boolean isPersonneEnChargerExist = facadeApplication.isEmailInEnRegistre(billetDTO.getPersonneEnCharger().getEmail());
        boolean isProjetExist = facadeApplication.isProjetExist(billetDTO.getProjet().getNom());

        boolean isCategoryExist = facadeApplication.isCategoryExist(billetDTO.getCategory());

        if (!isDemandeurExist) {
            throw new UserNotVaildExeption("L'email du demandeur n'existe pas");
        }

//        if (!isPersonneEnChargerExist) {
//            throw new UserNotVaildExeption("L'email de la  personne en charge n'existe pas");
//        }

        if (!isProjetExist) {
            throw new ProjetNotValidExeception("Le projet n'existe pas");
        }

        if (!isCategoryExist) {
            throw new ProjetNotValidExeception("La category du billet n'existe pas");
        }




        boolean isBilletCreated = facadeApplication.createBillet(billetDTO);
        if (isBilletCreated == false) {
            throw new BilletNotCreatableExeception("Erreur interne Billet non créé");
        }
    }

    // 4 TODO Completed : Coordonnateur Creation Categorie
    public void createCategorie(String category) throws CategoryAlreadyExistExeception {
        category = category.toLowerCase();
        boolean isCategory = facadeApplication.createCategorie(category);

        if (isCategory == false) {
            throw new CategoryAlreadyExistExeception("Categorie déjà existante");
        }
    }

     // 3 TODO Completed Coordonnateur Assignation Usager Technique Projet
    public void createAssignationProjet(String nomProjet, String emailUsagerTechnique) throws ProjetNotAssignableToUserExeception {
        boolean isEmailValid = facadeApplication.isEmailInEnRegistre(emailUsagerTechnique);
        boolean isProjetValid = facadeApplication.isProjetDuplicated(nomProjet);
        if (isEmailValid == false) {
            throw new ProjetNotAssignableToUserExeception("Projet non assignable à l'usager : email non valide");
        }

        if (isProjetValid == false) {
            throw new ProjetNotAssignableToUserExeception("Projet non assignable à l'usager : nom projet non valide");
        }

        boolean isAssignationCreated = facadeApplication.createAssignation(nomProjet, emailUsagerTechnique);
        if (isAssignationCreated == false) {
            throw new ProjetNotAssignableToUserExeception("Erreur interne Assignation non créé");
        }
    }


    /**
     * Verification avant de creer le billet
     * Verification de l'existence d'un projet et d'un usager
     *
     * @param valeur  : correspond a la valeur saisie par l'utilisateur
     *                ex : email, date, nom projet, etc
     * @param choix
     * @throws UserNotVaildExeption
     */
    // 8 TODO Completed : Coordonnateur Consulter Liste Billets
    public List<BilletDTO> consulterListeBillet(String valeur, int choix) throws FiltreNotValidException {

        Filtre filtre = Filtre.fromId(choix);

        if (filtre == null) {
            throw new FiltreNotValidException("Filtre non valide");
        }

        List<BilletDTO> listFiltreDTO =  facadeApplication.consulterListeBillet(filtre, valeur);


        return listFiltreDTO;
    }

    // 6 TODO Completed : Coordonnateur Assignation Billet
    public void createAssignationBillet(int idBillet, String emailUsagerTechique) throws BilletNotExistException,
            UserNotVaildExeption, AssignationBIlletException {

        boolean isBilletExist = facadeApplication.isBilletExist(idBillet);
        if (isBilletExist == false) {
            throw new BilletNotExistException("Billet non existant");
        }

        boolean isEmailValid = facadeApplication.isEmailInEnRegistre(emailUsagerTechique);
        if (isEmailValid == false) {
            throw new UserNotVaildExeption("Email non valide");
        }

        boolean isAssignationCreated = facadeApplication.createAssignationBillet(idBillet, emailUsagerTechique);
        if (isAssignationCreated == false) {
            throw new AssignationBIlletException("Erreur interne Assignation non créé");
        }
    }

    // 7 TODO Completed : Coordonnateur Changeer etat Billet
    public void updateEtatBillet(int idBillet, int choixEtat, String emailUsager, String note) throws BilletNotExistException, StateNotValidException, UserNotVaildExeption {

        FiltreEtatBillet filtreEtatBillet = FiltreEtatBillet.fromId(choixEtat);
        if (filtreEtatBillet == null) {
            throw new StateNotValidException("Choix etat usager non valide");
        }

        boolean isUserExist = facadeApplication.isEmailInEnRegistre(emailUsager);
        if (isUserExist == false) {
            throw new UserNotVaildExeption("Email non valide");
        }



        boolean isBilletExist = facadeApplication.isBilletExist(idBillet);
        if (isBilletExist == false) {
            throw new BilletNotExistException("Billet non existant");
        }

        boolean isStateChanged = facadeApplication.updateEtatBillet(idBillet, filtreEtatBillet, emailUsager, note);
        if (isStateChanged == false) {
            throw new StateNotValidException("Etat non modifié");
        }
    }

     // 9 TODO Completed : Menu Consulter Billet par Id
    public BilletDTO consulterDetailBilletParId(int idBillet) throws BilletNotExistException {

        boolean isBilletExist = facadeApplication.isBilletExist(idBillet);

        if (isBilletExist == false) {
            throw new BilletNotExistException("Billet non existant");
        }

        BilletDTO billetDTO = facadeApplication.consulterDetailBilletParId(idBillet);
        if (billetDTO == null) {
            throw new BilletNotExistException("Erreur interne Billet non trouvé");
        }

        return billetDTO;
    }

    public int getLastBilletId() {
        return facadeApplication.getLastBilletId();
    }
}
