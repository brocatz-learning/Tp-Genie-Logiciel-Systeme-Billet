package model;

import java.util.ArrayList;
import java.util.regex.Pattern;

// Singleton
public class RegistreUsager {

    private ArrayList<Usager> listUsager = new ArrayList<Usager>();

    private static RegistreUsager registreUsager;

    private RegistreUsager() {
        if (registreUsager == null) {
            registreUsager = new RegistreUsager();
        }
    }

    public boolean addUsager(Usager usager){
        boolean isUserAdded = false;

        if(verficationDuplicationUsager(usager))
           return false;

        if (validationChampUsager(usager) ) {
            isUserAdded = true;
        }


        return isUserAdded;
    }

    private boolean validationChampUsager(Usager usager) {
        // Validation Enmail

        boolean isEmailValidate = usager.getEmail().matches(Usager.REGEX_EMAIL);

//        boolean isNom =

        return false;

    }

    // O
    private boolean verficationDuplicationUsager(Usager usager) {
        boolean isEmailDuplicated = listUsager.stream().anyMatch(element -> element.getEmail().equalsIgnoreCase(usager.getEmail()));
        return isEmailDuplicated;

    }
}
