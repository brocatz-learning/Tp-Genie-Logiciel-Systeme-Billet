package model;

import model.state.stateBillet.StateBillet;
import model.state.stateBillet.StateOuvert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Billet {

    private static int generateurBillet = 0;

    private int id;
    private String descriptionProbleme;
    private Usager personneEnCharger;
    private Usager demandeur;
    private StateBillet etatBillet;
    private Gravity gravity;
    private String category;

    private List<HistoriqueBillet> historiqueBillets;

    private Date date;


    public Billet(String descriptionProbleme, Usager personneEnCharger, Usager demandeur, String category, Gravity gravity) {
        this.descriptionProbleme = descriptionProbleme;
        this.personneEnCharger = personneEnCharger;
        this.demandeur = demandeur;
        this.gravity = gravity;
        this.category = category;

        this.id = ++ generateurBillet;
        this.etatBillet = new StateOuvert(this);
        this.date = new Date();
        this.historiqueBillets = new ArrayList<>();
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

    public BilletDTO asDTO () {
        BilletDTO dto = new BilletDTO();
        dto.setId(this.id);
        dto.setDescriptionProbleme(this.descriptionProbleme);
        dto.setPersonneEnCharger(this.personneEnCharger.asDTO());
        dto.setDemandeur(this.demandeur.asDTO());
        dto.setEtatBillet(this.etatBillet);
        dto.setGravity(this.gravity);
        dto.setCategory(this.category);
        dto.setHistoriqueBillets(this.historiqueBillets);
        return dto;

    }
}
