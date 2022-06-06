package persistence;

import model.Billet;
import model.Filtre;
import model.state.stateBillet.StateOuvert;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RegistreBillet {

    private List<Billet> listBillet;

    private static RegistreBillet registreBillet;

    private RegistreBillet () {
       listBillet = new ArrayList<>();

    }

    public static RegistreBillet getInstance () {
        if (registreBillet == null) {
            registreBillet = new RegistreBillet();
        }

        return  RegistreBillet.registreBillet;
    }

    public List<Billet> getListBillet() {
        return this.listBillet;
    }

    public boolean addBillet(Billet billet) {
        return this.listBillet.add(billet);
    }


    public static List<Billet> filtre (Filtre filtre) {
        List<Billet> listARetourner = new ArrayList<>();
        switch (filtre) {
            case Category:
               listARetourner = registreBillet.getListBillet()
                       .stream()
                       .filter(billet -> billet.getEtatBillet() instanceof StateOuvert).collect(Collectors.toList());
                break;
            case DateOuverture:
                listARetourner = registreBillet.listBillet.stream()
                        .sorted(Comparator.comparing(Billet::getCategory))
                        .collect(Collectors.toCollection(ArrayList::new));
                break;
            case Demandeur:
                break;
            case PersonneEnCharge:
                break;
            case Projet:
                break;

        }

        return listARetourner;
    }
}
