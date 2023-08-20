package Uebung.StadtDAO;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<StadtDAO> staedte = new ArrayList<>();
        staedte.add(new StadtDAO(1, "Berlin"));
        staedte.add(new StadtDAO(2, "Muenchen"));
        staedte.add(new StadtDAO(3, "Hamburg"));
        staedte.add(new StadtDAO(4, "Koeln"));

        staedte.sort(Comparator.comparing(StadtDAO::getName));

        List<StrasseDAO> strassen = new ArrayList<>();
        strassen.add(new StrasseDAO(1, 1, 2, 800.0));
        strassen.add(new StrasseDAO(2, 2, 3, 650.0));
        strassen.add(new StrasseDAO(3, 3, 4, 350.0));
        strassen.add(new StrasseDAO(4, 1, 3, 1000.0));

        Stadt berlin = new Stadt("Berlin");
        Stadt muenchen = new Stadt("Muenchen");
        Stadt hamburg = new Stadt("Hamburg");
        Stadt koeln = new Stadt("Koeln");

        berlin.addAusgehendeStrassen(muenchen, 800.0);
        berlin.addAusgehendeStrassen(hamburg, 1000.0);
        hamburg.addAusgehendeStrassen(berlin, 1000.0);
        hamburg.addAusgehendeStrassen(koeln, 350.0);

        System.out.println(berlin);
        System.out.println(muenchen);
        System.out.println(hamburg);
        System.out.println(koeln);
    }
}
