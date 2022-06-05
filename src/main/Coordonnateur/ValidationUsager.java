package Coordonnateur;

import exception.UserNotVaildExeption;
import model.Usager;
import model.UsagerDTO;

/**
 * Validation pour la couche coordonnateur
 * avant la d'appeler la couche facade
 *
 *
 * @author James Maxi
 */
public class ValidationUsager {

    public static String REGEX_EMAIL = "^[A-Za-z0-9+_.-]+@(.+)$";


    /**
     * Validation des champs de l'usagerDTO fournis par l'utilisateur du systeme
     *
     * @param usagerDTO
     * @throws UserNotVaildExeption
     */
    public static void validationUsagerDTO(UsagerDTO usagerDTO) throws UserNotVaildExeption {

        int firstNameLength = usagerDTO.getPrenom().length();
        int lastNameLength = usagerDTO.getNom().length();
        int passwordLength = usagerDTO.getPassword().length();
        int usernameLength = usagerDTO.getUsername().length();


        if (firstNameLength < 1) {
            throw new UserNotVaildExeption("Nom Invalide");
        }

        if(lastNameLength < 1) {
            throw new UserNotVaildExeption("Prenom Invalide");
        }

        if (passwordLength < 1) {
            throw new UserNotVaildExeption("Password Invalide");
        }

        if (usernameLength < 1) {
            throw new UserNotVaildExeption("Username Invalide");
        }

        if (usagerDTO.getEmail().matches(ValidationUsager.REGEX_EMAIL) == false) {
            throw new UserNotVaildExeption("Email Invalide");
        }
    }




}
