package persistence;

import model.dataModel.Usager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
            usager.setId(listUsager.size() + 1);
            usager.setDateCreation(new Date());
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

    private boolean validationChampUsager(Usager usager)  {
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

    public boolean isEmailInRegistre(String email) {
        List<Usager> listUsagerFiltre = listUsager.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .collect(Collectors.toCollection(ArrayList::new));

        return listUsagerFiltre.size() > 0 ? true : false;
    }

    public Usager findByEmail(String email) {
        List<Usager> listUsagerFiltre = listUsager.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .collect(Collectors.toCollection(ArrayList::new));

        if (listUsagerFiltre.size() > 0) {
            return listUsagerFiltre.get(0);
        } else {
            return null;
        }
    }

}
