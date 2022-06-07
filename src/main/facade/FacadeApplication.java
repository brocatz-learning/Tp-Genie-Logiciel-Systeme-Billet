package facade;

import exception.UserNotVaildExeption;
import model.*;
import persistence.RegistreProjet;
import persistence.RegistreUsager;
import persistence.ServicePeristence;

public class FacadeApplication {

   private ServicePeristence servicePeristence = new ServicePeristence();


    public boolean createUsager (UsagerDTO usagerDTO, int choixResponse)  {
        Usager usager = FactoryUsagerTechnique.getUsagerFactory(choixResponse);
        usager.setUsername(usagerDTO.getUsername());
        usager.setPassword(usagerDTO.getPassword());
        usager.setEmail(usagerDTO.getEmail());
        usager.setNom(usagerDTO.getNom());
        usager.setPrenom(usagerDTO.getPrenom());
        boolean isUsagerCreer = servicePeristence.createUsager(usager);

        return isUsagerCreer;
    }

    public boolean isEmailDuplicated(String email) {
        return servicePeristence.isEmailDuplicated(email);
    }

    public boolean createProjet(ProjetDTO projetDTO) {
        Projet projet = new Projet(projetDTO.getNom(), projetDTO.getDescription());
        projet.setNom(projetDTO.getNom());
        boolean isProjetAdded = servicePeristence.createProjet(projet);

        return isProjetAdded;
    }

    public boolean createBillet(BilletDTO billetDTO) {


//        Billet billet =
//                new Billet(
//                        billetDTO.getDescriptionProbleme(),
//                        findByEmail(billetDTO.getPersonneEnCharger().getEmail()),
//                        billetDTO.getDemandeur().getE,
//                        billetDTO.getCategory(),
//                        billetDTO.getGravity());

        //boolean isBilletAdded = servicePeristence.createBillet(billet);

        return false;
    }

    public boolean isProjetDuplicated(String nomProjet) {
        return servicePeristence.isProjetNameDuplicated(nomProjet);
    }

    public int getListUsagerSize() {
        return servicePeristence.getListUsagerSize();
    }

    public int getListProjetSize() {
        return servicePeristence.getListProjetSize();
    }


    public boolean isEmailInEnRegistre(String email) {
        return servicePeristence.isEmailInEnRegistre(email);
    }


    public boolean createCategorie(String category) {
        return servicePeristence.createCategorie(category);
    }

    public boolean createAssignation(String  nomProjet, String emailUsager) {
        return servicePeristence.createAssignation(nomProjet, emailUsager);
    }
}
