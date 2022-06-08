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
        billet.setId(listBillet.size() + 1);

        return this.listBillet.add(billet);
    }

    public int getSize() {
        return this.listBillet.size();
    }


    public static List<Billet> filtreBillet (Filtre filtre, String inputUtilisateur) {
        List<Billet> listARetourner = new ArrayList<>();
        switch (filtre) {
            case DateOuverture:
                listARetourner = registreBillet.listBillet.stream()
                        .sorted(Comparator.comparing(Billet::getCategory))
                        .collect(Collectors.toCollection(ArrayList::new));
                break;
            case Demandeur:
                listARetourner = registreBillet.listBillet.stream()
                        .filter(billet ->
                                billet.getDemandeur().getEmail().equalsIgnoreCase(inputUtilisateur))
                        .collect(Collectors.toCollection(ArrayList::new));
                break;
            case Etat:
                listARetourner = registreBillet.listBillet.stream()
                        .filter(billet ->
                                billet
                                        .getEtatBillet()
                                        .getClass()
                                        .getSimpleName().toLowerCase()
                                        .equalsIgnoreCase(inputUtilisateur))
                        .collect(Collectors.toCollection(ArrayList::new));

                break;
            case PersonneEnCharge:
                listARetourner = registreBillet.listBillet.stream()
                        .filter(billet ->
                                billet.getPersonneEnCharger().getEmail().equalsIgnoreCase(inputUtilisateur))
                        .collect(Collectors.toCollection(ArrayList::new));
                break;
            case Projet:
                listARetourner = registreBillet.listBillet.stream()
                        .filter(billet ->
                                billet.getProjet().getNom().equalsIgnoreCase(inputUtilisateur))
                        .collect(Collectors.toCollection(ArrayList::new));
                break;
                case Category:
                    listARetourner = registreBillet.listBillet.stream()
                            .filter(billet ->
                                    billet.getCategory().equalsIgnoreCase(inputUtilisateur))
                            .collect(Collectors.toCollection(ArrayList::new));
                    break;
            case Gravity:
                listARetourner = registreBillet.listBillet.stream()
                        .filter(billet ->
                                billet.getGravity().toString().equalsIgnoreCase(inputUtilisateur))
                        .collect(Collectors.toCollection(ArrayList::new));

                break;

        }

        return listARetourner;
    }
}
