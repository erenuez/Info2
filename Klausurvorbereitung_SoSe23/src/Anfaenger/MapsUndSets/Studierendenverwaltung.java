package Anfaenger.MapsUndSets;

import java.util.*;

public class Studierendenverwaltung extends Student{
    private TreeMap<Integer, Student> studentenliste;
    private LinkedList<Studiengang> studiengangsliste;

    public Studierendenverwaltung() {
        this.studentenliste = new TreeMap<Integer, Student>();
        this.studiengangsliste = new LinkedList<Studiengang>();
    }

    public void addStudiengang(Studiengang studiengang){
        studiengangsliste.add(studiengang);
    }
    public void removeStudiengang(Studiengang studiengang){
        studiengangsliste.remove(studiengang);
    }
    public void addStudent(Student student) {
        studentenliste.put(student.getMatrikelnummer(), student);
    }
    public void removeStudent(Student student){
        studentenliste.remove(student.getMatrikelnummer(), student);
    }
    public Student getStudent(int matrikelnummer) {
        if (studentenliste.containsKey(matrikelnummer)) {
            return studentenliste.get(matrikelnummer);
        } else {
            return null;
        }
    }
    public Integer[] getStudentenKeys(){
        Integer[] array = new Integer[studentenliste.size()];
        int i = 0;
        for(Map.Entry<Integer, Student> entry : studentenliste.entrySet()){
            array[i] = entry.getKey();
            i++;
        }
        return array;
    }
    public HashSet<Student> getStudentHashSet(){
        HashSet<Student> studentHashSet = new HashSet<>();
        for(Map.Entry<Integer, Student> entry : studentenliste.entrySet()){
            studentHashSet.add(entry.getValue());
        }
        return studentHashSet;
    }
    public HashMap<Integer, Student> getHashMapStudent(){
        HashMap<Integer, Student> studentHashMap = new HashMap<>();
        for(Map.Entry<Integer, Student> entry : studentenliste.entrySet()){
            studentHashMap.put(entry.getKey(), entry.getValue());
        }
        return studentHashMap;
    }
    public TreeSet<Student> getStudentTreeSet(){
        TreeSet<Student> studentTreeSet = new TreeSet<>();
        for(Map.Entry<Integer, Student> entry : studentenliste.entrySet()){
            studentTreeSet.add(entry.getValue());
        }
        return studentTreeSet;
    }
    public TreeMap<Integer, Student> getTreeMapStudent(){
        TreeMap<Integer, Student> studentTreeMap = new TreeMap<>();
        for(Map.Entry<Integer,Student> entry : studentenliste.entrySet()){
            studentTreeMap.put(entry.getKey(), entry.getValue());
        }
        return studentTreeMap;
    }
    public LinkedList<Student> getStudentenValueSet(){
        LinkedList<Student> studentenValueSet = new LinkedList<>();
        for(Map.Entry<Integer,Student> entry : studentenliste.entrySet()){
            studentenValueSet.add(entry.getValue());
        }
        return studentenValueSet;
    }
    public LinkedList<Integer> getStudentenKeySet(){
        LinkedList<Integer> studentenKeySet = new LinkedList<>();
        for(Map.Entry<Integer,Student> entry : studentenliste.entrySet()){
            studentenKeySet.add(entry.getKey());
        }
        return studentenKeySet;
    }
    public LinkedList<Studiengang> getStudiengangliste(){
        LinkedList<Studiengang> studiengangListe = new LinkedList<>();
        for(Studiengang entry: studiengangsliste){
            studiengangListe.add(entry);
        }
        return studiengangListe;
    }
    public void setStudiengangsliste(LinkedList<Studiengang> stdgangliste){
        studiengangsliste = stdgangliste;
    }
    public void setStudentenliste(TreeMap<Integer, Student> studentenliste){
        studentenliste = studentenliste;
    }
    public void printStudentenliste(){
        for(Map.Entry<Integer, Student> entry : studentenliste.entrySet()){
            System.out.println(entry.getValue());
        }
    }
    public void printStudiengaenge(){
        for(Studiengang studiengang : studiengangsliste){
            System.out.println(studiengang);
        }
    }
}
