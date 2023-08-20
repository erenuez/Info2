package Anfaenger.Excpetions;

public class ArrayFehler {
    public static void main(String[] args){
        int field[] = new int[10];
        try{
            for(int j = 0; j <= field.length; j++){
                field[j] = j;
            }
            for(int i : field){
                System.out.print("["+i+"]");
            }
        } catch(Exception e){
            System.out.println("Fehler");
        }
    }
}
