package model;

import java.util.Date;
import java.util.Locale;

public  class Usager implements Comparable<Usager> {

    public static String REGEX_EMAIL = "^[A-Za-z0-9+_.-]+@(.+)$";
    public static String REGEX_NOM = "";


    private int id;
    private String nom;
    private String prenom;
    private String username;
    private String password;
    private String email;
    private Date dateCreation;

    public Usager() {
    }


    public Usager(UsagerDTO usagerDTO) {
        this.setDateCreation(usagerDTO.getDateCreation());
        this.setPrenom(usagerDTO.getPrenom());
        this.setNom(usagerDTO.getNom());
        this.setId(usagerDTO.getId());
        this.setEmail(usagerDTO.getEmail());
        this.setPassword(usagerDTO.getPassword());
        this.setUsername(usagerDTO.getUsername());
    }

    public Usager(int id, String lastName, String firstName, String username, String password, String email, Date date) {
        this.id = id;
        this.nom = lastName;
        this.prenom = firstName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.dateCreation = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    // Les email
    public void setEmail(String email) {
        if (email != null) {
            email = email.toLowerCase(Locale.ROOT);
        }
        this.email = email;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public UsagerDTO asDTO() {
        UsagerDTO usagerDTO = new UsagerDTO();

        usagerDTO.setId(this.id);
        usagerDTO.setEmail(this.email);
        usagerDTO.setNom(this.nom);
        usagerDTO.setPrenom(this.prenom);
        usagerDTO.setDateCreation(this.dateCreation);
        usagerDTO.setPassword(this.password);
        usagerDTO.setUsername(this.username);

        return usagerDTO;

    }

    @Override
    public int compareTo(Usager o) {
        if (this.id > o.id) {
            return 1;
        } else if (this.id < o.id) {
            return -1;
        } else {
            return 0;
        }

    }
}
