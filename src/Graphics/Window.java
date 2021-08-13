package Graphics;

import Manager.MachineryManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener {
    /*private JFrame frame;
    private JTable table;*/
    private Menu menuBar;
    private JMenu menu1, menu2, menu3;
    private JMenuItem menuItem21, menuItem22, menuItem31, menuItem32;
    private final static String MACHINERY = "Maquinaria";

    public Window(){
        setTitle(MACHINERY);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        menuBar = new Menu();
        setJMenuBar(menuBar);
        JTable table = Table.getTable();
        setLayout(new GridLayout(0, 1));
        setSize(1500, 1000);
        setLocationRelativeTo(null);
        add(table);

        ScrollPane.setScrollPane(this,ScrollPane.getScrollPane(table));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


    /*public Window() {
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
        this.frame.add(Menu.getMenuBar());
        ScrollPane.setScrollPane(this.frame,ScrollPane.getScrollPane(this.table));

        this.frame.setVisible(true);
        this.frame.setBackground(new Color(0,0,0));
    }*/
}
