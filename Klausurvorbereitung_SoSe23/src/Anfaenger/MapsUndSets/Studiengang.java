package Anfaenger.MapsUndSets;

import java.util.Comparator;
import java.util.Objects;

public class Studiengang implements Comparable<Studiengang> {
	// Instanzvariablen deklarieren
	private String abschluss;
	private String studiengangsbezeichnung;
	private int semester;

	// Konstruktor
	public Studiengang(String abschluss, String studiengangsbezeichnung, int semester) {
		this.abschluss = abschluss;
		this.studiengangsbezeichnung = studiengangsbezeichnung;
		this.semester = semester;
	}

	// Accessoren (Getter- und Setter-Methoden)
	public String getAbschluss() {
		return abschluss;
	}

	public void setAbschluss(String abschluss) {
		this.abschluss = abschluss;
	}

	public String getStudiengangsbezeichnung() {
		return studiengangsbezeichnung;
	}

	public void setStudiengangsbezeichnung(String studiengangsbezeichnung) {
		this.studiengangsbezeichnung = studiengangsbezeichnung;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	// �berschreiben der toString-Methode
	@Override
	public String toString() {
		return this.abschluss + ";" + this.studiengangsbezeichnung + ";" + this.semester;
	}
	
	// Fuer die Verwendung in HashSets oder HashMaps muessen die Methoden hashCode() 
	// und equals ueberschrieben werden, damit auf Basis der charakteristischen 
	// Eigenschaften der Objekte ein Hashwert gebildet werden kann.
	@Override
	public int hashCode() {
		return Objects.hash(abschluss, semester, studiengangsbezeichnung);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Studiengang other = (Studiengang) obj;
		return Objects.equals(abschluss, other.abschluss) && semester == other.semester
				&& Objects.equals(studiengangsbezeichnung, other.studiengangsbezeichnung);
	}

	// �berschreiben der compareTo(..)-Methode
	// Default-Komparator
	// wird verwendet, wenn die Funktion(Collections.sort(irgendeineListe))
	// aufgerufen wird.
	
	// Objekte der Klasse Studiengang werden nach der Studiengangsbezeichnung
	// alphabetisch aufsteigend sortiert. sollte sich herausstellen, dass die
	// Studiengangsbezeichnungen identisch sind, werden die Objekte nach der
	// Abschlussart aufsteigend sortiert. Sollten nun aber die
	// Studiengangsbezeichnung und die Abschlussart �bereinstimmen, ist die
	// Anzahl der Fachsemester das letzte Sortierkriterium. Werden Objekte nach
	// dem Fachsemestern sortiert, so ist die ebenfalls in aufsteigender
	// Reihenfolge realisiert.
	@Override
	public int compareTo(Studiengang stud) {
		if (this.getStudiengangsbezeichnung().compareTo(stud.getStudiengangsbezeichnung()) == 0)
			if (this.getAbschluss().compareTo(stud.getAbschluss()) == 0)
				return this.getSemester() - stud.getSemester();
			else
				return this.getAbschluss().compareTo(stud.getAbschluss());
		else
			return this.getStudiengangsbezeichnung().compareTo(stud.getStudiengangsbezeichnung());
	}

	// Innere Klassen als Komparatoren
	// werden verwendet, wenn z.B. die Funktion
	// (Collections.sort(irgendeineListe, new
	// Studiengang.ComparatorBezeichnungDesc())
	// aufgerufen wird.

	// Objekte der Klasse Studiengang werden nach der Studiengangsbezeichnung
	// alphabetisch absteigend sortiert. sollte sich herausstellen, dass die
	// Studiengangsbezeichnungen identisch sind, werden die Objekte nach der
	// Abschlussart absteigend sortiert. Sollten nun aber die
	// Studiengangsbezeichnung und die Abschlussart �bereinstimmen, ist die
	// Anzahl der Fachsemester das letzte Sortierkriterium. Werden Objekte nach
	// dem Fachsemestern sortiert, so ist die ebenfalls in absteigender
	// Reihenfolge realisiert.
	public static class ComparatorBezeichnungDesc implements Comparator<Studiengang> {
		@Override
		public int compare(Studiengang stud1, Studiengang stud2) {
			if (stud2.getStudiengangsbezeichnung().compareTo(stud1.getStudiengangsbezeichnung()) == 0)
				if (stud2.getAbschluss().compareTo(stud1.getAbschluss()) == 0)
					return stud2.getSemester() - stud1.getSemester();
				else
					return stud2.getAbschluss().compareTo(stud1.getAbschluss());
			else
				return stud2.getStudiengangsbezeichnung().compareTo(stud1.getStudiengangsbezeichnung());
		}
	}

	// Objekte der Klasse Studiengang werden nach der Anzahl der Fachsemester
	// aufsteigend sortiert. Sollte die Anzahl der Semester identisch sein,
	// werden die Objekte dach dem Kriterium Studiengang aufsteigend sortiert.
	// Sollte die Anzahl der Fachsemester und die Studiengangsbezeichnung
	// identisch sein, werden die Objekte nach der Abschlussart aufsteigend
	// sortiert.
	public static class ComparatorSemesterAsc implements Comparator<Studiengang> {
		@Override
		public int compare(Studiengang stud1, Studiengang stud2) {
			if (stud1.getSemester() - stud2.getSemester() == 0)
				if (stud1.getStudiengangsbezeichnung().compareTo(stud2.getStudiengangsbezeichnung()) == 0)
					return stud1.getAbschluss().compareTo(stud2.getAbschluss());
				else
					return stud1.getStudiengangsbezeichnung().compareTo(stud2.getStudiengangsbezeichnung());
			else
				return stud1.getSemester() - stud2.getSemester();
		}
	}

	// Objekte der Klasse Studiengang werden nach der Anzahl der Fachsemester
	// absteigend sortiert. Sollte die Anzahl der Semester identisch sein,
	// werden die Objekte dach dem Kriterium Studiengang absteigend sortiert.
	// Sollte die Anzahl der Fachsemester und die Studiengangsbezeichnung
	// identisch sein, werden die Objekte nach der Abschlussart absteigend
	// sortiert.
	public static class ComparatorSemesterDesc implements Comparator<Studiengang> {
		@Override
		public int compare(Studiengang stud1, Studiengang stud2) {
			if (stud2.getSemester() - stud1.getSemester() == 0)
				if (stud2.getStudiengangsbezeichnung().compareTo(stud1.getStudiengangsbezeichnung()) == 0)
					return stud2.getAbschluss().compareTo(stud1.getAbschluss());
				else
					return stud2.getStudiengangsbezeichnung().compareTo(stud1.getStudiengangsbezeichnung());
			else
				return stud2.getSemester() - stud1.getSemester();
		}
	}

}
