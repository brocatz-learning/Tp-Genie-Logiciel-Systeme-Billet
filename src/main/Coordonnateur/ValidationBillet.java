package Coordonnateur;

import exception.BilletNotCreatableExeception;
import model.dto.BilletDTO;

public class ValidationBillet {

    public static void validationBilletDTO(BilletDTO billetDTO) throws BilletNotCreatableExeception {
        if (billetDTO.getNote() == null || billetDTO.getNote().isEmpty()) {
            throw new BilletNotCreatableExeception("Le nom du billet est obligatoire");
        }

        int noteLength = billetDTO.getNote().length();

        if (noteLength < 1) {
            throw new BilletNotCreatableExeception("La note du billet doit contenir au moins 1 caractères");
        }

    }
}
