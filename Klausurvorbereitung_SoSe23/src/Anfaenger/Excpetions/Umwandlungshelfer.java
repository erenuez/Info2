package Anfaenger.Excpetions;

import java.text.NumberFormat;

public class Umwandlungshelfer {
    public static void main(String[] args){
        String[] werte = {"1256", "7895", "Hallo", "123456789101112", "458I2", "45", "zehn"};
        for(String s : werte){
            System.out.println(zahlUmwandeln(s));
        }
    }
    public static int zahlUmwandeln(String wert){
        try{
            return Integer.parseInt((wert));
        } catch(Exception e){
            return -1;
        }
    }
}
