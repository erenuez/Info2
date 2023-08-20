package Uebung;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class tabelleninator {
    static JFrame frame = new JFrame("Tabelleninator");
    static JTable table = new JTable(10,10);

    public static void main(String[] args){
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        BorderLayout border = new BorderLayout();
        frame.setLayout(border);

        frame.add(table, BorderLayout.CENTER);

        int x = 0;
        for(int a = 1; a <= 10; a++){
            for(int b = 1; b <= 10; b++){
                x = a*b;
                table.setValueAt(x,a-1,b-1);
            }
        }

        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            public Class<?> getColumnClass(int col){
                return Integer.class;
            }
        });

        frame.pack();
        frame.setVisible(true);
    }
}
