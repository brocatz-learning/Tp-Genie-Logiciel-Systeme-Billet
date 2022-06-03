package model;

import model.state.stateBillet.StateBillet;
import model.state.stateBillet.StateOuvert;

import java.util.ArrayList;

public class Billet {

    private static int generateurBillet = 0;

    private int id;
    private String descriptionProbleme;
    private Usager personneEnCharger;
    private Usager demandeur;
    private StateBillet etatBillet;
    private Gravity gravity;
    private Category category;

    private ArrayList<HistoriqueBillet> historiqueBillets;


    public Billet(String descriptionProbleme, Usager personneEnCharger, Usager demandeur, Category category, Gravity gravity) {
        this.descriptionProbleme = descriptionProbleme;
        this.personneEnCharger = personneEnCharger;
        this.demandeur = demandeur;
        this.gravity = gravity;
        this.category = category;
        // G
        this.id = ++ generateurBillet;
        this.etatBillet = new StateOuvert(this);
    }

    public static int getGenerateurBillet() {
        return generateurBillet;
    }

    public static void setGenerateurBillet(int generateurBillet) {
        Billet.generateurBillet = generateurBillet;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
