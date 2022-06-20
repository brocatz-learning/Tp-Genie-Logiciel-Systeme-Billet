package Coordonnateur;

import exception.*;
import model.dataModel.Billet;
import model.dataModel.Gravity;
import model.dataModel.Projet;
import model.dataModel.Usager;
import model.dto.BilletDTO;
import model.dto.ProjetDTO;
import model.dto.UsagerDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import presentation.formattage.FormatBilletDTO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class CoordonnateurTest {

    private static Coordonnateur coordonnateur;

    @BeforeAll
    static void beforeAll() throws Exception {
        coordonnateur = new Coordonnateur();

        ProjetDTO projetDTO = new ProjetDTO();
        projetDTO.setNom("Projet6");
        projetDTO.setDescription("Description1");

        UsagerDTO usagerDTO = new UsagerDTO();
        usagerDTO.setId(1);
        usagerDTO.setEmail("maxii@gmail.com" );
        usagerDTO.setNom("Maxi");
        usagerDTO.setPrenom("James");
        usagerDTO.setUsername("jmaxi");
        usagerDTO.setPassword("12345678");
        usagerDTO.setDateCreation(new Date());

        UsagerDTO usagerDTO2 = new UsagerDTO();
        usagerDTO2.setId(2);
        usagerDTO2.setEmail("yoyo@gmail.com" );
        usagerDTO2.setNom("Yoyo");
        usagerDTO2.setPrenom("Yoyo");
        usagerDTO2.setUsername("yoyo");
        usagerDTO2.setPassword("12345678");
        usagerDTO2.setDateCreation(new Date());



        BilletDTO billetDTO = new BilletDTO();
        billetDTO.setNote("Probleme d'affichage");
        billetDTO.setDemandeur(usagerDTO);
        billetDTO.setPersonneEnCharger(usagerDTO2);
        billetDTO.setCategory("Bug");
        billetDTO.setGravity(Gravity.Moyenne);
        billetDTO.setProjet(projetDTO);
        billetDTO.setDateCreation(new Date());

        coordonnateur.createUsager(usagerDTO, 1);
        coordonnateur.createUsager(usagerDTO2, 2);
        coordonnateur.createProjet(projetDTO);


        coordonnateur.createAssignationProjet(projetDTO.getNom(), usagerDTO.getEmail());
        for (int i = 0; i < 10; i++) {
            coordonnateur.createBillet(billetDTO);
        }
        coordonnateur.createBillet(billetDTO);


        coordonnateur.updateEtatBillet(1,3,usagerDTO.getEmail(),"Allo");
        Thread.sleep(3000);
        coordonnateur.updateEtatBillet(1,2,usagerDTO.getEmail(),"YaYA");


    }

    @Test
    void testcreateUsagerInvalidEmail() {
        UsagerDTO usagerDTO = new UsagerDTO();
        usagerDTO.setId(1);
        usagerDTO.setEmail("her.sdss");
        usagerDTO.setNom("Maxi");
        usagerDTO.setPrenom("James");
        usagerDTO.setUsername("jmaxi");
        usagerDTO.setPassword("12345678");
        usagerDTO.setDateCreation(new Date());

        assertThrows(UserNotVaildExeption.class, () -> {
            coordonnateur.createUsager(usagerDTO, 1);
        });
    }

//    @Test
//    void testcreateUsagerEmailValid() {
//        UsagerDTO usagerDTO = new UsagerDTO();
//        usagerDTO.setId(1);
//        usagerDTO.setEmail("adfs@gmail.com");
//        usagerDTO.setNom("Maxi");
//        usagerDTO.setPrenom("James");
//        usagerDTO.setUsername("jmaxi");
//        usagerDTO.setPassword("12345678");
//        usagerDTO.setDateCreation(new Date());
//
//
//    }

    @Test
    void testCreateUsagerDuplicateEmail() {
        UsagerDTO usagerDTO = new UsagerDTO();
        usagerDTO.setId(1);
        usagerDTO.setEmail("super@gmail.com");
        usagerDTO.setNom("Maxi");
        usagerDTO.setPrenom("James");
        usagerDTO.setUsername("jmaxi");
        usagerDTO.setPassword("12345678");

        UsagerDTO usagerDTO2 = new UsagerDTO();
        usagerDTO2.setId(2);
        usagerDTO2.setEmail("super@Gmail.com");
        usagerDTO2.setNom("Jaque");
        usagerDTO2.setPrenom("Donovan");
        usagerDTO2.setUsername("jDonovan");
        usagerDTO2.setPassword("12345678");

        UserNotVaildExeption userNotVaildExeption = assertThrows(UserNotVaildExeption.class, () -> {
            coordonnateur.createUsager(usagerDTO, 1);
            coordonnateur.createUsager(usagerDTO2, 1);
        });

        System.out.println(userNotVaildExeption.getMessage());

    }

    @Test
    void testProjetNotValid() {
        assertThrows(ProjetNotValidExeception.class, () -> {
            ProjetDTO projetDTO = new ProjetDTO();
            projetDTO.setNom("");
            projetDTO.setDescription("");
            coordonnateur.createProjet(projetDTO);
        });
    }

    @Test
    void testProjetDuplicate() {
        ProjetDTO projetDTO = new ProjetDTO();
        projetDTO.setNom("Projet1");
        projetDTO.setDescription("Description1");
        ProjetDTO projetDTO2 = new ProjetDTO();
        projetDTO2.setNom("Projet1");
        projetDTO2.setDescription("Description1");

        assertThrows(ProjetNotValidExeception.class, () -> {
            coordonnateur.createProjet(projetDTO);
            coordonnateur.createProjet(projetDTO2);
        });

    }

    @Test
    void testBilletNotCreatable () {
        Billet billet1 = new Billet("Probleme d'affichage", new Usager(), new Usager(), "Bug", Gravity.Moyenne, new Projet("Projet1", "Description1"));
        BilletDTO billetDTO1 = new BilletDTO();
        billetDTO1.setNote("Probleme d'affichage");
        billetDTO1.setPersonneEnCharger(new UsagerDTO());
        billetDTO1.setDemandeur(new UsagerDTO());
        billetDTO1.setCategory("Bug");
        billetDTO1.setGravity(Gravity.Moyenne);
        billetDTO1.setProjet(new ProjetDTO());

        Exception exception = assertThrows(Exception.class, () ->{
            coordonnateur.createBillet(billetDTO1);
        });

        System.out.println(exception.getMessage());

    }

    @Test
    void createCategorie() {
        String categorie = "Gestion";

        assertDoesNotThrow(() -> {
            coordonnateur.createCategorie(categorie);
        });
    }

    @Test
    void createCategorieExeception() {
        String categorie = "Bug";

        assertThrows(CategoryAlreadyExistExeception.class, () -> {
                coordonnateur.createCategorie(categorie);
        });
    }



    @Test
    void createBillet() {

        ProjetDTO projetDTO = new ProjetDTO();
        projetDTO.setNom("Projet5");
        projetDTO.setDescription("Description1");

        UsagerDTO usagerDTO = new UsagerDTO();
        usagerDTO.setId(1);
        usagerDTO.setEmail("maxi@gmail.com" );
        usagerDTO.setNom("Maxi");
        usagerDTO.setPrenom("James");
        usagerDTO.setUsername("jmaxi");
        usagerDTO.setPassword("12345678");


        BilletDTO billetDTO = new BilletDTO();
        billetDTO.setNote("Probleme d'affichage");
        billetDTO.setDemandeur(usagerDTO);
        billetDTO.setPersonneEnCharger(usagerDTO);
        billetDTO.setCategory("Bug");
        billetDTO.setGravity(Gravity.Moyenne);
        billetDTO.setProjet(projetDTO);



        assertDoesNotThrow(() -> {
            coordonnateur.createUsager(usagerDTO, 1);
            coordonnateur.createProjet(projetDTO);
            coordonnateur.createBillet(billetDTO);
        });

    }


    @Test
    void consulterListeBillet() throws FiltreNotValidException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String dateString = sdf.format(date);
        List<BilletDTO> list =
                coordonnateur.consulterListeBillet(dateString,1);
        list.forEach(billetDTO -> {
            System.out.println(billetDTO);
        });
    }

    @Test
    void createAssignationProjet() throws BilletNotExistException, AssignationBIlletException, UserNotVaildExeption, FiltreNotValidException {

        int idBillet = 1;
        String email = "yoyo@gmail.com";
        assertDoesNotThrow(() -> {
            coordonnateur.createAssignationBillet(idBillet, email);
        });

        Date date = new Date();
        String dateString = new SimpleDateFormat("yyyy-MM-dd").format(date);
        coordonnateur.consulterListeBillet(dateString,1).forEach(billetDTO -> {
            System.out.println(billetDTO);
        });

    }

    @Test
    void updateEtatBilletOuvertAOuvert() {
        assertThrows(Exception.class, () -> {
            coordonnateur.updateEtatBillet(1, 1,"yoyo@gmail.com", "Probleme résolu");
        });
    }

    @Test
    void updateEtatBilletOvertAAutre()  {
        assertDoesNotThrow(() -> {
            coordonnateur.updateEtatBillet(1, 2,"yoyo@gmail.com", "Probleme résolu");
        });
   }

    @Test
    void testConsulterListeBilletParID() throws BilletNotExistException {

       BilletDTO billetDTO = coordonnateur.consulterDetailBilletParId(1);
       if (billetDTO != null) {
           System.out.println(FormatBilletDTO.getBilletDetails(billetDTO));
       }
       assertNotNull(billetDTO);
    }


}