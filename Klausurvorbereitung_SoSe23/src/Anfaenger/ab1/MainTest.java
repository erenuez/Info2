package Anfaenger.ab1;

public class MainTest {

	public static void main(String[] args) {
		Adresse adresseSascha = new Adresse("Am Hundebach", "7", 32049, "Herford");
		Adresse adresseAlexander = new Adresse("Bonzenweg", "99a", 40233, "Duesseldorf");
		Adresse adresseHannes = new Adresse("Margaretenweg", "69", 33647, "Bielefeld");
		
		Hochschulangehoeriger sascha = new Mitarbeiter("Leonardo", "Sascha",adresseSascha,"05221-12014","B 411","0521-106-67394");
		Hochschulangehoeriger alexander = new Professor("Förster", "Alexander", adresseAlexander,"0211-1207614","B 410","0521-106-67394","Informatik");
		Hochschulangehoeriger hannes = new Student("Schreck", "Hannes",adresseHannes,"0521-1200714","Wirtschaftsinformatik",125698);
		
		/*
		 * Speichern der Objekte in einem Array mit fester Anzahl an Feldern
		 */
		Hochschulangehoeriger[] liste = {sascha,alexander,hannes};
		
		for(int i = 0 ; i < liste.length ; i++){
//			System.out.println(liste[i]);
			System.out.println();
			liste[i].ausgabe();
		}
	}
}
