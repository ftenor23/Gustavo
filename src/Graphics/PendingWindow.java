package Graphics;

import Entity.Machinery;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;
import Graphics.*;
import Manager.MachineryManager;
import Manager.Sort;
import Mapper.Bin;


public class PendingWindow extends JFrame {
    private final static String PENDING_WINDOW = "Ventana de pendientes";
    private JTable table;
    private MenuPendingWindow menuBar;
    private static List<Machinery> machineryList;
    private static boolean update;

    public PendingWindow(List<Machinery> list){
        this.machineryList=list;
    }

    public static List<Machinery> getMachineryList() {
        return machineryList;
    }

    public void run(){
        update=false;
        setWindow();
        while(true){
            refreshPage();
        }
    }
    private void setWindow(){
        setTitle(PENDING_WINDOW);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        menuBar = new MenuPendingWindow();
        setJMenuBar(menuBar);
        table = Table.getPendingTable(machineryList);
        setLayout(new GridLayout(0, 1));
        setSize(1250, 750);
        setLocationRelativeTo(null);
        add(table);

        ScrollPane.setScrollPane(this, ScrollPane.getScrollPane(table));
        setVisible(true);
    }

    public static void addMachinery(Machinery machinery){
        for(int i=0;i<machineryList.size();i++){
            if(machineryList.get(i).getId().equals(machinery.getId())){
                machineryList.get(i).setPending(machinery.getPending());
                update=true;
                return;
            }
        }
    }


    public static void setUpdate(boolean up) {
        update = up;
    }

    private void updateTable(List<Machinery> list){
        System.out.println("ENTRO A UPDATE TABLE");
        table.setModel(new TMPending(list));
        System.out.println("Se agrego maquinaria a lista de pendientes");
        try {
            Thread.sleep(2000);
        }catch(Exception e){

        }
    }

    private void refreshPage(){

            if(update) {

                table.setModel(new TMPending(machineryList));
                System.out.println("tabla actualizada");
                update=false;
            }
        }

}
