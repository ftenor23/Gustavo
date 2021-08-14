package Graphics;

import BinArchive.Bin;
import Manager.MachineryManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
    private DTable table;
    private static boolean update;


    public void run(){
        update=true;
        setTitle(MACHINERY);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        menuBar = new Menu();
        setJMenuBar(menuBar);
        table = Table.getTable();
        setLayout(new GridLayout(0, 1));
        setSize(1500, 1000);
        setLocationRelativeTo(null);
        add(table);

        ScrollPane.setScrollPane(this, ScrollPane.getScrollPane(table));
        setVisible(true);
        refreshPage();




    }

    private void refreshPage(){
        while(update) {

            update=false;
            while (!update) ;
            table.setModel(new TMMachinery(Bin.readObjetsAndAddToList()));
        }
    }

    public void setTable(DTable t) {
        this.table = t;
    }

    public boolean isUpdate() {
        return update;
    }

    public static void setUpdate(boolean up) {
        update = up;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(menuBar.getSearchMachinery())){
            String id = Graphics.showMessage("Ingrese el ID de la maquinaria a buscar");
            MachineryGraphics.showInfo(MachineryManager.search(id));
            return;
        }
        if(e.getSource().equals(menuBar.getAddMachinery())){
            AddMachinery.enterData();
            return;
        }
        if(e.getSource().equals(menuBar.getEditMachinery())){
            EditMachinery.edit();
            return;
        }
        if(e.getSource().equals(menuBar.getDeleteMachinery())){
            DeleteMachinery.delete();
            return;
        }
        if(e.getSource().equals(menuBar.getShowDevInfo())){
            ShowInfo.showData();
            return;
        }
        if(e.getSource().equals(menuBar.getUpdate())){
            Window.setUpdate(true);
            TMMachinery model = new TMMachinery(Bin.readObjetsAndAddToList());
            table.setModel(model);

            // Window.setTable(Table.getTable());
            return;
        }
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
