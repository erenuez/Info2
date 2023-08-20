package Uebung;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Txtdateianalysator3000 {
    static JFrame mainWindow = new JFrame("Textdatei Analysator 3000");
    static JButton button = new JButton("Datei auswählen");
    static JLabel label = new JLabel("Anzahl Textzeilen");
    static JTextField ausgabe = new JTextField("");

    public static void main(String[] args){
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        FlowLayout flow = new FlowLayout();
        mainWindow.setLayout(flow);

        ausgabe.setEditable(false);
        ausgabe.setColumns(5);

        button.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int bilmirem = fileChooser.showOpenDialog(null);

            if(bilmirem == JFileChooser.APPROVE_OPTION){
                File selectedFile = fileChooser.getSelectedFile();
                int zeilenanzahl = 0;
                try(BufferedReader reader = new BufferedReader(new FileReader(selectedFile))){
                    while (reader.readLine() != null){
                        zeilenanzahl++;
                    }
                } catch (IOException a){
                    a.printStackTrace();
                }
                String ausgabewert = String.valueOf(zeilenanzahl);
                ausgabe.setText(ausgabewert);
            }
        });

        mainWindow.add(button);
        mainWindow.add(label);
        mainWindow.add(ausgabe);

        mainWindow.pack();
        mainWindow.setVisible(true);
    }
}
