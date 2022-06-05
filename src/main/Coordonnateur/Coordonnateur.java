package Coordonnateur;

import exception.UserNotVaildExeption;
import facade.FacadeApplication;
import model.FactoryUsagerTechnique;
import model.Usager;
import model.UsagerDTO;

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



}
