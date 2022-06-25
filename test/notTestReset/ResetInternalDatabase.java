package notTestReset;

import persistence.RegistreBillet;
import persistence.RegistreCategorie;
import persistence.RegistreProjet;
import persistence.RegistreUsager;

public class ResetInternalDatabase {

    public static void resetInternalDataBase () {
        RegistreBillet registreBillet = RegistreBillet.getInstance();
        RegistreCategorie registreCategorie = RegistreCategorie.getInstance();
        RegistreUsager registreUsager = RegistreUsager.getInstance();
        RegistreProjet registreProjet = RegistreProjet.getInstance();

        registreBillet.clear();
        registreCategorie.clear();
        registreUsager.clear();
        registreProjet.clear();
    }
}
