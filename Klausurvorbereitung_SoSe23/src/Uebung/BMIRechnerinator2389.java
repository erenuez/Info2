package Uebung;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMIRechnerinator2389 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BMI Rechner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        JLabel labelGewicht = new JLabel("Gewicht (kg):");
        JLabel labelGroesse = new JLabel("Größe (m):");
        JTextField textFieldGewicht = new JTextField(10);
        JTextField textFieldGroesse = new JTextField(10);
        JButton berechneButton = new JButton("Berechne BMI");
        JLabel ergebnisLabel = new JLabel("BMI:");
        JButton buttonLoeschen = new JButton("Einträge Löschen");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(berechneButton);
        buttonPanel.add(buttonLoeschen);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.insets = new Insets(5, 5, 5, 5);
        panel.add(labelGewicht, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        panel.add(textFieldGewicht, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(labelGroesse, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(textFieldGroesse, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.weightx = 2.0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(buttonPanel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(ergebnisLabel, constraints);

        berechneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double gewicht = Double.parseDouble(textFieldGewicht.getText());
                    double groesse = Double.parseDouble(textFieldGroesse.getText());

                    double bmi = gewicht / (groesse * groesse);
                    ergebnisLabel.setText("BMI: " + bmi);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Ungültige Eingabe!", "Fehler", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        buttonLoeschen.addActionListener(e -> {
           textFieldGewicht.setText("");
           textFieldGroesse.setText("");
        });


        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
