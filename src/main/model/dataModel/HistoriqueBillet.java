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
}
