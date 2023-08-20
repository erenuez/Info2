package Uebung;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.List;
import java.util.TreeSet;

public class CollectionTabelle {
    static String[] array = {"Hallo", "Eren", "Cool", "Super", "Wunderberaubend"};

    static JFrame frame = new JFrame("Cellection in Tabelle anzeigen");
    static JTable table;


    public static void main(String[] args){
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        BorderLayout border = new BorderLayout();
        frame.setLayout(border);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Data", array);
        table = new JTable(model);

        frame.add(table);

        frame.pack();
        frame.setVisible(true);
    }
}
