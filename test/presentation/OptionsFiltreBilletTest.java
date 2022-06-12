package presentation;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class OptionsFiltreBilletTest {

    @Test
    void affichageSousMenuDateOuverture() {
        // Format de la date : yyyyMMdd
        Pattern pattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
        String dateOuverture = "2019-01-01";
        System.out.println("Entrez la date d'ouverture (yyyy-MM-dd) : ");
        assertEquals(true, pattern.matcher(dateOuverture).matches());
    }
    @Test
    void affichageSousMenuDateOuvertureFail() {
        // Format de la date : yyyyMMdd
        Pattern pattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
        String dateOuverture = "342019-01-01";
        System.out.println("Entrez la date d'ouverture (yyyy-MM-dd) : ");
        assertNotEquals(true, pattern.matcher(dateOuverture).matches());
    }
}