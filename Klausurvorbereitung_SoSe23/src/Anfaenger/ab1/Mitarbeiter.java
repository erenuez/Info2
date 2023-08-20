package Anfaenger.ab1;

public class Mitarbeiter extends Hochschulangehoeriger{
    private String buero;
    private String dienstrufnummer;

    public Mitarbeiter(String name, String vorname, Adresse adresse, String telefonnummer, String buero, String dienstrufnummer){
        super(name, vorname, adresse, telefonnummer);
        this.buero = buero;
        this.dienstrufnummer = dienstrufnummer;
    }

    public String getBuero() {
        return buero;
    }

    public void setBuero(String buero) {
        this.buero = buero;
    }

    public String getDienstrufnummer() {
        return dienstrufnummer;
    }

    public void setDienstrufnummer(String dienstrufnummer) {
        this.dienstrufnummer = dienstrufnummer;
    }

    @Override
    public String toString(){
        return getVorname()+" "+getName()+"\n"+getAdresse().createPrintableData()+"/n"+
                "Telefonnummer: "+getTelefonnummer()+"\n"+
                "Büro: "+getBuero()+"\n"+
                "Dienstl. Rufnummer: "+getDienstrufnummer();
    }

    @Override
    public void ausgabe(){
    }
}
