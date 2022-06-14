package presentation.formattage;

import model.dataModel.Billet;
import model.dataModel.Gravity;
import model.dataModel.Projet;
import model.dataModel.Usager;
import model.dto.BilletDTO;
import model.dto.ProjetDTO;
import model.dto.UsagerDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FormatBilletDTOTest {

    private static List<BilletDTO> billetDTOList;
    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        billetDTOList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            UsagerDTO usagerDTO = new UsagerDTO();
            usagerDTO.setId(i);
            usagerDTO.setEmail("superverylongemailverylongemail@.com:" + i);
            usagerDTO.setNom("Nom" + i);
            usagerDTO.setPrenom("Prenom" + i);
            usagerDTO.setUsername("Username" + i);
            usagerDTO.setPassword("Password" + i);

            ProjetDTO projetDTO = new ProjetDTO();
            projetDTO.setNom("Projet " + i);
            projetDTO.setDescription("Description" + i);

            Billet billet = new Billet();
            billet.getEtatBillet().fermerBillet(new Usager(usagerDTO), "Probleme d'affichage");

            BilletDTO billetDTO = new BilletDTO();
            billetDTO.setDateCreation(new Date());
            billetDTO.setDateAssignation(new Date());
            billetDTO.setId(i);
            billetDTO.setNote("Probleme d'affichage");
            billetDTO.setPersonneEnCharger(usagerDTO);
            billetDTO.setDemandeur(usagerDTO);
            billetDTO.setCategory("Bug");
            billetDTO.setEtatBillet(billet.getEtatBillet());
            billetDTO.setGravity(Gravity.Moyenne);
            billetDTO.setProjet(projetDTO);
            billetDTO.setHistoriqueBillets(billet.getHistoriqueBillets());
            billetDTOList.add(billetDTO);

        }
    }

    @Test
    void testFormatBilletDTO() {
        String format = FormatBilletDTO.formatListBilletDTO(billetDTOList);
        System.out.println(format);
    }



}