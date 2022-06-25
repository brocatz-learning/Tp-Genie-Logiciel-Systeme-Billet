package presentation.formattage;

import model.dataModel.HistoriqueBillet;
import model.dto.BilletDTO;
import model.dto.ProjetDTO;
import model.dto.UsagerDTO;
import utile.ConsoleColors;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Classe qui permet de formatter les BilletsDTO
 *
 * @author Maxi
 *
 *
 * */

public class FormatBilletDTO {

    public static String formatListBilletDTO(List<BilletDTO> listBilletDTO) {

        StringBuilder sb = new StringBuilder();

        // On parcours la liste de billetDTO deux fois :
        // Le
        int idtextLength = 10;
        int notetextLength = 20;
        int personneEnChargertextLength = 32;
        int demandeurtextLength = 32;
        int etatBillettextLength = 25;
        int gravitytextLength = 10;
        int categorytextLength = 12;
        int historiqueBilletstextLength = 32;
        int dateCreationtextLength = 25;
        int dateAssignationtextLength = 25;
        int projettextLength = 25;



        for (BilletDTO billetDTO : listBilletDTO) {
            idtextLength = Math.max(idtextLength, String.valueOf(billetDTO.getId()).length());
            notetextLength = Math.max(notetextLength, billetDTO.getNote().length() + 5);
            if (billetDTO.getPersonneEnCharger() != null)
                personneEnChargertextLength = Math.max(personneEnChargertextLength, billetDTO.getPersonneEnCharger().getNom().length() + billetDTO.getPersonneEnCharger().getPrenom().length() + 5);

            demandeurtextLength = Math.max(demandeurtextLength, billetDTO.getDemandeur().getEmail().length() + 5);
            etatBillettextLength = Math.max(etatBillettextLength, billetDTO.getEtatBillet().toString().length() + 5);
            gravitytextLength = Math.max(gravitytextLength, billetDTO.getGravity().toString().length() + 5);
            categorytextLength = Math.max(categorytextLength, billetDTO.getCategory().length() + 5);
            historiqueBilletstextLength = Math.max(historiqueBilletstextLength, String.valueOf(billetDTO.getHistoriqueBillets().size()).length() + 5);
            dateCreationtextLength = Math.max(dateCreationtextLength, billetDTO.getDateCreation().toString().length() + 5);
            if (billetDTO.getDateAssignation() != null)
                dateAssignationtextLength = Math.max(dateAssignationtextLength, billetDTO.getDateAssignation().toString().length() + 5);
            projettextLength = Math.max(projettextLength, billetDTO.getProjet().toString().length() + 5);

        }

        sb.append(String.format("%-" + idtextLength + "s\t", "Id"));
        sb.append(String.format("%-" + notetextLength + "s\t", "Note"));
        sb.append(String.format("%-" + personneEnChargertextLength + "s\t", "Personne en charge"));
        sb.append(String.format("%-" + demandeurtextLength + "s\t", "Demandeur"));
        sb.append(String.format("%-" + etatBillettextLength + "s\t", "Etat billet"));
        sb.append(String.format("%-" + gravitytextLength + "s\t", "Gravity"));
        sb.append(String.format("%-" + categorytextLength + "s\t", "Category"));
        sb.append(String.format("%-" + historiqueBilletstextLength + "s\t", "Historique billets"));
        sb.append(String.format("%-" + dateCreationtextLength + "s\t", "Date creation"));
        sb.append(String.format("%-" + dateAssignationtextLength + "s\t", "Date assignation"));
        sb.append(String.format("%-" + projettextLength + "s\t", "Projet"));
        sb.append("\n");

        int totalCharWidth = idtextLength + notetextLength + personneEnChargertextLength +
                demandeurtextLength + etatBillettextLength + gravitytextLength +
                categorytextLength + historiqueBilletstextLength +
                dateCreationtextLength + dateAssignationtextLength +
                projettextLength + 25;

        sb.append(String.join("", Collections.nCopies(totalCharWidth,"-")) + "\n");

        for (BilletDTO billetDTO : listBilletDTO) {
            sb.append(String.format("%-" + idtextLength + "s\t", billetDTO.getId()));
            sb.append(String.format("%-" + notetextLength + "s\t", billetDTO.getNote()));
            if (billetDTO.getPersonneEnCharger() != null)
                sb.append(String.format("%-" + personneEnChargertextLength + "s\t",billetDTO.getPersonneEnCharger().getEmail()));
            else
                sb.append(String.format("%-" + personneEnChargertextLength + "s\t", ""));
            sb.append(String.format("%-" + demandeurtextLength + "s\t", billetDTO.getDemandeur().getEmail()));
            sb.append(String.format("%-" + etatBillettextLength + "s\t", billetDTO.getEtatBillet().getCurrentState()));
            sb.append(String.format("%-" + gravitytextLength + "s\t", billetDTO.getGravity().toString()));
            sb.append(String.format("%-" + categorytextLength + "s\t", billetDTO.getCategory()));
            sb.append(String.format("%-" + historiqueBilletstextLength + "s\t", billetDTO.getHistoriqueBillets().size()));
            sb.append(String.format("%-" + dateCreationtextLength + "s\t", billetDTO.getDateCreation().toString()));
            if (billetDTO.getDateAssignation() != null)
                sb.append(String.format("%-" + dateAssignationtextLength + "s\t", billetDTO.getDateAssignation().toString()));
            else
                sb.append(String.format("%-" + dateAssignationtextLength + "s\t", ""));
            sb.append(String.format("%-" + projettextLength + "s\t", billetDTO.getProjet().getNom()));
            sb.append(String.format("\n"));
        }

        return sb.toString();

    }


    public static String getBilletDetails(BilletDTO billetDTO) {
        StringBuilder sb = new StringBuilder();
        // Pour le projet simplement
        int idtextLength = 25;
        int notetextLength = 25;
        int personneEnChargertextLength = 25;
        int demandeurtextLength = 25;
        int etatBillettextLength = 25;
        int gravitytextLength = 25;
        int categorytextLength = 25;
        int historiqueBilletstextLength = 25;
        int dateCreationtextLength = 25;
        int dateAssignationtextLength = 25;
        int projettextLength = 25;

        idtextLength = Math.max(idtextLength, String.valueOf(billetDTO.getId()).length() + 5);
        notetextLength = Math.max(notetextLength, billetDTO.getNote().length() + 5);
        if (billetDTO.getPersonneEnCharger() != null)
            personneEnChargertextLength = Math.max(personneEnChargertextLength, billetDTO.getPersonneEnCharger().getEmail().length() + 5);
        demandeurtextLength = Math.max(demandeurtextLength, billetDTO.getDemandeur().getEmail().length() + 5);
        etatBillettextLength = Math.max(etatBillettextLength, billetDTO.getEtatBillet().getCurrentState().length() + 5);
        gravitytextLength = Math.max(gravitytextLength, billetDTO.getGravity().toString().length() + 5);
        categorytextLength = Math.max(categorytextLength, billetDTO.getCategory().length() + 5);
        historiqueBilletstextLength = Math.max(historiqueBilletstextLength, billetDTO.getHistoriqueBillets().size() + 5);
        dateCreationtextLength = Math.max(dateCreationtextLength, billetDTO.getDateCreation().toString().length() + 5);
        if (billetDTO.getDateAssignation() != null)
            dateAssignationtextLength = Math.max(dateAssignationtextLength, billetDTO.getDateAssignation().toString().length() + 5);
        projettextLength = Math.max(projettextLength, billetDTO.getProjet().getNom().length() + 5);

        sb.append(String.format(ConsoleColors.BLUE_BOLD + "Billet" + ConsoleColors.RESET + "\n"));

        sb.append(String.format("%-" + idtextLength + "s\t", "Id"));
        sb.append(String.format("%-" + notetextLength + "s\t", "Note"));
        sb.append(String.format("%-" + personneEnChargertextLength + "s\t", "Personne en charge"));
        sb.append(String.format("%-" + demandeurtextLength + "s\t", "Demandeur"));
        sb.append(String.format("%-" + etatBillettextLength + "s\t", "Etat billet"));
        sb.append(String.format("%-" + gravitytextLength + "s\t", "Gravity"));
        sb.append(String.format("%-" + categorytextLength + "s\t", "Category"));
        sb.append(String.format("%-" + historiqueBilletstextLength + "s\t", "Historique billets"));
        sb.append(String.format("%-" + dateCreationtextLength + "s\t", "Date creation"));
        sb.append(String.format("%-" + dateAssignationtextLength + "s\t", "Date assignation"));
        sb.append(String.format("%-" + projettextLength + "s\t", "Projet"));
        sb.append(String.format("\n"));

        int totalCharWidth = idtextLength + notetextLength + personneEnChargertextLength + demandeurtextLength +
                etatBillettextLength + gravitytextLength + categorytextLength +
                historiqueBilletstextLength + dateCreationtextLength +
                dateAssignationtextLength + projettextLength + 25;

        sb.append(String.join("", Collections.nCopies(totalCharWidth,"-")) + "\n");


        sb.append(String.format("%-" + idtextLength + "s\t", billetDTO.getId()));
        sb.append(String.format("%-" + notetextLength + "s\t", billetDTO.getNote()));
        if (billetDTO.getPersonneEnCharger() != null)
            sb.append(String.format("%-" + personneEnChargertextLength + "s\t", billetDTO.getPersonneEnCharger().getEmail()));
        else
            sb.append(String.format("%-" + personneEnChargertextLength + "s\t", ""));
        sb.append(String.format("%-" + demandeurtextLength + "s\t", billetDTO.getDemandeur().getEmail()));
        sb.append(String.format("%-" + etatBillettextLength + "s\t", billetDTO.getEtatBillet().getCurrentState()));
        sb.append(String.format("%-" + gravitytextLength + "s\t", billetDTO.getGravity().toString()));
        sb.append(String.format("%-" + categorytextLength + "s\t", billetDTO.getCategory()));
        sb.append(String.format("%-" + historiqueBilletstextLength + "s\t", billetDTO.getHistoriqueBillets().size()));
        sb.append(String.format("%-" + dateCreationtextLength + "s\t", billetDTO.getDateCreation().toString()));
        if (billetDTO.getDateAssignation() != null)
            sb.append(String.format("%-" + dateAssignationtextLength + "s\t", billetDTO.getDateAssignation().toString()));
        else
            sb.append(String.format("%-" + dateAssignationtextLength + "s\t", ""));
        sb.append(String.format("%-" + projettextLength + "s\t", billetDTO.getProjet().getNom()));
        sb.append(String.format("\n\n"));

        String formattedProjet = formatProjet(billetDTO.getProjet());
        sb.append(formattedProjet);
        sb.append(String.format("\n"));


        sb.append(String.format(ConsoleColors.BLUE_BOLD + "Demandeur BIllet" + ConsoleColors.RESET + "\n"));
        String formatDemandeur = formatUsager(billetDTO.getDemandeur());
        sb.append(formatDemandeur);
        sb.append(String.format("\n"));

        sb.append(String.format(ConsoleColors.BLUE_BOLD + "Personne en charge du billet" + ConsoleColors.RESET + "\n"));
        String formatPersonneEnCharger;
        if (billetDTO.getPersonneEnCharger() != null) {
            formatPersonneEnCharger = formatUsager(billetDTO.getPersonneEnCharger());
            sb.append(formatPersonneEnCharger);
        }
        sb.append(String.format("\n"));

        String formatHistoriqueBillets = formatHistorique(billetDTO.getHistoriqueBillets());
        sb.append(formatHistoriqueBillets);
        sb.append(String.format("\n"));




        return sb.toString();
    }

    private  static String formatUsager(UsagerDTO usagerDTO) {
        StringBuilder sb = new StringBuilder();
        int usagerIdtextLength = 25;
        int usagerNomtextLength = 25;
        int usagerPrenomtextLength = 25;
        int usagerEmailtextLength = 25;
        int usagerDateCreationtextLength = 25;

        usagerIdtextLength = Math.max(usagerIdtextLength, String.valueOf(usagerDTO.getId()).length() + 5);
        usagerNomtextLength = Math.max(usagerNomtextLength, usagerDTO.getNom().length() + 5);
        usagerPrenomtextLength = Math.max(usagerPrenomtextLength, usagerDTO.getPrenom().length() + 5);
        usagerEmailtextLength = Math.max(usagerEmailtextLength, usagerDTO.getEmail().length() + 5);
        usagerDateCreationtextLength = Math.max(usagerDateCreationtextLength, usagerDTO.getDateCreation().toString().length() + 5);

        int totalCharWidth = usagerIdtextLength + usagerNomtextLength + usagerPrenomtextLength +
                usagerEmailtextLength + usagerDateCreationtextLength + 25;

        sb.append(String.format("%-" + usagerIdtextLength + "s\t", "Id"));
        sb.append(String.format("%-" + usagerNomtextLength + "s\t", "Nom"));
        sb.append(String.format("%-" + usagerPrenomtextLength + "s\t", "Prenom"));
        sb.append(String.format("%-" + usagerEmailtextLength + "s\t", "Email"));
        sb.append(String.format("%-" + usagerDateCreationtextLength + "s\t", "Date creation"));
        sb.append(String.format("\n"));

        sb.append(String.join("", Collections.nCopies(totalCharWidth,"-")) + "\n");

        sb.append(String.format("%-" + usagerIdtextLength + "s\t", usagerDTO.getId()));
        sb.append(String.format("%-" + usagerNomtextLength + "s\t", usagerDTO.getNom()));
        sb.append(String.format("%-" + usagerPrenomtextLength + "s\t", usagerDTO.getPrenom()));
        sb.append(String.format("%-" + usagerEmailtextLength + "s\t", usagerDTO.getEmail()));
        sb.append(String.format("%-" + usagerDateCreationtextLength + "s\t", usagerDTO.getDateCreation().toString()));
        sb.append(String.format("\n"));

        return sb.toString();

    }

    private static String formatProjet(ProjetDTO projetDTO) {
        StringBuilder sb = new StringBuilder();
        int projetIdtextLength = 25;
        int projetNomtextLength = 25;
        int projetDescriptiontextLength = 25;
        int projetDateCreationtextLength = 25;
        int projetNumberOfUserstextLength = 25;

        projetIdtextLength = Math.max(projetIdtextLength, String.valueOf(projetDTO.getId()).length() + 5);
        projetNomtextLength = Math.max(projetNomtextLength, projetDTO.getNom().length() + 5);
        projetDescriptiontextLength = Math.max(projetDescriptiontextLength, projetDTO.getDescription().length() + 5);
        projetDateCreationtextLength = Math.max(projetDateCreationtextLength, projetDTO.getDateCreation().toString().length() + 5);
        if(projetDTO.getListUsager() != null)
            projetNumberOfUserstextLength = Math.max(projetNumberOfUserstextLength, String.valueOf(projetDTO.getListUsager().size()).length() + 5);

        int totalCharWidth = projetIdtextLength + projetNomtextLength + projetDescriptiontextLength +
                projetDateCreationtextLength + projetNumberOfUserstextLength + 25;

        sb.append(String.format(ConsoleColors.BLUE_BOLD + "Projet" + ConsoleColors.RESET + "\n"));

        sb.append(String.format("%-" + projetIdtextLength + "s\t", "Id"));
        sb.append(String.format("%-" + projetNomtextLength + "s\t", "Nom"));
        sb.append(String.format("%-" + projetDescriptiontextLength + "s\t", "Description"));
        sb.append(String.format("%-" + projetDateCreationtextLength + "s\t", "Date creation"));
        sb.append(String.format("%-" + projetNumberOfUserstextLength + "s\t", "Nombre d'utilisateurs"));
        sb.append(String.format("\n"));

        sb.append(String.join("", Collections.nCopies(totalCharWidth,"-")) + "\n");

        sb.append(String.format("%-" + projetIdtextLength + "s\t", projetDTO.getId()));
        sb.append(String.format("%-" + projetNomtextLength + "s\t", projetDTO.getNom()));
        sb.append(String.format("%-" + projetDescriptiontextLength + "s\t", projetDTO.getDescription()));
        sb.append(String.format("%-" + projetDateCreationtextLength + "s\t", projetDTO.getDateCreation().toString()));
        if (projetDTO.getListUsager() != null)
            sb.append(String.format("%-" + projetNumberOfUserstextLength + "s\t", projetDTO.getListUsager().size()));
        else
            sb.append(String.format("%-" + projetNumberOfUserstextLength + "s\t", ""));

        sb.append(String.format("\n"));

        return sb.toString();
    }

    private static String formatHistorique (List<HistoriqueBillet> listHistorique) {
        StringBuilder sb = new StringBuilder();
        int historiqueStatustextLength = 25;
        int historiqueUsagertextLength = 25;
        int historiqueCommentairetextLength = 25;
        int historiqueDatetextLength = 25;

        for (HistoriqueBillet historiqueBillet : listHistorique) {
            historiqueStatustextLength = Math.max(historiqueStatustextLength, historiqueBillet.getStateBillet().getCurrentState().toString().length() + 5);
            historiqueUsagertextLength = Math.max(historiqueUsagertextLength, historiqueBillet.getUsager().getEmail().length() + 5);
            historiqueCommentairetextLength = Math.max(historiqueCommentairetextLength, historiqueBillet.getCommentaire().length() + 5);
            historiqueDatetextLength = Math.max(historiqueDatetextLength, historiqueBillet.getDate().toString().length() + 5);
        }

        int totalCharWidth = historiqueStatustextLength + historiqueUsagertextLength + historiqueCommentairetextLength + historiqueDatetextLength + 25;

        sb.append(String.format(ConsoleColors.BLUE_BOLD + "Detail Historique du billet" + ConsoleColors.RESET + "\n"));

        sb.append(String.format("%-" + historiqueStatustextLength + "s\t", "Status"));
        sb.append(String.format("%-" + historiqueUsagertextLength + "s\t", "Usager"));
        sb.append(String.format("%-" + historiqueCommentairetextLength + "s\t", "Commentaire"));
        sb.append(String.format("%-" + historiqueDatetextLength + "s\t", "Date"));
        sb.append(String.format("\n"));

        sb.append(String.join("", Collections.nCopies(totalCharWidth,"-")) + "\n");

        Collections.sort(listHistorique, new Comparator<HistoriqueBillet>() {
            @Override
            public int compare(HistoriqueBillet o1, HistoriqueBillet o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });

        for (HistoriqueBillet historiqueBillet : listHistorique) {
            sb.append(String.format("%-" + historiqueStatustextLength + "s\t", historiqueBillet.getStateBillet().getCurrentState().toString()));
            sb.append(String.format("%-" + historiqueUsagertextLength + "s\t", historiqueBillet.getUsager().getEmail()));
            sb.append(String.format("%-" + historiqueCommentairetextLength + "s\t", historiqueBillet.getCommentaire()));
            sb.append(String.format("%-" + historiqueDatetextLength + "s\t", historiqueBillet.getDate().toString()));
            sb.append(String.format("\n"));
        }

        return sb.toString();
    }



}
