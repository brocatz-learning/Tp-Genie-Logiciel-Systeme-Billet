package facade;

import model.dataModel.Filtre;
import model.dataModel.Gravity;
import model.dto.BilletDTO;
import model.dto.ProjetDTO;
import model.dto.UsagerDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FacadeApplicationTest {

    private static FacadeApplication facadeApplication;

    @BeforeAll
    private static void beforeAll() {
        facadeApplication = new FacadeApplication();

        UsagerDTO usagerDTO = new UsagerDTO();
        usagerDTO.setId(1);
        usagerDTO.setEmail("facade@yahoo.ca");
        usagerDTO.setNom("Dupont");
        usagerDTO.setPrenom("Jean");
        usagerDTO.setUsername("jean");
        usagerDTO.setPassword("azerty");

        facadeApplication.createUsager(usagerDTO, 1);

        ProjetDTO projetDTO = new ProjetDTO();
        projetDTO.setNom("FacadeProject1");
        projetDTO.setDescription("Description1");

        facadeApplication.createProjet(projetDTO);


        BilletDTO billetDTO = new BilletDTO();
        billetDTO.setNote("Facade Affichage");
        billetDTO.setDemandeur(usagerDTO);
        billetDTO.setCategory("Bug");
        billetDTO.setGravity(Gravity.Moyenne);
        billetDTO.setProjet(projetDTO);

        facadeApplication.createBillet(billetDTO);
    }

    @BeforeEach
    private void beforeEach() {
        facadeApplication = new FacadeApplication();
    }

    @Test
    void createCategorie() {
        String categorie = "Gestion";
        assertTrue(facadeApplication.createCategorie(categorie), "La categorie existe deja");
    }

    @Test
    void createNotCategorie() {
        String categorie = "Bug";
        assertFalse(facadeApplication.createCategorie(categorie), "La categorie n'existe pas");
    }

    @Test
    void consulterListeBillet() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = sdf.format(date);
        List<BilletDTO> list = facadeApplication.consulterListeBillet(Filtre.DateOuverture, dateString);
        System.out.println(list);
    }
}