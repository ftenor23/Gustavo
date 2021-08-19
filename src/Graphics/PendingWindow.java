package Graphics;

import Entity.Machinery;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PendingWindow extends JFrame {
    private final static String PENDING_WINDOW = "Ventana de pendientes";
    private JTable table;
    private MenuPendingWindow menuBar;
    private static List<Machinery> machineryList;

    public PendingWindow(List<Machinery> list){
        this.machineryList=list;
    }

    public static List<Machinery> getMachineryList() {
        return machineryList;
    }

    public void run(){
        setWindow();
    }
    private void setWindow(){
        setTitle(PENDING_WINDOW);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        menuBar = new MenuPendingWindow();
        setJMenuBar(menuBar);
        table = Table.getPendingTable(machineryList);
        setLayout(new GridLayout(0, 1));
        setSize(1500, 1000);
        setLocationRelativeTo(null);
        add(table);

        ScrollPane.setScrollPane(this, ScrollPane.getScrollPane(table));
        setVisible(true);
    }
}
