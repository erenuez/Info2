package Uebung;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMIRechner {
    static JFrame mainWindow = new JFrame("BMI-Rechner");
    static JLabel gewicht = new JLabel("Gewicht:");
    static JLabel groesse = new JLabel("Größe:");
    static JLabel ausgabe = new JLabel("Ausgabe:");
    static JTextField eingabeGewicht = new JTextField("");
    static JTextField eingabeGroesse = new JTextField("");
    static JTextField ausgabeBMI = new JTextField("");
    static JButton button = new JButton("Berechne BMI");

    public static void main(String[] args){
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        eingabeGewicht.setColumns(4);
        eingabeGroesse.setColumns(4);
        ausgabeBMI.setColumns(4);
        ausgabeBMI.setEditable(false);

        FlowLayout flow = new FlowLayout();
        mainWindow.setLayout(flow);

        button.addActionListener( e -> {
            String gewicht = eingabeGewicht.getText();
            double gewichtzahl = Double.valueOf(gewicht);
            String groesse = eingabeGroesse.getText();
            double groessezahl = Double.valueOf(groesse);
            double bmi = gewichtzahl/(groessezahl*2);
            bmi = Math.round(bmi * 100.00)/100.00;
            String bmitext = String.valueOf(bmi);
            ausgabeBMI.setText(bmitext);
        });

        mainWindow.add(gewicht);
        mainWindow.add(eingabeGewicht);
        mainWindow.add(groesse);
        mainWindow.add(eingabeGroesse);
        mainWindow.add(button);
        mainWindow.add(ausgabe);
        mainWindow.add(ausgabeBMI);

        mainWindow.pack();
        mainWindow.setVisible(true);
    }
}
