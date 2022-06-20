package Coordonnateur;

import exception.BilletNotCreatableExeception;
import model.dto.BilletDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationBilletTest {

    @Test
    void validationBilletDTO() {
        BilletDTO billetDTO = new BilletDTO();
//        billetDTO.setNote("");

        assertThrows(BilletNotCreatableExeception.class, () -> {
            ValidationBillet.validationBilletDTO(billetDTO);
        });
    }
}