package model;

import model.state.stateBillet.StateBillet;

import java.util.Date;
import java.util.List;

public class BilletDTO {

    private int id;
    private String descriptionProbleme;
    private UsagerDTO personneEnCharger;
    private UsagerDTO demandeur;
    private StateBillet etatBillet;
    private Gravity gravity;
    private Category category;

    private List<HistoriqueBillet> historiqueBillets;

    private Date date;

    public BilletDTO () {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescriptionProbleme() {
        return descriptionProbleme;
    }

    public void setDescriptionProbleme(String descriptionProbleme) {
        this.descriptionProbleme = descriptionProbleme;
    }

    public UsagerDTO getPersonneEnCharger() {
        return personneEnCharger;
    }

    public void setPersonneEnCharger(UsagerDTO personneEnCharger) {
        this.personneEnCharger = personneEnCharger;
    }

    public UsagerDTO getDemandeur() {
        return demandeur;
    }

    public void setDemandeur(UsagerDTO demandeur) {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<HistoriqueBillet> getHistoriqueBillets() {
        return historiqueBillets;
    }

    public void setHistoriqueBillets(List<HistoriqueBillet> historiqueBillets) {
        this.historiqueBillets = historiqueBillets;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
