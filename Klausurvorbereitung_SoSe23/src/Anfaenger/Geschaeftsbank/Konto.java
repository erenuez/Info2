package Anfaenger.Geschaeftsbank;
import java.util.*;

public abstract class Konto {
    String name;
    int kontonummer = 0;
    double guthabenzinssatz;
    double kontostand;
    static HashMap<Integer, String> liste = new HashMap<>();


    public Konto(String name, double guthabenzinssatz, double kontostand) {
        this.kontonummer++;
        liste.put(kontonummer, name);
        this.guthabenzinssatz = guthabenzinssatz;
        this.kontostand = kontostand;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKontonummer() {
        return kontonummer;
    }

    public double getGuthabenzinssatz() {
        return guthabenzinssatz;
    }

    public void setGuthabenzinssatz(double guthabenzinssatz) {
        this.guthabenzinssatz = guthabenzinssatz;
    }

    public double getKontostand() {
        return kontostand;
    }

    public void setKontostand(double kontostand) {
        this.kontostand = kontostand;
    }

    @Override
    public String toString(){
        return "Konto{" +
                "name='" + name + '\'' +
                ", kontonummer=" + kontonummer +
                ", guthabenzinssatz=" + guthabenzinssatz +
                ", kontostand=" + kontostand +
                '}';
    }

    public static class CompKontoNrDesc implements Comparator<Konto>{
        @Override
        public int compare(Konto konto1, Konto konto2){
            return Integer.compare((int) konto2.getKontonummer(), (int) konto1.getKontonummer());
        }
    }

    public static class CompKontoInhaberAsc implements Comparator<Konto>{
        @Override
        public int compare(Konto konto1, Konto konto2){
            return konto1.getName().compareTo(konto2.getName());
        }
    }

    public static class CompKontostandNameAsc implements Comparator<Konto>{
        @Override
        public int compare(Konto konto1, Konto konto2){
            double kontostandVergleich = Double.compare(konto1.getKontostand(), konto2.getKontostand());

            if (kontostandVergleich == 0)
                return konto1.getName().compareTo(konto2.getName());

            return (int) kontostandVergleich;
        }
    }

    public class ComparatorKontoKontonummerDesc implements Comparator<Konto>{
        @Override
        public int compare(Konto konto1, Konto konto2){
            return Integer.compare(konto2.getKontonummer(), konto1.getKontonummer());
        }
    }

    public class CompKontoInhaberDesc implements Comparator<Konto>{
        @Override
        public int compare(Konto konto1, Konto konto2){
            return konto2.getName().compareTo(konto1.getName());
        }
    }

    public static class CompKontostandAsc implements Comparator<Konto>{
        @Override
        public int compare(Konto konto1, Konto konto2){
            double kontostandVergleich = Double.compare(konto1.getKontostand(), konto2.getKontostand());

            if (kontostandVergleich == 0)
                return konto1.getName().compareTo(konto2.getName());

            return (int) kontostandVergleich;
        }
    }

    public class CompKontostandDesc implements Comparator<Konto>{
        @Override
        public int compare(Konto konto1, Konto konto2){
            double kontostandVergleich = Double.compare(konto2.getKontostand(), konto1.getKontostand());

            if (kontostandVergleich == 0)
                return konto2.getName().compareTo(konto1.getName());

            return (int) kontostandVergleich;
        }
    }
}

class Girokonto extends Konto implements Methoden {
    double kreditlimit;
    double ueberziehungszinssatz;

    public Girokonto (String name, double guthabenzinssatz, double kontostand, double kreditlimit, double ueberziehungszinssatz){
        super(name, guthabenzinssatz, kontostand);
        this.kreditlimit = kreditlimit;
        this. ueberziehungszinssatz = ueberziehungszinssatz;
    }

    public double getKreditlimit() {
        return kreditlimit;
    }

    public void setKreditlimit(double kreditlimit) {
        this.kreditlimit = kreditlimit;
    }

    public double getUeberziehungszinssatz() {
        return ueberziehungszinssatz;
    }

    public void setUeberziehungszinssatz(double ueberziehungszinssatz) {
        this.ueberziehungszinssatz = ueberziehungszinssatz;
    }

    public void einzahlen (double betrag){
        kontostand += betrag;
        System.out.println("Sie haben "+betrag+" eingezahlt. \nIhr Kontostand beträgt nun: "+kontostand);
    }

    public void auszahlen (double betrag){
        kontostand -= betrag;
        System.out.println("Sie haben "+betrag+" ausgezahlt. \nIhr Kontostand beträgt nun: "+kontostand);
    }

    @Override
    public String toString() {
        return "Girokonto{" +
                "kreditlimit=" + kreditlimit +
                ", ueberziehungszinssatz=" + ueberziehungszinssatz +
                "} " + super.toString();
    }
}

abstract class Geldanlage extends Konto {
    int laufzeit;

    public Geldanlage(String name, double guthabenzinssatz, double kontostand, int laufzeit) {
        super(name, guthabenzinssatz, kontostand);
        this.laufzeit = laufzeit;
    }

    public int getLaufzeit() {
        return laufzeit;
    }

    public void setLaufzeit(int laufzeit) {
        this.laufzeit = laufzeit;
    }

    @Override
    public String toString() {
        return "Geldanlage{" +
                "laufzeit=" + laufzeit +
                "} " + super.toString();
    }
}

class Termingeld extends Geldanlage implements Methoden{
    double mindestanlagebetrag;

    public Termingeld(String name, double guthabenzinssatz, double kontostand, int laufzeit, double mindestanlagebetrag){
        super(name, guthabenzinssatz, kontostand,laufzeit);
        this.mindestanlagebetrag = mindestanlagebetrag;
    }

    public double getMindestanlagebetrag() {
        return mindestanlagebetrag;
    }

    public void setMindestanlagebetrag(double mindestanlagebetrag) {
        this.mindestanlagebetrag = mindestanlagebetrag;
    }

    public void einzahlen (double betrag){
        kontostand += betrag;
        System.out.println("Sie haben "+betrag+" eingezahlt. \nIhr Kontostand beträgt nun: "+kontostand);
    }

    public void auszahlen (double betrag){
        kontostand -= betrag;
        System.out.println("Sie haben "+betrag+" ausgezahlt. \nIhr Kontostand beträgt nun: "+kontostand);
    }
    @Override
    public String toString() {
        return "Termingeldkonto{" +
                "mindestanlagebetrag=" + mindestanlagebetrag +
                "} " + super.toString();
    }
}

class Sparplankonto extends Geldanlage implements Methoden{
    double mtlSparrate;

    public Sparplankonto(String name, double guthabenzinssatz, double kontostand, int laufzeit, double mtlSparrate){
        super(name, guthabenzinssatz, kontostand,laufzeit);
        this.mtlSparrate = mtlSparrate;
    }

    public double getMtlSparrate() {
        return mtlSparrate;
    }

    public void setMtlSparrate(double mtlSparrate) {
        this.mtlSparrate = mtlSparrate;
    }

    public void einzahlen (double betrag){
        kontostand += betrag;
        System.out.println("Sie haben "+betrag+" eingezahlt. \nIhr Kontostand beträgt nun: "+kontostand);
    }

    public void auszahlen (double betrag){
        kontostand -= betrag;
        System.out.println("Sie haben "+betrag+" ausgezahlt. \nIhr Kontostand beträgt nun: "+kontostand);
    }

    @Override
    public String toString() {
        return "Sparplankonto{" +
                "mtlSparrate=" + mtlSparrate +
                "} " + super.toString();
    }
}