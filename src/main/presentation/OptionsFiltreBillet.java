package presentation;

import utile.ConsoleColors;

import java.util.Scanner;
import java.util.regex.Pattern;

public class OptionsFiltreBillet {

    private static Scanner scanner = new Scanner(System.in);

    public static String affichageSousMenuFiltre(int choixUtilisateur) {

        String reponseUtilisateur = null;

        switch (choixUtilisateur) {
            case 1: // DateOuverture
                reponseUtilisateur = affichageSousMenuDateOuverture();
                break;
            case 2: // Demandeur
                reponseUtilisateur = affichageSousMenuDemandeur();
                break;
            case 3: // Etat
                reponseUtilisateur = affichageSousMenuEtat();
                break;
            case 4: // PersonneEnCharge
                reponseUtilisateur = affichageSousMenuPersonneEnCharge();
                break;
            case 5: // Projet
                reponseUtilisateur = affichageSousMenuProjet();
                break;
            case 6: // Category
                reponseUtilisateur = affichageSousMenuCategory();
                break;
            case 7: // Gravity
                reponseUtilisateur = affichageSousMenuGravity();
                break;
            default:
                reponseUtilisateur = "" ;
                break;

    }
        return reponseUtilisateur;
    }

    public static String  affichageSousMenuDateOuverture() {

        // Format de la date : yyyyMMdd
        Pattern pattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
        String dateOuverture = "";
        System.out.println("Entrez la date d'ouverture (yyyy-MM-dd) : ");
        while (!pattern.matcher(dateOuverture).matches()) {
            dateOuverture = scanner.nextLine();
            if (!pattern.matcher(dateOuverture).matches()) {
                System.out.println("Erreur, veuillez entrez la date d'ouverture (yyyy-MM-dd)");
            }
        }

        return dateOuverture;
    }

    public static String affichageSousMenuDemandeur() {
        System.out.print("Veuillez entrez l'email du demandeur\n");
        String demandeur = scanner.nextLine();

        return demandeur;
    }

    public static String affichageSousMenuEtat() {
        System.out.print("Veuillez entrez un" + ConsoleColors.PURPLE_BOLD + " etat en text plaine " + ConsoleColors.RESET +"\n");
        System.out.println("1-" + ConsoleColors.PURPLE_BOLD + " stateEnAttenteDeploy" + ConsoleColors.RESET);
        System.out.println("2-" + ConsoleColors.PURPLE_BOLD + " statefermer" + ConsoleColors.RESET);
        System.out.println("3-" + ConsoleColors.PURPLE_BOLD + " stateOuvert" + ConsoleColors.RESET);
        System.out.println("4-" + ConsoleColors.PURPLE_BOLD + " stateTravailEnCours" + ConsoleColors.RESET);
        System.out.println("5-" + ConsoleColors.PURPLE_BOLD + " stateBloque" + ConsoleColors.RESET);
        String etat = scanner.nextLine();
        return etat;
    }

    public static String affichageSousMenuPersonneEnCharge() {
        System.out.print("Veuillez entrez l'email de personne en charge\n");
        String personneEnCharge = scanner.nextLine();
        return personneEnCharge;
    }

    public static String affichageSousMenuProjet() {
        System.out.print("Veuillez entrez un nom de projet\n");
        String projet = scanner.nextLine();
        return projet;
    }

    public static String affichageSousMenuCategory() {
        System.out.print("Veuillez entrez une categorie\n");
        String category = scanner.nextLine();
        return category;
    }

    public static String affichageSousMenuGravity() {
        System.out.print("Veuillez entrez une gravite en texte plaine: \n");
        System.out.println("1- Faible\n2- Moyenne\n3- Elevee\n");
        System.out.println();
        String gravity = scanner.nextLine();
        return gravity;
    }
}
