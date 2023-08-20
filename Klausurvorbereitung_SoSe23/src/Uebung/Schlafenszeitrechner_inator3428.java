package Uebung;

import javax.swing.*;
import java.awt.*;

public class Schlafenszeitrechner_inator3428 {
    static JFrame mainWindow = new JFrame("Schlafenszeitrechner-inator3428");
    static JLabel label1 = new JLabel("Uhrzeit 1:");
    static JLabel label2 = new JLabel("Uhrzeit 2:");
    static JTextField eingabeStd1 = new JTextField("");
    static JTextField eingabeMin1 = new JTextField("");
    static JTextField eingabeStd2 = new JTextField("");
    static JTextField eingabeMin2 = new JTextField("");
    static JLabel labelausgabe = new JLabel("Zeitdifferenz:");
    static JTextField ausgabeStd = new JTextField("");
    static JTextField ausgabeMin = new JTextField("");
    static JButton button = new JButton("Berechne");
    static JLabel trenner1 = new JLabel(":");
    static JLabel trenner2 = new JLabel(":");
    static JLabel trenner3 = new JLabel(":");



    public static void main(String[] args){
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        FlowLayout flow = new FlowLayout();
        mainWindow.setLayout(flow);

        ausgabeStd.setEditable(false);
        ausgabeMin.setEditable(false);
        eingabeStd1.setColumns(2);
        eingabeMin1.setColumns(2);
        eingabeStd2.setColumns(2);
        eingabeMin2.setColumns(2);
        eingabeMin2.setColumns(2);
        ausgabeStd.setColumns(2);
        ausgabeMin.setColumns(2);

        button.addActionListener(e -> {
            String stunde1 = eingabeStd1.getText();
            String minute1 = eingabeMin1.getText();
            String stunde2 = eingabeStd2.getText();
            String minute2 = eingabeMin2.getText();
            int std1 = Integer.parseInt(stunde1);
            int min1 = Integer.parseInt(minute1);
            int std2 = Integer.parseInt(stunde2);
            int min2 = Integer.parseInt(minute2);

            if(std1 > 23 || std1 < 0){
                JOptionPane.showMessageDialog(mainWindow, "Ungültige Eingabe! Ändere die Stundenzahl der ersten Uhrzeit!");
            } else if(min1 > 59 || min1 < 0) {
                JOptionPane.showMessageDialog(mainWindow, "Ungültige Eingabe! Ändere die Minutenzahl der ersten Uhrzeit!");
            }else if(std2 > 23 || std2 < 0) {
                JOptionPane.showMessageDialog(mainWindow, "Ungültige Eingabe! Ändere die Stundenzahl der zweiten Uhrzeit!");
            }else if(min2 > 59 || min2 < 0) {
                JOptionPane.showMessageDialog(mainWindow, "Ungültige Eingabe! Ändere die Minutenzahl der ersten Uhrzeit!");
            }

            int differenzstd = 0;
            int differenzmin = 0;

            if(std1 < std2){
                differenzstd = std1 - std2;
                if(min1 < min2){
                    differenzmin = min1-min2;
                }else {
                    differenzmin = min1 - min2;
                    differenzstd--;
                }
            }else if(std1 == std2){
                differenzstd = 0;
                if(min1 > min2){
                    differenzmin = min1 - min2;
                } else if(min1 < min2){
                    differenzmin = min2 - min1;
                }
            }

            String textdifstd = String.valueOf(differenzstd);
            String textdifmin = String.valueOf(differenzmin);
            ausgabeStd.setText(textdifstd);
            ausgabeMin.setText(textdifmin);
        });



        mainWindow.add(label1);
        mainWindow.add(eingabeStd1);
        mainWindow.add(trenner1);
        mainWindow.add(eingabeMin1);
        mainWindow.add(label2);
        mainWindow.add(eingabeStd2);
        mainWindow.add(trenner2);
        mainWindow.add(eingabeMin2);
        mainWindow.add(button);
        mainWindow.add(labelausgabe);
        mainWindow.add(ausgabeStd);
        mainWindow.add(trenner3);
        mainWindow.add(ausgabeMin);

        mainWindow.pack();
        mainWindow.setVisible(true);
    }
}
