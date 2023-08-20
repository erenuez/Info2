package Anfaenger.Excpetions;

public class IndexException extends Exception{
    public IndexException(String msg){
        super(msg);
    }
    public IndexException(){
        super();
    }
    public IndexException(int min, int max){
        super("Fehler: " + min + "; " + max);
    }
}
