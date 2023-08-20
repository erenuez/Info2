package Anfaenger.Persistenz;
import edu.princeton.cs.introcs.StdIn;

import java.io.*;

public class Einsmaleins {
    public static void main(String[] args) throws IOException{
        System.out.println("Gebe den Namen für deine Datei ein: ");
        String filename = StdIn.readLine();
        File file = new File("/Users/erenusenmez/Desktop/"+filename+".txt");
        if(file.exists()){
            System.out.println("Dieser Name ist bereits vergeben, möchten Sie diese Datei überschreiben? j/n");
            String antwort = StdIn.readLine();
            if (antwort.equalsIgnoreCase("nein")) {
                System.out.println("Die Datei wird nicht überschrieben. \nDas Programm wird beendet.");
                System.exit(0);
            }else{
                System.out.println("Die Datei " + filename + " wird nun überschrieben.");
                try (FileWriter writer = new FileWriter("/Users/erenusenmez/Desktop/"+filename+".txt")){
                    for(int i = 1; i <= 10; i++) {
                        int x = 1;
                        for (; x <= 10; x++) {
                            int summe = i * x;
                            writer.write(i + " * " + x + " = " + summe + "\n");
                        }
                    }
                    writer.close();
                    System.out.println("Die Datei wurde erfolgreich erzeugt.");
                }
            }
        }
    }
}
