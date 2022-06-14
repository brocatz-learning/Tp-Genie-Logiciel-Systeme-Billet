package model.dto;

import model.dataModel.Gravity;
import model.dataModel.HistoriqueBillet;
import model.state.stateBillet.StateBillet;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BilletDTO {

    private int id;
    private String note;
    private UsagerDTO personneEnCharger;
    private UsagerDTO demandeur;
    private StateBillet etatBillet;
    private Gravity gravity;
    private String category;

    private List<HistoriqueBillet> historiqueBillets;

    private Date dateCreation;

    private Date dateAssignation;


    private ProjetDTO projet;

    public BilletDTO () {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<HistoriqueBillet> getHistoriqueBillets() {
        return historiqueBillets;
    }

    public void setHistoriqueBillets(List<HistoriqueBillet> historiqueBillets) {
        this.historiqueBillets = historiqueBillets;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public ProjetDTO getProjet() {
        return projet;
    }

    public void setProjet(ProjetDTO projet) {
        this.projet = projet;
    }

    public Date getDateAssignation() {
        return dateAssignation;
    }

    public void setDateAssignation(Date dateAssignation) {
        this.dateAssignation = dateAssignation;
    }

    public String toString() {
        return "BilletDTO{" +
                "id=" + id +
                ", note='" + note + '\'' +
                ", personneEnCharger=" + personneEnCharger +
                ", demandeur=" + demandeur +
                ", etatBillet=" + etatBillet +
                ", gravity=" + gravity +
                ", category='" + category + '\'' +
                ", historiqueBillets=" + historiqueBillets +
                ", dateCreation=" + dateCreation +
                ", dateAssignation=" + dateAssignation +
                ", projet=" + projet +
                '}';
    }

    public String formatBillet() {


        System.out.print(String.format("%-10s\t", "id"));
        System.out.print(String.format("%-20s", "note"));
        System.out.print(String.format("%-32s", "personneEnCharge"));
        System.out.print(String.format("%-32s", "demandeur"));
        System.out.print(String.format("%-15s", "etatBillet"));
        System.out.print(String.format("%-10s", "gravity"));
        System.out.print(String.format("%-12s", "category"));
        System.out.print(String.format("%-25s", "historiqueBillets"));
        System.out.print(String.format("%-25s", "dateCreation"));
        System.out.print(String.format("%-25s", "dateAssignation"));
        System.out.print(String.format("%-15s", "projet"));


        System.out.println();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateFormatted = sdf.format(this.getDateCreation());

        return
                String.format("%-10s\t", id) +
                String.format("%-20s", note) +
                String.format("%-32s", personneEnCharger.getEmail()) +
                String.format("%-32s", demandeur.getEmail()) +
                String.format("%-15s", etatBillet.getCurrentState()) +
                String.format("%-10s", gravity) +
                String.format("%-12s", category) +
                String.format("%-25s", historiqueBillets) +
                String.format("%-25s", dateFormatted) +
                String.format("%-25s", dateAssignation) +
                String.format("%-15s", projet.getNom());

    }
}
