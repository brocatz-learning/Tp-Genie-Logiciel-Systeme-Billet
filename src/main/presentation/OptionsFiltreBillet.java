package presentation;

import java.util.Scanner;

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
        System.out.print("Veuillez entrez une date d'ouverture  en format: YYYY-MM-DD ou  yyyy-mm-dd\n");
        String dateOuverture = scanner.nextLine();
        return dateOuverture;
    }

    public static String affichageSousMenuDemandeur() {
        System.out.print("Veuillez entrez l'email du demandeur\n");
        String demandeur = scanner.nextLine();
        return demandeur;
    }

    public static String affichageSousMenuEtat() {
        System.out.print("Veuillez entrez un etat en text plaine\n");
        System.out.println("1 - stateEnAttenteDeploy");
        System.out.println("2 - statefermer");
        System.out.println("3 - stateOuvert");
        System.out.println("4 - stateTravailEnCours");
        System.out.println("5 - stateBloque");
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
