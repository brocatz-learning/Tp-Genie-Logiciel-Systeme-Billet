package model.dataModel;

import model.dataModel.Usager;
import model.state.stateBillet.StateBillet;

import java.util.Date;

public class HistoriqueBillet {

    private StateBillet stateBillet;
    private Usager usager;
    private String commentaire;
    private Date date;

    public HistoriqueBillet(StateBillet stateBillet, Usager usager, String commentaire, Date date) {
        this.stateBillet = stateBillet;
        this.usager = usager;
        this.commentaire = commentaire;
        this.date = date;
    }

    public StateBillet getStateBillet() {
        return stateBillet;
    }

    public void setStateBillet(StateBillet stateBillet) {
        this.stateBillet = stateBillet;
    }

    public Usager getUsager() {
        return usager;
    }

    public void setUsager(Usager usager) {
        this.usager = usager;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
