package facade;

import exception.UserNotVaildExeption;
import model.FactoryUsagerTechnique;
import model.Usager;
import model.UsagerDTO;
import persistence.RegistreUsager;

public class FacadeApplication {

    static {
        registreUsager = RegistreUsager.getInstance();
    }
    private static RegistreUsager registreUsager = RegistreUsager.getInstance();
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
}
