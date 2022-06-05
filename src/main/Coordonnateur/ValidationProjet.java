package Coordonnateur;

import exception.ProjetNotValidExeception;
import model.ProjetDTO;

public class ValidationProjet {

    public static void validationProjetDTO(ProjetDTO projetDTO) throws ProjetNotValidExeception {
        if (projetDTO.getNom() == null || projetDTO.getNom().isEmpty()) {
            throw new ProjetNotValidExeception("Le nom du projet est obligatoire");
        }
        if (projetDTO.getDescription() == null || projetDTO.getDescription().isEmpty()) {
            throw new ProjetNotValidExeception("La description du projet est obligatoire");
        }

        int nomProjetLength = projetDTO.getNom().length();
        int descriptionProjetLength = projetDTO.getDescription().length();

        if (nomProjetLength < 1) {
            throw new ProjetNotValidExeception("Le nom du projet doit contenir au moins 1 caractères");
        }

        if (descriptionProjetLength < 1) {
            throw new ProjetNotValidExeception("La description du projet doit contenir au moins 1 caractères");
        }

    }

}
