package facade;

import model.*;
import model.state.stateBillet.StateOuvert;
import persistence.ServicePeristence;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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


        Billet billet = new Billet(billetDTO);
        billet.setDateCreationBillet(new Date());
        billet.setHistoriqueBillets(new ArrayList<HistoriqueBillet>());
        billet.setEtatBillet(new StateOuvert(billet));



//        Billet billet =
//                new Billet(
//                        billetDTO.getDescriptionProbleme(),
//                        findByEmail(billetDTO.getPersonneEnCharger().getEmail()),
//                        billetDTO.getDemandeur().getE,
//                        billetDTO.getCategory(),
//                        billetDTO.getGravity());

        //boolean isBilletAdded = servicePeristence.createBillet(billet);
        return servicePeristence.createBillet(billet);
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

    public List<BilletDTO> consulterListeBillet(Filtre filtre, String valeur) {
        List<Billet> listeBillet = servicePeristence.consulterListeBillet(filtre, valeur);

        List<BilletDTO> listeBilletDTO = new ArrayList<BilletDTO>();

        listeBillet.forEach(billet -> {
            BilletDTO billetDTO = new BilletDTO();
            billetDTO.setId(billet.getId());
            billetDTO.setNote(billet.getNote());
            billetDTO.setPersonneEnCharger(billet.getPersonneEnCharger().asDTO());
            billetDTO.setDemandeur(billet.getDemandeur().asDTO());
            billetDTO.setCategory(billet.getCategory());
            billetDTO.setGravity(billet.getGravity());
            billetDTO.setEtatBillet(billet.getEtatBillet());
            billetDTO.setDateCreation(billet.getDateCreationBillet());
            listeBilletDTO.add(billetDTO);
        });

        return listeBilletDTO;
    }

    public boolean isProjetExist(String nom) {
        return servicePeristence.isProjetNameDuplicated(nom);
    }

    public boolean isCategoryExist(String category) {
        return servicePeristence.isCateogrieInRegistre(category);
    }
}
