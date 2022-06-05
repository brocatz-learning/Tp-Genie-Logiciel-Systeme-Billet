package facade;

import exception.UserNotVaildExeption;
import model.*;
import persistence.RegistreProjet;
import persistence.RegistreUsager;

public class FacadeApplication {

    static {
        registreUsager = RegistreUsager.getInstance();
    }
    private static RegistreUsager registreUsager = RegistreUsager.getInstance();
    private static RegistreProjet registreProjet = RegistreProjet.getInstance();
    public boolean createUsager (UsagerDTO usagerDTO, int choixResponse)  {
        Usager usager = FactoryUsagerTechnique.getUsagerFactory(choixResponse);
        usager.setUsername(usagerDTO.getUsername());
        usager.setPassword(usagerDTO.getPassword());
        usager.setEmail(usagerDTO.getEmail());
        usager.setNom(usagerDTO.getNom());
        usager.setPrenom(usagerDTO.getPrenom());
        boolean isUsagerCreer = registreUsager.addUsager(usager);

        return isUsagerCreer;
    }

    public boolean isEmailDuplicated(String email) {
        return registreUsager.verficationDuplicationUsagerEmail(email);
    }

    public boolean createProjet(ProjetDTO projetDTO) {
        Projet projet = new Projet(projetDTO.getNom(), projetDTO.getDescription());
        projet.setNom(projetDTO.getNom());
        boolean isProjetAdded = registreProjet.addProjet(projet);

        return isProjetAdded;
    }
}
