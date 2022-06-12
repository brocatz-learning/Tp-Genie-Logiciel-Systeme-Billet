package model;

import model.state.stateBillet.StateBillet;
import model.state.stateBillet.StateOuvert;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class BilletDTOTest {

    @Test
    void testToString() {


        UsagerDTO usagerDTO = new UsagerDTO();
        usagerDTO.setUsername("username");
        usagerDTO.setPassword("password");
        usagerDTO.setEmail("maxi@gmail.com" );
        usagerDTO.setNom("Maxime");
        usagerDTO.setPrenom("Leblanc");

        UsagerDTO usagerDTO2 = new UsagerDTO();
        usagerDTO2.setUsername("username2");
        usagerDTO2.setPassword("password2");
        usagerDTO2.setEmail("super@gmail.com" );
        usagerDTO2.setNom("Super");
        usagerDTO2.setPrenom("Max");

        BilletDTO billetDTO = new BilletDTO();
        billetDTO.setId(1);
        billetDTO.setNote("note");
        billetDTO.setPersonneEnCharger(usagerDTO);
        billetDTO.setDemandeur(usagerDTO2);
        billetDTO.setGravity(Gravity.Faible);
        billetDTO.setCategory("category");

        ProjetDTO projetDTO = new ProjetDTO();
        projetDTO.setId(1);
        projetDTO.setNom("projet");
        projetDTO.setDescription("description");
       billetDTO.setProjet(projetDTO);
       billetDTO.setDateCreation(new Date());

        Billet billet = new Billet();
        billetDTO.setEtatBillet(billet.getEtatBillet());
        billet.setDateCreationBillet(new Date());


        System.out.println(billetDTO.formatBillet());
        assertTrue(billetDTO.toString().contains("id"));
    }
}