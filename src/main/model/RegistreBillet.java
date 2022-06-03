package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RegistreBillet {

    private ArrayList<Billet> listBillet;

    private static RegistreBillet registreBillet;

    private RegistreBillet () {
        if(registreBillet == null) {
            registreBillet = new RegistreBillet();
        }

    }

    public static RegistreBillet getInstance () {
        return  RegistreBillet.registreBillet;
    }

    public ArrayList<Billet> getListBillet() {
        return this.listBillet;
    }


    public static ArrayList<Billet> filtre (Filtre filtre) {
        ArrayList<Billet> listARetourner = new ArrayList<Billet>();
        switch (filtre) {
            case Category:
               listARetourner = registreBillet.listBillet.stream()
                       .sorted(Comparator.comparing(Billet::getCategory))
                       .collect(Collectors.toCollection(ArrayList::new));
                break;
            case DateOuverture:
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
