package Anfaenger.Geschaeftsbank;

//import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
//import java.util.HashMap;
//import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
//import java.util.Set;
//import java.util.TreeMap;
//import java.util.TreeSet;

public class TestGeschaeftsbank {

	public static void main(String[] args) {
		List<Konto> kontoliste = new LinkedList<Konto>();
		kontoliste.add(new Girokonto("Meier",0.5,125.55,-2500.00,12.3));
		kontoliste.add(new Sparplankonto("Kleemann",1.5,600.00,10,150.00));
		kontoliste.add(new Termingeld("Kaufmann",0.9,1025.90,7,125.00));
		kontoliste.add(new Girokonto("Mueller",0.5,49.55,-400.00,12.3));
		kontoliste.add(new Sparplankonto("Hotte",1.5,12600.00,5,200.00));
		kontoliste.add(new Termingeld("Laufmann",0.9,5000.00,7,250.00));
		kontoliste.add(new Girokonto("Drotte",0.5,-12.20,-500.00,12.3));
		kontoliste.add(new Sparplankonto("Aaroon",1.5,250.00,10,25.00));
		kontoliste.add(new Termingeld("Beinke",0.9,4500.00,7,150.00));
		kontoliste.add(new Girokonto("Hartmann",0.5,2269.00,-4500.00,12.3));
		kontoliste.add(new Sparplankonto("Franjo",1.5,69.45,4,15.00));
		kontoliste.add(new Termingeld("Strunk",0.9,6900.00,5,225.00));
		
		ausgabe(kontoliste, "unsortiert");
		
		Collections.sort(kontoliste, new Konto.CompKontoInhaberAsc());
		ausgabe(kontoliste, "Inhaber aufsteigend");
		
		Collections.sort(kontoliste, new Konto.CompKontoNrDesc());
		ausgabe(kontoliste, "Kontonummer absteigend");
		
		Collections.sort(kontoliste, new Konto.CompKontostandAsc());
		ausgabe(kontoliste, "Kontostand aufsteigend");
		
		Collections.sort(kontoliste, new Konto.CompKontostandNameAsc());
		ausgabe(kontoliste, "Kontostand/Name aufsteigend");
		
		// Anonyme Komparatorklasse
		Collections.sort(kontoliste, new Comparator<Konto>() {
			@Override
			public int compare(Konto k1, Konto k2) {
				return k1.getKontonummer() - k2.getKontonummer();
			}		
		});		
		ausgabe(kontoliste, "Kontonummer aufsteigend mit anonymen Comparator");
	}
	
	public static void ausgabe(List<Konto> kontoliste, String titel) {
		System.out.println("--Ausgabe der Konten Sortierreihenfolge: " + titel + " --");
		for(Konto k : kontoliste) {
			System.out.println(k.getKontonummer() + " : " + k.getKontonummer() + " : " + k.getKontostand());
		}
		System.out.println();
	}
	
//	public static TreeMap<Integer, Konto> getTreeMap(List<Konto> kontoliste){
//		TreeMap<Integer, Konto> tm = new TreeMap<Integer, Konto>();
//		for(Konto k : kontoliste)
//			tm.put(k.getKontoNr(),k);
//		return tm;
//	}
//	
//	public static HashMap<Integer, Konto> getHashMap(List<Konto> kontoliste){
//		HashMap<Integer, Konto> hm = new HashMap<Integer, Konto>();
//		for(Konto k : kontoliste)
//			hm.put(k.getKontoNr(),k);
//		return hm;
//	}
//	
//	public static List<Konto> getList(TreeMap<Integer, Konto> tm){
//		return new LinkedList<Konto>(tm.values());
//	}
//	
//	public static LinkedList<Konto> getLinkedList(List<Konto> kliste){
//		return new LinkedList<Konto>(kliste);
//	}
//	
//	public static ArrayList<Konto> getArrayList(List<Konto> kliste){
//		return new ArrayList<Konto>(kliste);
//	}
//	
//	public static Konto[] toArray(TreeMap<Integer, Konto> tm) {
////		List<Konto> ll = new LinkedList<Konto>(tm.values());
////		Konto[] arr = ll.toArray(new Konto[ll.size()]);
////		return arr;
//		return tm.values().toArray(new Konto[tm.size()]);
//	}
//	
//	public static Konto[] toArray (List<Konto> kliste) {
//		return kliste.toArray(new Konto[kliste.size()]);
//	}
//
//	public static HashSet<Konto> getHashSet(List<Konto> kliste){
//		return new HashSet<Konto>(kliste);
//	}
//	
//	public static TreeSet<Konto> getTreeSet(List<Konto> kliste){
//		return new TreeSet<Konto>(kliste);
//	}
}
