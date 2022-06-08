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

    public Projet () {}
    public Projet(ProjetDTO projetDTO) {
        this.setId(projetDTO.getId());
        this.setNom(projetDTO.getNom());
        this.setDateCreation(projetDTO.getDateCreation());
        this.setDescription(projetDTO.getDescription());
        this.setListUsager(projetDTO.getListUsager());
    }



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

    public boolean addUsager(Usager usager) {
        return this.listUsager.add(usager);
    }

    public ProjetDTO asDTO() {
        ProjetDTO projetDTO = new ProjetDTO();
        projetDTO.setId(this.id);
        projetDTO.setNom(this.nom);
        projetDTO.setDateCreation(this.dateCreation);
        projetDTO.setDescription(this.description);
        return projetDTO;
    }
}
