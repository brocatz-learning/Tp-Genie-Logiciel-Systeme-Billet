package persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class RegistreCategorie {

    private Set<String> listCategorie;

    private static RegistreCategorie registreCategorie;

    private RegistreCategorie () {
        listCategorie = new TreeSet<String>();
        listCategorie.add("Bug".toLowerCase());
        listCategorie.add("Feature".toLowerCase());
        listCategorie.add("Support".toLowerCase());
    }

    public static RegistreCategorie getInstance () {
        if (registreCategorie == null) {
            registreCategorie = new RegistreCategorie();
        }

        return  RegistreCategorie.registreCategorie;
    }

    public boolean addCategorie(String categorie) {
        return listCategorie.add(categorie.toLowerCase());
    }

    public int getSize() {
        return listCategorie.size();
    }

    public boolean isCategorieInRegistre(String categorie) {
        return listCategorie.contains(categorie.toLowerCase());
    }

    private List<String> getListCategorie() {
        return new ArrayList<String>(listCategorie);
    }

    public void clear() {

        Set<String> setToRemove = new TreeSet<String>();

        for(String categorie : listCategorie) {
            if(!categorie.equals("Bug".toLowerCase()) && !categorie.equals("Feature".toLowerCase()) &&
                    !categorie.equals("Support".toLowerCase())) {
               setToRemove.add(categorie);
            }
        }

        listCategorie.removeAll(setToRemove);
    }
}
