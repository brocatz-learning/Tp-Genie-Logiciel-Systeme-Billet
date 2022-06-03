package presentation;

import utile.ConsoleColors;

import java.util.Scanner;

public class Presentation {

    // Ne pas fermer les classe scanner
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

        }



    }


    public static void afficherMenuCreationCompteUsager () {
        System.out.println("Menu creation d'un compte usager technique");
        System.out.println("----------------------------------------------");
        System.out.println("Veuillez entrez le email de l'usager");
        System.out.println("Veuillez entrez le nom de l'usager");
        System.out.println("Veuillez entrez le prenom de l'usager");
        System.out.println("Veuillez entrez le username de l'usager");
        System.out.println("Veuillez entrez le mot de passe de l'usager");

    }

    public static void afficherMenuCreationProjet() {
        System.out.println("Menu creation d'un projet");
        System.out.println("--------------------------------------");
        System.out.println("Veuillez entrez le nom du projet ");
        System.out.println("Veuillez entrez la description du projet");

    }
}
