package Graphics;

import BinArchive.Bin;
import Entity.Machinery;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Window {
    private JFrame frame;
    private JTable table;
    private final static String MACHINERY = "Maquinaria";

    public Window() {
        this.frame = new JFrame(MACHINERY);
        this.table = Table.getTable();
        setWindow();
    }

    private void setWindow(){
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setLayout(new GridLayout(0, 1));
        this.frame.setSize(1000, 1000);
        this.frame.setLocationRelativeTo(null);
        this.frame.add(this.table);
        ScrollPane.setScrollPane(this.frame,ScrollPane.getScrollPane(this.table));
        this.frame.setVisible(true);
        this.frame.setBackground(new Color(0,0,0));
    }
}
