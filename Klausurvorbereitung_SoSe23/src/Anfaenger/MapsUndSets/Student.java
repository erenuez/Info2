package Anfaenger.MapsUndSets;

import java.util.Comparator;
import java.util.Objects;

public class Student implements Comparable<Student> {
	// Instanzvariablen deklarieren
	private int matrikelnummer;
	private String name;
	private String vorname;
	private Studiengang studiengang;

	// Konstruktor
	public Student(int matrikelnummer, String name, String vorname, Studiengang studiengang) {
		this.matrikelnummer = matrikelnummer;
		this.name = name;
		this.vorname = vorname;
		this.studiengang = studiengang;
	}

	public Student() {
	}

	// Acessoren (Getter- und Setter-Methoden)
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

	public Studiengang getStudiengang() {
		return studiengang;
	}

	public void setStudiengang(Studiengang studiengang) {
		this.studiengang = studiengang;
	}

	public int getMatrikelnummer() {
		return matrikelnummer;
	}

	// �berschreiben der toString-Methode
	@Override
	public String toString() {
		return this.matrikelnummer + ";" + this.name + ";" + this.vorname + ";" + this.studiengang;
	}

	// �berschreiben der compareTo(..)-Methode
	// Default-Komparator
	// wird verwendet, wenn die Funktion(Collections.sort(irgendeineListe)) aufgerufen wird
	@Override
	public int compareTo(Student other) {
		// Objekte der Klasse Student werden nach Matrikelnumer aufsteigend sortiert.
		return this.getMatrikelnummer() - other.getMatrikelnummer();
	}

	// Fuer die Verwendung in HashSets oder HashMaps muessen die Methoden hashCode() 
	// und equals ueberschrieben werden, damit auf Basis der charakteristischen 
	// Eigenschaften der Objekte ein Hashwert gebildet werden kann.
	@Override
	public int hashCode() {
		return Objects.hash(matrikelnummer, name, studiengang, vorname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return matrikelnummer == other.matrikelnummer && Objects.equals(name, other.name)
				&& Objects.equals(studiengang, other.studiengang) && Objects.equals(vorname, other.vorname);
	}

	

	// Innere Klassen als Komparatoren
	// werden verwendet, wenn z.B. die Funktion 
	// (Collections.sort(irgendeineListe, new Student.StudentComparatorMatrikelnummerDesc()) 
	// aufgerufen wird.


	// Objekte der Klasse Student werden nach Matrikelnumer absteigend sortiert.
	public static class ComparatorStudentMatrikelnummerDesc implements Comparator<Student> {
		@Override
		public int compare(Student s1, Student s2) {
			return s2.getMatrikelnummer() - s1.getMatrikelnummer();
		}
	}

	// Objekte der Klasse Student alphabetisch nach Namen aufsteigend sortiert. 
	// Sollte der Name identisch sein, werden die Vornamen der Studierenden verglichen.
	// Wenn die Vornamen nicht identisch sein sollten, werden die Objekte der Klasse
	// Student nach vornamen aufsteigend sortiert.
	// Erst wenn auch die Vornamen identisch sein sollten, werden die Objekte der Klasse
	// Student anhand der Matrikelnummer aufsteigend sortiert.
	public static class ComparatorStudentNameAsc implements Comparator<Student> {
		@Override
		public int compare(Student s1, Student s2) {
			if (s1.getName().compareTo(s2.getName()) == 0)
				if (s1.getVorname().compareTo(s2.getVorname()) == 0)
					return s1.getMatrikelnummer() - s2.getMatrikelnummer();
				else
					return s1.getVorname().compareTo(s2.getVorname());
			else
				return s1.getName().compareTo(s2.getName());
		}
	}

	// Objekte der Klasse Student alphabetisch nach Namen absteigend sortiert. 
	// Sollte der Name identisch sein, werden die Vornamen der Studierenden verglichen.
	// Wenn die Vornamen nicht identisch sein sollten, werden die Objekte der Klasse
	// Student nach vornamen absteigend sortiert.
	// Erst wenn auch die Vornamen identisch sein sollten, werden die Objekte der Klasse
	// Student anhand der Matrikelnummer absteigend sortiert.
	public static class ComparatorStudentNameDesc implements Comparator<Student> {
		@Override
		public int compare(Student s1, Student s2) {
			if (s2.getName().compareTo(s1.getName()) == 0)
				if (s2.getVorname().compareTo(s1.getVorname()) == 0)
					return s2.getMatrikelnummer() - s1.getMatrikelnummer();
				else
					return s2.getVorname().compareTo(s1.getVorname());
			else
				return s2.getName().compareTo(s1.getName());
		}
	}

	// Objekte der Klasse Student werden nach der Studiengangsbezeichnung 
	// aufsteigend sortiert. Sollte die Studiengangsbezeichnung identisch 
	// sein, wird nach dem jeweiligen Abschluss aufsteigend sortiert.
	// Erst wenn Studiengangsbezeichnung und Abschluss �bereinstimmen, werden
	// Objekte der Klasse Student alphabetisch nach Namen aufsteigend sortiert. 
	// Sollte der Name identisch sein, werden die Vornamen der Studierenden verglichen.
	// Wenn die Vornamen nicht identisch sein sollten, werden die Objekte der Klasse
	// Student nach vornamen aufsteigend sortiert.
	// Erst wenn auch die Vornamen identisch sein sollten, werden die Objekte der Klasse
	// Student anhand der Matrikelnummer aufsteigend sortiert.  
	public static class ComparatorStudentStudiengangAsc implements Comparator<Student> {
		@Override
		public int compare(Student s1, Student s2) {
			if (s1.getStudiengang().getStudiengangsbezeichnung().compareTo(s2.getStudiengang().getStudiengangsbezeichnung()) == 0)
				if (s1.getStudiengang().getAbschluss().compareTo(s2.getStudiengang().getAbschluss()) == 0)
					if (s1.getName().compareTo(s2.getName()) == 0)
						if (s1.getVorname().compareTo(s2.getVorname()) == 0)
							return s1.getMatrikelnummer() - s2.getMatrikelnummer();
						else
							return s1.getVorname().compareTo(s2.getVorname());
					else
						return s1.getName().compareTo(s2.getName());
				else
					return s1.getStudiengang().getAbschluss().compareTo(s2.getStudiengang().getAbschluss());
			else
				return s1.getStudiengang().getStudiengangsbezeichnung().compareTo(s2.getStudiengang().getStudiengangsbezeichnung());

		}
	}
	
	// Objekte der Klasse Student werden nach der Studiengangsbezeichnung 
	// absteigend sortiert. Sollte die Studiengangsbezeichnung identisch 
	// sein, wird nach dem jeweiligen Abschluss absteigend sortiert.
	// Erst wenn Studiengangsbezeichnung und Abschluss �bereinstimmen, werden
	// Objekte der Klasse Student alphabetisch nach Namen absteigend sortiert. 
	// Sollte der Name identisch sein, werden die Vornamen der Studierenden verglichen.
	// Wenn die Vornamen nicht identisch sein sollten, werden die Objekte der Klasse
	// Student nach vornamen absteigend sortiert.
	// Erst wenn auch die Vornamen identisch sein sollten, werden die Objekte der Klasse
	// Student anhand der Matrikelnummer absteigend sortiert. 
	public static class ComparatorStudentStudiengangDesc implements Comparator<Student> {
		@Override
		public int compare(Student s1, Student s2) {
			if (s2.getStudiengang().getStudiengangsbezeichnung().compareTo(s1.getStudiengang().getStudiengangsbezeichnung()) == 0)
				if (s2.getStudiengang().getAbschluss().compareTo(s1.getStudiengang().getAbschluss()) == 0)
					if (s2.getName().compareTo(s1.getName()) == 0)
						if (s2.getVorname().compareTo(s1.getVorname()) == 0)
							return s2.getMatrikelnummer() - s1.getMatrikelnummer();
						else
							return s2.getVorname().compareTo(s1.getVorname());
					else
						return s2.getName().compareTo(s1.getName());
				else
					return s2.getStudiengang().getAbschluss().compareTo(s1.getStudiengang().getAbschluss());
			else
				return s2.getStudiengang().getStudiengangsbezeichnung().compareTo(s1.getStudiengang().getStudiengangsbezeichnung());

		}
	}
	
	/* *********************************
	 * *     Sortierm�glichkeiten:     *
	 * *********************************
	 * 
	 * Beim Vergleich der einzelnen Werte kann die Sortierreihenfolge (auf-
	 * oder absteigend) wie folgt beiflusst werden:
	 *
	 * erster �bergabeparameter mit zweitem �bergabeparameter: aufsteigend
	 * zweiter �bergabeparameter mit erstem �bergabeparameter: absteigend
	 * 
	 * Bei ganzzahligen Datentypen:
	 * ===========================
	 * return s1.getArtikelnummer() - s2.getArtikelnummer() -> nach Artikelnummer aufsteigend
	 * return s2.getArtikelnummer() - s1.getArtikelnummer -> nach Artikelnummer absteigend
	 * 
	 * Bei Flie�kommawerten:
	 * =====================
	 * return Double.compare(s1.getPreis(),s2.getPreis()) -> Nach Preis aufsteigend
	 * return Double.compare(s2.getPreis(),s1.getPreis()) -> nach Preis absteigend
	 * return ((Double)s1.getPreis()).compareTo((Double)s2.getPreis()) -> Nach Preis aufsteigend
	 * return ((Double)s2.getPreis()).compareTo((Double)s1.getPreis()) -> nach Preis absteigend
	 * 
	 * Bei Zeichenketten:
	 * ==================
	 * return s1.getArtikelbezeichnung().compareTo(s2.getArtikelbezeichnung()) -> nach Artikelbezeichnung aufsteigend
	 * return s2.getArtikelbezeichnung().compareTo(s1.getArtikelbezeichnung()) -> nach Artikelbezeichnung absteigend
	 * 
	 * Bei Datum:
	 * ==========
	 * return s1.getDate().compareTo(s2.getDate()) -> nach Datum aufsteigend
	 * return s2.getDate().compareTo(s2.getDate()) -> nach Datum absteigend
	 */

}
