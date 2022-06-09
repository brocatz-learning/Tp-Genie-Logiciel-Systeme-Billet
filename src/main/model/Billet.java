package model;

import model.state.stateBillet.StateBillet;
import model.state.stateBillet.StateOuvert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Billet {

    private static int generateurBillet = 0;

    private int id;
    private String note;
    private Usager personneEnCharger;
    private Usager demandeur;
    private StateBillet etatBillet;
    private Gravity gravity;
    private String category;

    private Projet projet;

    private List<HistoriqueBillet> historiqueBillets;

    private Date dateCreationBillet;
    private Date dateAssignationBillet;


    public Billet() {}
    public Billet(BilletDTO billetDTO) {
        this.setId(billetDTO.getId());
        this.setNote(billetDTO.getNote());
        this.setPersonneEnCharger(new Usager(billetDTO.getPersonneEnCharger()));
        this.setDemandeur(new Usager(billetDTO.getDemandeur()));
        this.setEtatBillet(billetDTO.getEtatBillet());
        this.setGravity(billetDTO.getGravity());
        this.setCategory(billetDTO.getCategory());
        this.setProjet(new Projet(billetDTO.getProjet()));
        this.setHistoriqueBillets(billetDTO.getHistoriqueBillets());
        this.setDateCreationBillet(billetDTO.getDateCreation());
    }

    public Billet(String note, Usager personneEnCharger, Usager demandeur, String category, Gravity gravity,Projet projet) {
        this.note = note;
        this.personneEnCharger = personneEnCharger;
        this.demandeur = demandeur;
        this.gravity = gravity;
        this.category = category;
        this.projet = projet;

        this.id = ++ generateurBillet;
        this.etatBillet = new StateOuvert(this);
        this.dateCreationBillet = new Date();
        this.historiqueBillets = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Usager getPersonneEnCharger() {
        return personneEnCharger;
    }

    public void setPersonneEnCharger(Usager personneEnCharger) {
        this.personneEnCharger = personneEnCharger;
    }

    public Usager getDemandeur() {
        return demandeur;
    }

    public void setDemandeur(Usager demandeur) {
        this.demandeur = demandeur;
    }

    public StateBillet getEtatBillet() {
        return etatBillet;
    }

    public void setEtatBillet(StateBillet etatBillet) {
        this.etatBillet = etatBillet;
    }

    public Gravity getGravity() {
        return gravity;
    }

    public void setGravity(Gravity gravity) {
        this.gravity = gravity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<HistoriqueBillet> getHistoriqueBillets() {
        return this.historiqueBillets;
    }

    public void setHistoriqueBillets(List<HistoriqueBillet> historiqueBillets) {
        this.historiqueBillets = historiqueBillets;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public Date getDateCreationBillet() {
        return dateCreationBillet;
    }

    public void setDateCreationBillet(Date dateCreationBillet) {
        this.dateCreationBillet = dateCreationBillet;
    }



    public BilletDTO asDTO () {
        BilletDTO dto = new BilletDTO();
        dto.setId(this.id);
        dto.setNote(this.note);
        dto.setPersonneEnCharger(this.personneEnCharger.asDTO());
        dto.setDemandeur(this.demandeur.asDTO());
        dto.setEtatBillet(this.etatBillet);
        dto.setGravity(this.gravity);
        dto.setCategory(this.category);
        dto.setProjet(this.projet.asDTO());
        dto.setHistoriqueBillets(this.historiqueBillets);
        return dto;

    }
}
