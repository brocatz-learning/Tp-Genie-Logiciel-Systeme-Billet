package model;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UsagerDTOTest {

    @Test
    void createUser () {
        UsagerDTO usagerDTO = new UsagerDTO();
        usagerDTO.setId(1);
        usagerDTO.setNom("Maxi");
        usagerDTO.setPrenom("James");
        usagerDTO.setUsername("jmaxi");
        usagerDTO.setPassword("12345678");
        usagerDTO.setEmail("james@sd.qc.ca");
        usagerDTO.setDateCreation( new Date());

        UsagerDTO usagerDTO2 = new UsagerDTO();
        usagerDTO2.setId(1);
        usagerDTO2.setNom("Maxi");
        usagerDTO2.setPrenom("James");
        usagerDTO2.setUsername("jmaxi");
        usagerDTO2.setPassword("12345678");
        usagerDTO2.setEmail("james@sd.qc.ca");
        usagerDTO2.setDateCreation( new Date());


        assertEquals(usagerDTO,usagerDTO2);

    }

}