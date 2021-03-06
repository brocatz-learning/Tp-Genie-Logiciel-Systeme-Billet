package presentation;

import Coordonnateur.Coordonnateur;
import exception.BilletNotCreatableExeception;
import exception.CategoryAlreadyExistExeception;
import exception.ProjetNotAssignableToUserExeception;
import exception.ProjetNotValidExeception;
import model.dataModel.Gravity;
import model.dto.BilletDTO;
import model.dto.ProjetDTO;
import model.dto.UsagerDTO;
import presentation.formattage.FormatBilletDTO;
import utile.ConsoleColors;

import java.util.List;
import java.util.Scanner;

/**
 * Couche presentation pour la gestion du systeme de billet
 *
 * @author Maxi
 */


public class Presentation {

    // Ne pas fermer les classe scanner

    private static Scanner scanner = new Scanner(System.in);
    private static Coordonnateur coordonnateur = new Coordonnateur();
    public static void main(String[] args) {

        afficherMenuProgrammePrincipale();
    }

    public static void afficherMenuProgrammePrincipale() {
        int reponse = 0;


        Scanner scanner = new Scanner(System.in);

        while (reponse != -1) {

            System.out.println("\nBonjour Bienvenue dans le programme de gestion de billet");
            System.out.println("Veuillez choisir une option dans la liste");
            System.out.println("-----------------------------------");
            System.out.println("1: Creer un compte usager technique");
            System.out.println("2: Creer un projet");
            System.out.println("3: Assigner un usager technique a un projet");
            System.out.println("4: Creer une categorie");
            System.out.println("5: Creer un billet");
            System.out.println("6: Assigner un billet a un usager technique");
            System.out.println("7: Changer l'etat d'un billet");
            System.out.println("8: Consulter la liste des billets filtres");
            System.out.println("9: Consulter le detail d'un billet par  id");

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
                    afficherMenuCreationProjet();
                    break;
                case 3:
                    afficherMenuAssignationUsagerTechniqueProjet();
                    break;
                case 4:
                    afficherMenuCreationCategorie();
                    break;
                case 5:
                    afficherMenuCreationBillet();
                    break;
                    case 6:
                        afficherMenuAssignationBillet();
                    break;
                case 7:
                    afficherMenuChangerEtatBillet();
                    break;
                case 8:
                    afficherMenuConsulterListeBillet();
                    break;
                case 9:
                    afficherMenuConsulterDetailBilletParId();
                    break;
                default:
                    System.out.println(ConsoleColors.RED + "\nErreur veuillez entrez une option entre 0 et 9\n"
                            + ConsoleColors.RESET);
            }

            // On doit reinitialser la reponse pour le prochain tour
            // Si l'usager choisi 0 on quitte le programme
            // en assignant la valeur -1 a la variable reponse
            reponse = (reponse == -1) ? -1 : 0; //

        }



    }


    // 1- TODO Completed Menu Creation Compte Usager
    // Completed
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
            System.out.println(ConsoleColors.GREEN + "L'usager technique a w cr???? avec succ??s" + ConsoleColors.RESET);
        } catch (Exception e) {
            System.out.println(ConsoleColors.RED + e.getMessage() + ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED + "L'usager technique n'a pas ??t?? cr????" + ConsoleColors.RESET);
        }


    }

    // 2 TODO Completed Menu Creation Projet
    // Completed
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
            System.out.println(ConsoleColors.GREEN + "Le projet a w cr???? avec succ??s" + ConsoleColors.RESET);
        } catch (ProjetNotValidExeception e) {
            System.out.println(ConsoleColors.RED + e.getMessage() + ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED + "Le projet n'a pas ??t?? cr????" + ConsoleColors.RESET);
        }

    }

    // 3 TODO Completed Menu Assignation Usager Technique Projet
    // 3 Assigner un usager technique a un projet

    public static void afficherMenuAssignationUsagerTechniqueProjet() {

        // On doit verifier que l'usager technique existe et qu'un projet existe

        boolean isAssignationDoable = false;


        System.out.println("Menu assignation d'un usager technique a un projet");
        System.out.println("--------------------------------------");

        System.out.println("Veuillez entrez le nom du projet ");
        String nomProjet = scanner.next();
        System.out.println("Veuillez entrez l'email de l'usager technique");
        String emailUsagerTechique = scanner.next();

        try {
            coordonnateur.createAssignationProjet(nomProjet, emailUsagerTechique);
            System.out.println(ConsoleColors.GREEN + "L'assignation a ete effectue avec succ??s" + ConsoleColors.RESET);
        } catch (ProjetNotAssignableToUserExeception e) {
            System.out.println(ConsoleColors.RED + e.getMessage() + ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED + "L'assignation n'a pas ??t?? effectue" + ConsoleColors.RESET);
        }

    }

    // 4 TODO Completed : Menu Creation Categorie
    // Completed
    public static void afficherMenuCreationCategorie() {
        System.out.println("Menu creation d'une categorie");
        System.out.println("--------------------------------------");

        System.out.println("Veuillez entrez le nom de la nouvelle categorie ");
        String nomCategorie = scanner.next();

        try {
            coordonnateur.createCategorie(nomCategorie);
            System.out.println(ConsoleColors.GREEN + "La categorie " + nomCategorie + "a w cr???? avec succ??s" + ConsoleColors.RESET);
        } catch (CategoryAlreadyExistExeception e) {
            System.out.println(ConsoleColors.RED + e.getMessage() + ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED + "La categorie n'a pas ??t?? cr????" + ConsoleColors.RESET);
        }


    }

    // 5 TODO Completed : Menu Creation Billet

    public static void afficherMenuCreationBillet() {

        // On doit verifier si au moins un usager et ub projet et existe
        boolean isBilletCreatable = true;

        try {
            coordonnateur.verifyBilletCreatable();
        } catch (BilletNotCreatableExeception e) {
            System.out.println(ConsoleColors.RED + e.getMessage() + ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED + "Le billet n'a pas ??t?? cr????" + ConsoleColors.RESET);
            isBilletCreatable = false;
        }

        // Puisqu'il n'y a pas un projet et usager techique, on ne peut pas cr??er un billet
        if (isBilletCreatable == false){
            return;
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////



        System.out.println("Menu creation d'un billet");

        System.out.println("--------------------------------------");

        scanner.nextLine();

        System.out.println("Veuillez entrez la note du billet");
        String note = scanner.nextLine();
        System.out.println("Veuillez l'email du demandeur");
        String emailDemandeur = scanner.nextLine();
//        System.out.println("Veuillez l'email de la personne en charge");
//        String emailEnCharge = scanner.next();
        System.out.println("Veuillez entrez le nom du projet");
        String nomProjet = scanner.nextLine();
        System.out.println("Veuillez entrez le nom de la categorie");
        String nomCategorie = scanner.nextLine();

        int gravity = -1;

        while(!ChoixGravity.optionsGravity.contains(gravity)) {

            System.out.println("Veuillez entrez la gravit?? du billet : \n1 - Faible  2 - Moyen  3 - Fort");
            if (!scanner.hasNextInt()) {
                System.out.println( ConsoleColors.RED + "\nErreur veuillez entrez une valeur numeric entre option entre 1 et 3\n" + ConsoleColors.RESET);
                scanner.nextLine();
            } else {
                gravity = scanner.nextInt();
            }

            if(!ChoixGravity.optionsGravity.contains(gravity)) {
                System.out.println( ConsoleColors.RED + "\nErreur veuillez entrez une option entre 1 et 3\n" + ConsoleColors.RESET);
            }
        }

        try {

            ProjetDTO projetDTO = new ProjetDTO();
            UsagerDTO usagerdemandeur = new UsagerDTO();
//            UsagerDTO usagerenCharge = new UsagerDTO();

            usagerdemandeur.setEmail(emailDemandeur);
//            usagerenCharge.setEmail(emailEnCharge);

            projetDTO.setNom(nomProjet);


            BilletDTO billetDTO = new BilletDTO();
            billetDTO.setNote(note);
//            billetDTO.setPersonneEnCharger(usagerenCharge);
            billetDTO.setDemandeur(usagerdemandeur);
            billetDTO.setProjet(projetDTO);
            billetDTO.setCategory(nomCategorie);
            billetDTO.setGravity(Gravity.fromId(gravity));


            coordonnateur.createBillet(billetDTO);
            int idBillet = coordonnateur.getLastBilletId();
            System.out.println(ConsoleColors.BLUE_BOLD + "L'id du billet est : " + idBillet + ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN + "Le billet a w cr???? avec succ??s" + ConsoleColors.RESET);
        } catch (Exception e) {
            System.out.println(ConsoleColors.RED + e.getMessage() + ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED + "Le billet n'a pas ??t?? cr????" + ConsoleColors.RESET);
        }

    }

    // 6 TODO Completed : Menu Assignation Billet
    public static void afficherMenuAssignationBillet () {
        System.out.println("Menu assignation d'un billet a un usager technique");
        System.out.println("--------------------------------------");

        System.out.println("Veuillez entrez l'id du billet ");

        int idBillet = 0;

        while(!scanner.hasNextInt()) {
            if (!scanner.hasNextInt()) {
                System.out.println( ConsoleColors.RED + "\nErreur veuillez entrez une valeur numeric\n" + ConsoleColors.RESET);
                scanner.nextLine();
            } else {
                idBillet = scanner.nextInt();
            }
        }

        idBillet = scanner.nextInt();


        System.out.println("Veuillez entrez l'email de l'usager technique");
        String emailUsagerTechique = scanner.next();

        try {
            coordonnateur.createAssignationBillet(idBillet, emailUsagerTechique);
            System.out.println(ConsoleColors.GREEN + "L'assignation a ete effectue avec succ??s" + ConsoleColors.RESET);
        } catch (Exception e) {
            System.out.println(ConsoleColors.RED + e.getMessage() + ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED + "L'assignation n'a pas ??t?? effectue" + ConsoleColors.RESET);
        }
    }

    // 7 TODO Completed : Menu Liste Changeer etat Billet
    public static void afficherMenuChangerEtatBillet () {
        System.out.println("Menu changement d'etat d'un billet");
        System.out.println("--------------------------------------");


        System.out.println("Veuillez entrez l'email de l'usager technique");
        String emailUsagerTechique = scanner.next();

        System.out.println("Veuillez entrez la note du billet ");
        String note = scanner.next();

        int idBillet = 0;
        System.out.println("Veuillez entrez l'id du billet ");

        boolean isNumberEntre = false;
        while (isNumberEntre == false) {
            if (!scanner.hasNextInt()) {
                System.out.println( ConsoleColors.RED + "\nErreur veuillez entrez une valeur numeric" + ConsoleColors.RESET);
                scanner.next();
            } else {
                idBillet = scanner.nextInt();
                isNumberEntre = true;
            }
        }

        int choixEtat = -1;

        System.out.println("Veuillez entrez l'etat du billet :");
        System.out.println("1 - Ouvert");
        System.out.println("2 - Travail En cours");
        System.out.println("3 - Bloqu??");
        System.out.println("4 - En attente de deploiement");
        System.out.println("5 - Ferm??");

        while (!ChoixEtat.optionsEtat.contains(choixEtat)) {
            if (!scanner.hasNextInt()) {
                System.out.println( ConsoleColors.RED + "\nErreur veuillez entrez une valeur numeric entre 1 et 5\n" + ConsoleColors.RESET);
                scanner.next();
            } else {
                choixEtat = scanner.nextInt();

                if (!ChoixEtat.optionsEtat.contains(choixEtat)) {
                    System.out.println( ConsoleColors.RED + "\nErreur veuillez entrez une option entre 1 et 5\n" + ConsoleColors.RESET);
                }
            }
        }

        try {
            coordonnateur.updateEtatBillet(idBillet, choixEtat, emailUsagerTechique, note);
            System.out.println(ConsoleColors.GREEN + "L'etat du billet a ete modifie avec succ??s" + ConsoleColors.RESET);
        } catch (Exception e) {
            System.out.println(ConsoleColors.RED + e.getMessage() + ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED + "L'etat du billet n'a pas ??t?? modifie" + ConsoleColors.RESET);
        }


    }

    // 8 TODO Completed : Menu Consulter Liste Billets
    public static void afficherMenuConsulterListeBillet () {
        System.out.println("Menu consulter la liste des billets");
        System.out.println("--------------------------------------");


        System.out.println("Veuillez entrez le filtre souhaiter");
        System.out.println("1 - Date d'ouverture");
        System.out.println("2 - Demandeeur");
        System.out.println("3 - Etat");
        System.out.println("4 - Personne en charge");
        System.out.println("5 - Projet");
        System.out.println("6 - Categorie");
        System.out.println("7 - Gravit??");

        int choix = -1;

        while(!ChoixFiltreBillet.optionsFiltre.contains(choix)) {
            if (!scanner.hasNextInt()) {
                System.out.println( ConsoleColors.RED + "\nErreur veuillez entrez une valeur numeric entre option entre 1 et 7\n" + ConsoleColors.RESET);
                scanner.nextLine();
            } else {
                choix = scanner.nextInt();
            }

            if(!ChoixFiltreBillet.optionsFiltre.contains(choix)) {
                System.out.println( ConsoleColors.RED + "\nErreur veuillez entrez une option entre 1 et 7\n" + ConsoleColors.RESET);
            }
        }

        String optionFiltreValeur = OptionsFiltreBillet.affichageSousMenuFiltre(choix);

        List<BilletDTO> billetList = null;
        try {
             billetList = coordonnateur.consulterListeBillet(optionFiltreValeur, choix);
        } catch (Exception e) {
            System.out.println(ConsoleColors.RED + e.getMessage() + ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED + "La liste des billets n'a pas ??t?? affich??e" + ConsoleColors.RESET);
        }

        if (billetList != null) {
            if (billetList.isEmpty()) {
                System.out.println(ConsoleColors.RED + "Aucun billet n'a ??t?? trouv??" + ConsoleColors.RESET);
            }

            if (billetList.size() > 0) {
                System.out.println(ConsoleColors.GREEN + "Liste des billets" + ConsoleColors.RESET);
                System.out.println("--------------------------------------");
                String listBilletFormatted = FormatBilletDTO.formatListBilletDTO(billetList);
                System.out.println(listBilletFormatted);
            }
        }
    }


    // 9 TODO Completed : Menu Consulter Billet par Id

    public static void afficherMenuConsulterDetailBilletParId () {
        System.out.println("Menu consulter le detail d'un billet par id");
        System.out.println("--------------------------------------");

        System.out.println("Veuillez entrez l'id du billet ");
        int idBilletInt = -1;

        while (!scanner.hasNextInt()) {
            System.out.println( ConsoleColors.RED + "\nErreur veuillez entrez une valeur numeric" + ConsoleColors.RESET);
            scanner.next();
        }

        idBilletInt = scanner.nextInt();

        BilletDTO billetDTO = null;
        try {
            billetDTO = coordonnateur.consulterDetailBilletParId(idBilletInt);
            System.out.println(ConsoleColors.GREEN + "Le detail du billet a ete affiche avec succ??s" + ConsoleColors.RESET);

        } catch (Exception e) {
            System.out.println(ConsoleColors.RED + e.getMessage() + ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED + "Le detail du billet n'a pas ??t?? affich??" + ConsoleColors.RESET);
        }

        if (billetDTO != null) {
            System.out.println(ConsoleColors.GREEN + "Le detail du billet" + ConsoleColors.RESET);
            System.out.println("--------------------------------------");
            String billetFormatted = FormatBilletDTO.getBilletDetails(billetDTO);
            System.out.println(billetFormatted);
        }





    }
}
