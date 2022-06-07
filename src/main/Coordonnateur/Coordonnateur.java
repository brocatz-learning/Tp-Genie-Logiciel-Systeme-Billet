package Coordonnateur;

import exception.*;
;
import facade.FacadeApplication;
import model.*;

public class Coordonnateur {

    private FacadeApplication facadeApplication = new FacadeApplication();

    /**
     * Validation des champs de l'usagerDTO fournis par l'utilisateur du systeme
     * Si l'usager est valide, aucune exception n'est levée
     *
     * @param usagerDTO
     * @throws UserNotVaildExeption
     */
    public void createUsager (UsagerDTO usagerDTO, int choixResponse) throws UserNotVaildExeption {
        ValidationUsager.validationUsagerDTO(usagerDTO);

        boolean isEmailDuplicated = facadeApplication.isEmailDuplicated(usagerDTO.getEmail());
        if (isEmailDuplicated) {
            throw new UserNotVaildExeption("Email dupliqué");
        }

        boolean isUsagerCree = facadeApplication.createUsager(usagerDTO, choixResponse);
        if (isUsagerCree == false) {
            throw new UserNotVaildExeption("Erreur interne Usager non créé");
        }
    }

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
     * @param aucun
     * @throws UserNotVaildExeption
     */
    public void verifyBilletCreatable() throws BilletNotCreatableExeception {
        int nbUsager = facadeApplication.getListUsagerSize();
        int nbProjet = facadeApplication.getListProjetSize();

        if (nbUsager == 0 || nbProjet == 0) {
            throw new BilletNotCreatableExeception("Au moins un projet et un usager doit exister");
        }
    }

    public void createBillet (BilletDTO billetDTO) throws UserNotVaildExeption, BilletNotCreatableExeception {

        boolean isDemandeurExist = facadeApplication.isEmailInEnRegistre(billetDTO.getDemandeur().getEmail());
        boolean isPersonneEnChargerExist = facadeApplication.isEmailInEnRegistre(billetDTO.getPersonneEnCharger().getEmail());

        if (!isDemandeurExist) {
            throw new UserNotVaildExeption("L'email du demandeur n'existe pas");
        }

        if (!isPersonneEnChargerExist) {
            throw new UserNotVaildExeption("L'email de la  personne en charge n'existe pas");
        }


        boolean isBilletCreated = facadeApplication.createBillet(billetDTO);
        if (isBilletCreated == false) {
            throw new BilletNotCreatableExeception("Erreur interne Billet non créé");
        }
    }

    public void createCategorie(String category) throws CategoryAlreadyExistExeception {
        category = category.toLowerCase();
        boolean isCategory = facadeApplication.createCategorie(category);

        if (isCategory == false) {
            throw new CategoryAlreadyExistExeception("Categorie déjà existante");
        }
    }

    public void createAssignation( String nomProjet,String emailUsagerTechnique) throws ProjetNotAssignableToUserExeception {
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


}
