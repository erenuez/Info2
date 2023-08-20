package Anfaenger.ab1;

import java.util.HashMap;
import java.util.Map;

public class Student extends Hochschulangehoeriger{
    private String studiengang;
    private int matrikelnummer;
    private Map<String, String> telefonnummern;

    public Student(String name, String vorname, Adresse adresse, String telefonnummer, String studiengang, int matrikelnummer){
        super(name, vorname, adresse, telefonnummer);
        this.studiengang = studiengang;
        this.matrikelnummer = matrikelnummer;
        this.telefonnummern = new HashMap<>();
        addTelefonnummer("Standard", telefonnummer);
    }

    public String getStudiengang() {
        return studiengang;
    }

    public void setStudiengang(String studiengang) {
        this.studiengang = studiengang;
    }

    public int getMatrikelnummer() {
        return matrikelnummer;
    }

    public void setMatrikelnummer(int matrikelnummer) {
        this.matrikelnummer = matrikelnummer;
    }

    public void addTelefonnummer(String kennzeichnung, String telefonnummer) {
        telefonnummern.put(kennzeichnung, telefonnummer);
    }

    public void removeTelefonnummer(String kennzeichnung) {
        telefonnummern.remove(kennzeichnung);
    }

    public String getTelefonnummer(String kennzeichnung){
        return telefonnummern.get(kennzeichnung);
    }

    @Override
    public String toString(){
        StringBuilder telefonnummernString = new StringBuilder();
        for (Map.Entry<String, String> entry : telefonnummern.entrySet()){
            telefonnummernString.append(entry.getKey()).append(": ").append(entry.getValue()).append(", ");
        }

        return getVorname()+" "+getName()+"\n"+getAdresse().createPrintableData()+"/n"+
                "Telefonnummern: "+telefonnummernString.toString()+"\n"+
                "Matrikelnummer: "+getMatrikelnummer()+"\n"+
                "Studiengang: "+getStudiengang();
    }

    @Override
    public void ausgabe(){
        System.out.println(toString());
    }
}
