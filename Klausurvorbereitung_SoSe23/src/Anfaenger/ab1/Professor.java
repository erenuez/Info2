package Anfaenger.ab1;

public class Professor extends Mitarbeiter{
    private String lehrgebiet;

    public Professor(String name, String vorname, Adresse adresse, String telefonnummer, String buero, String dienstrufnummer, String lehrgebiet){
        super(name, vorname, adresse, telefonnummer, buero, dienstrufnummer);
        this.lehrgebiet = lehrgebiet;
    }

    public String getLehrgebiet() {
        return lehrgebiet;
    }

    public void setLehrgebiet(String lehrgebiet) {
        this.lehrgebiet = lehrgebiet;
    }

    @Override
    public String toString(){
        return getVorname()+" "+getName()+"\n"+getAdresse().createPrintableData()+"/n"+
                "Telefonnummer: "+getTelefonnummer()+"\n"+
                "Büro "+getBuero()+"\n"+
                "Dienstl. Rufnummer:"+getDienstrufnummer()+"\n"+
                "Lehrgebiet: "+getLehrgebiet();
    }
}
