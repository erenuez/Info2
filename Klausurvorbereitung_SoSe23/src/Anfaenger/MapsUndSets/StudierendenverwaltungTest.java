package Anfaenger.MapsUndSets;

import javax.swing.*;

public class StudierendenverwaltungTest {

	public static void main (String[] args){
		Studierendenverwaltung sv = new Studierendenverwaltung();
		loadData(sv);
		sv.printStudiengaenge();
		sv.printStudentenliste();
		Studiengang studiengang = sv.getStudiengang();
		System.out.println(studiengang);
		sv.removeStudiengang(studiengang);
		sv.printStudiengaenge();
		sv.printStudentenliste();
	}
	
	public static void loadData(Studierendenverwaltung sv){
		sv.addStudiengang(new Studiengang("B.Sc.", "Wirtschaftsinformatik", 6));
		sv.addStudiengang(new Studiengang("B.A.", "Betriebswirtschaftslehre", 6));
		sv.addStudiengang(new Studiengang("B.Sc.", "Wirtschaftspsychologie", 6));
		sv.addStudiengang(new Studiengang("B.A.", "International Studies in Management", 6));
		sv.addStudiengang(new Studiengang("LL.B.", "Wirtschaftsrecht", 7));

		sv.addStudent( new Student(123456, "Meier", "Hans", sv.getStudiengangliste().get(0)));
		sv.addStudent( new Student(123440, "Meier", "Hans", sv.getStudiengangliste().get(0)));
		sv.addStudent( new Student(234567, "Mueller", "Hugo", sv.getStudiengangliste().get(1)));
		sv.addStudent( new Student(678912, "Schlau", "Tina", sv.getStudiengangliste().get(2)));
		sv.addStudent( new Student(951357, "Boerg", "Tim", sv.getStudiengangliste().get(3)));
		sv.addStudent( new Student(789123, "Bommel", "Brigitte", sv.getStudiengangliste().get(4)));
		sv.addStudent( new Student(891234, "Steiner", "Linda", sv.getStudiengangliste().get(2)));
		sv.addStudent( new Student(912345, "Mana", "Patrizia", sv.getStudiengangliste().get(1)));
		sv.addStudent( new Student(654321, "Jack", "Thomas", sv.getStudiengangliste().get(1)));
		sv.addStudent( new Student(456789, "Altmann", "Adrian", sv.getStudiengangliste().get(0)));
		sv.addStudent( new Student(654789, "Strunk", "Jette", sv.getStudiengangliste().get(0)));
		sv.addStudent( new Student(345678, "Wirts", "Henning", sv.getStudiengangliste().get(2)));
	}
}
