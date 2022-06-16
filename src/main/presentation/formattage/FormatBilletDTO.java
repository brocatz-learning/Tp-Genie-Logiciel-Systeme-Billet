package presentation.formattage;

import model.dto.BilletDTO;

import java.util.Collections;
import java.util.List;

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
}
