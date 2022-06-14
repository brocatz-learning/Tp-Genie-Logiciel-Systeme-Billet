package model.dataModel;

import model.dto.UsagerDTO;

// Client reguliere qui n'a pas d'experience en programmation
public class Client extends Usager {



    public Client() {}
    public Client(UsagerDTO usagerDTO) {
        super(usagerDTO);
    }
}
