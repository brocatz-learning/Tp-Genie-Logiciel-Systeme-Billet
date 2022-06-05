package model;

import java.io.PrintWriter;
import java.util.Date;
import java.util.TreeSet;

public class Projet {

    private static int projetGeneratedId = 0;

    private int id;
    private String nom;
    private Date dateCreation;
    private String description;

    private TreeSet<Usager> listUsager;

    public Projet(String nom,String description) {
        this.id = ++ Projet.projetGeneratedId;
        this.setNom(nom);
        this.setDescription(description);
        this.dateCreation = new Date();
        this.listUsager = new TreeSet<Usager>();

    }

    public int getId() {
        return id;
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


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
