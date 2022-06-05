package Coordonnateur;

import exception.BilletNotCreatableExeception;
import exception.ProjetNotValidExeception;
import exception.UserNotVaildExeption;
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

    public void createBillet (BilletDTO billetDTO) {

    }


}
