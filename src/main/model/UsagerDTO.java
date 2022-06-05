package model;

import java.util.Date;
import java.util.Objects;

public class UsagerDTO {

    private int id;
    private String nom;
    private String prenom;
    private String username;
    private String password;
    private String email;
    private Date dateCreation;

    public UsagerDTO() {
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

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Override
    public String toString() {
        return "UsagerDTO{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsagerDTO usagerDTO = (UsagerDTO) o;
        return id == usagerDTO.id && nom.equals(usagerDTO.nom) && prenom.equals(usagerDTO.prenom) && username.equals(usagerDTO.username) && password.equals(usagerDTO.password) && email.equals(usagerDTO.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, prenom, username, password, email);
    }
}
