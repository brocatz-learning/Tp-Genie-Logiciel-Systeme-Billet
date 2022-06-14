package model.dto;

import model.dataModel.Usager;

import java.util.Date;
import java.util.TreeSet;

public class ProjetDTO {

    private int id;
    private String nom;
    private Date dateCreation;
    private String description;

    private TreeSet<Usager> listUsager;

    public ProjetDTO() {
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

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TreeSet<Usager> getListUsager() {
        return listUsager;
    }

    public void setListUsager(TreeSet<Usager> listUsager) {
        this.listUsager = listUsager;
    }
}
