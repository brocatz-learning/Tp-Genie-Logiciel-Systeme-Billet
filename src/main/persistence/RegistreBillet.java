package persistence;

import model.dataModel.Billet;
import model.dataModel.Filtre;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    public void clear() {
        this.listBillet.clear();
    }

    public boolean addBillet(Billet billet) {
        billet.setId(listBillet.size() + 1);
        billet.setDateCreationBillet(new Date());
        boolean isAdded = listBillet.add(billet);

        return isAdded;
    }

    public int getSize() {
        return this.listBillet.size();
    }


    public  List<Billet> filtreBillet (Filtre filtre, String inputUtilisateur) {
        List<Billet> listARetourner = new ArrayList<>();
        switch (filtre) {
            case DateOuverture:
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date date = sdf.parse(inputUtilisateur);

                    listARetourner = registreBillet.listBillet.stream()
                            .filter((billet) -> {
                                return DateUtils.isSameDay(billet.getDateCreationBillet(), date);})
                            .collect(Collectors.toCollection(ArrayList::new));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

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

    public boolean isBilletExist(int idBillet) {
        return listBillet.stream()
                .anyMatch(billet -> billet.getId() == idBillet);
    }

    public Billet findById(int idBillet) {
        return listBillet.stream()
                .filter(billet -> billet.getId() == idBillet)
                .findFirst()
                .orElse(null);
    }
}
