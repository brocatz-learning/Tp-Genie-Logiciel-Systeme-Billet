package persistence;

import exception.UserNotVaildExeption;
import model.Usager;

import java.util.ArrayList;

// Singleton
public class RegistreUsager {

    private ArrayList<Usager> listUsager = new ArrayList<Usager>();

    private static RegistreUsager registreUsager;

    private RegistreUsager() {
    }

    public static RegistreUsager getInstance() {
        if (registreUsager == null) {
            registreUsager = new RegistreUsager();
        }
        return registreUsager;
    }

    public boolean addUsager(Usager usager){
        boolean isUserAdded = false;

        if(verficationDuplicationUsagerEmail(usager.getEmail()))
           return false;

        if (validationChampUsager(usager) ) {
            isUserAdded = true;
            this.listUsager.add(usager);
        }


        return isUserAdded;
    }

    public void clear() {
        this.listUsager.clear();
    }

    public int getSize() {
        return this.listUsager.size();
    }

    public boolean validationChampUsager(Usager usager)  {
        // Validation Enmail
        boolean isUserValide = true;

        int firstNameLength = usager.getNom().length();
        int lastNameLength = usager.getPrenom().length();
        int passwordLength = usager.getPassword().length();
        int usernameLength = usager.getUsername().length();
        boolean isEmailValide = usager.getEmail().matches(Usager.REGEX_EMAIL);

        if (firstNameLength < 1 || lastNameLength < 1 ||
                passwordLength < 1 || usernameLength < 1
                || isEmailValide == false) {
            isUserValide = false;
        }

        return isUserValide;

    }

    // O
    public boolean verficationDuplicationUsagerEmail(String email) {
        boolean isEmailDuplicated = listUsager.stream()
                .anyMatch(element -> element.getEmail().equalsIgnoreCase(email));
        return isEmailDuplicated;
    }


}
