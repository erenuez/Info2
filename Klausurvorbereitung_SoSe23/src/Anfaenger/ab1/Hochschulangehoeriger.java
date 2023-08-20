package Anfaenger.ab1;

public abstract class Hochschulangehoeriger {
    private String name;
    private String vorname;
    private Adresse adresse;
    private String telefonnummer;

    public Hochschulangehoeriger(String name, String vorname, Adresse adresse, String telefonnummer){
        this. name = name;
        this.vorname = vorname;
        this.adresse = adresse;
        this.telefonnummer = telefonnummer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public abstract String toString();
    public abstract void ausgabe();
}
