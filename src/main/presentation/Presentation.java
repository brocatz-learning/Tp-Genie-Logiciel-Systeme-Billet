package presentation;

import Coordonnateur.Coordonnateur;
import exception.ProjetNotValidExeception;
import facade.FacadeApplication;
import model.ProjetDTO;
import model.UsagerDTO;
import utile.ConsoleColors;

import java.util.Scanner;

public class Presentation {

    // Ne pas fermer les classe scanner

    private static Scanner scanner = new Scanner(System.in);
    private static FacadeApplication facadeApplication = new FacadeApplication();
    private static Coordonnateur coordonnateur = new Coordonnateur();
    public static void main(String[] args) {

        afficherMenuProgrammePrincipale();
    }

    public static void afficherMenuProgrammePrincipale() {
        int reponse = 0;


        Scanner scanner = new Scanner(System.in);

        while (reponse != -1) {

            System.out.println("Bonjour Bienvenue dans le programme de gestion de billet");
            System.out.println("Veuillez choisir une option dans la liste");
            System.out.println("-----------------------------------");
            System.out.println("1: Creer un compte usager technique");
            System.out.println("2: Assigner un usager technique a un billet");
            System.out.println("3: Creer un projet");
            System.out.println("4: Assigner un billet a usager technique");
            System.out.println("5: Creer un billet");
            System.out.println("0: Quitter le programme");

            if (!scanner.hasNextInt()) {
                System.out.println( ConsoleColors.RED + "\nErreur veuillez entrez une option entre 1 et 5\n" + ConsoleColors.RESET);
                scanner.nextLine();
            } else {
                reponse = scanner.nextInt();
            }

            switch (reponse) {
                case 0: reponse = -1;
                    break;
                case 1:
                    afficherMenuCreationCompteUsager();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }

            // On doit reinitialser la reponse pour le prochain tour
            reponse = 0;

        }



    }


    public static void afficherMenuCreationCompteUsager () {

        System.out.println("Menu creation d'un compte usager technique");
        System.out.println("----------------------------------------------");
        System.out.println("Veuillez entrez le type d'usager technique : \n1 - Client  2 - Programmeur");

        int choixUsagerTechnique = -1;
        while (!ChoixUsagerTechnique.optionsUsagerTechnique.contains(choixUsagerTechnique)) {
            if (!scanner.hasNextInt()) {
                System.out.println( ConsoleColors.RED + "\nErreur veuillez entrez une valeur numeric entre option entre 1 et 2\n" + ConsoleColors.RESET);
                scanner.nextLine();
            } else {
                choixUsagerTechnique = scanner.nextInt();
            }

            if(!ChoixUsagerTechnique.optionsUsagerTechnique.contains(choixUsagerTechnique)) {
                System.out.println( ConsoleColors.RED + "\nErreur veuillez entrez une option entre 1 et 2\n" + ConsoleColors.RESET);
            }
        }

        System.out.println("Veuillez entrez le email de l'usager");
        String email = scanner.next();
        System.out.println("Veuillez entrez le nom de l'usager");
        String nom = scanner.next();
        System.out.println("Veuillez entrez le prenom de l'usager");
        String prenom = scanner.next();
        System.out.println("Veuillez entrez le username de l'usager");
        String username = scanner.next();
        System.out.println("Veuillez entrez le mot de passe de l'usager");
        String password = scanner.next();

        UsagerDTO usagerDTO = new UsagerDTO();
        usagerDTO.setEmail(email);
        usagerDTO.setNom(nom);
        usagerDTO.setPrenom(prenom);
        usagerDTO.setUsername(username);
        usagerDTO.setPassword(password);

        try {
            coordonnateur.createUsager(usagerDTO, choixUsagerTechnique);
            System.out.println(ConsoleColors.GREEN + "L'usager technique a w créé avec succès" + ConsoleColors.RESET);
        } catch (Exception e) {
            System.out.println(ConsoleColors.RED + e.getMessage() + ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED + "L'usager technique n'a pas été créé" + ConsoleColors.RESET);
        }


    }

    public static void afficherMenuCreationProjet() {
        System.out.println("Menu creation d'un projet");
        System.out.println("--------------------------------------");

        System.out.println("Veuillez entrez le nom du projet ");
        String nomProjet = scanner.next();
        System.out.println("Veuillez entrez la description du projet");
        String descriptionProjet = scanner.next();

        try {
            ProjetDTO projetDTO = new ProjetDTO();
            projetDTO.setNom(nomProjet);
            projetDTO.setDescription(descriptionProjet);

            coordonnateur.createProjet(projetDTO);
            System.out.println(ConsoleColors.GREEN + "Le projet a w créé avec succès" + ConsoleColors.RESET);
        } catch (ProjetNotValidExeception e) {
            System.out.println(ConsoleColors.RED + e.getMessage() + ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED + "Le projet n'a pas été créé" + ConsoleColors.RESET);
        }

    }
}
