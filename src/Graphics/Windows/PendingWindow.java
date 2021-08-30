package Graphics.Windows;

import Entity.Machinery;
import Graphics.Tables.Table;
import Graphics.Windows.Menu.MenuPendingWindow;
import Graphics.Windows.Scrollpane.ScrollPane;


import javax.swing.*;
import java.awt.*;
import java.util.List;



public class PendingWindow extends JFrame {
    private final static String PENDING_WINDOW = "Ventana de pendientes";
    private JTable table;
    private MenuPendingWindow menuBar;
    private static List<Machinery> machineryList;
    private static boolean update;

    public PendingWindow(List<Machinery> list) {
        PendingWindow.machineryList = list;
    }


    public void run() {
        update = false;
        setWindow();
    }

    private void setWindow() {
        setTitle(PENDING_WINDOW);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        menuBar = new MenuPendingWindow();
        setJMenuBar(menuBar);
        setTable();
        setLayout(new GridLayout(0, 1));
        setSize(1250, 750);
        setLocationRelativeTo(null);
        add(table);

        ScrollPane.setScrollPane(this, ScrollPane.getScrollPane(table));
        setVisible(true);
    }

    public static void addMachinery(Machinery machinery) {
        for (Machinery value : machineryList) {
            if (value.getId().equals(machinery.getId())) {
                value.setPending(machinery.getPending());
                update = true;
                return;
            }
        }
    }


    public static void setUpdate(boolean up) {
        update = up;
    }


    private void setTable() {
        table = Table.getPendingTable(machineryList);
        table.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 75));
        table.getTableHeader().setFont(new Font("arial", Font.BOLD, 35));
        table.getTableHeader().setBackground(new Color(200, 200, 200));
    }

}
