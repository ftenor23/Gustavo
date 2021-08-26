package Graphics;

import Mapper.Bin;
import Constants.SORT_CONSTANTS;
import Entity.Machinery;
import Manager.MachineryManager;
import Manager.Sort;

import javax.crypto.Mac;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Window extends JFrame implements ActionListener {
    /*private JFrame frame;
    private JTable table;*/
    private Menu menuBar;
    private JMenu menu1, menu2, menu3;
    private JMenuItem menuItem21, menuItem22, menuItem31, menuItem32;
    private final static String MACHINERY = "Maquinaria";
    private DTable table;
    private static boolean update;
    private static String sortMode= SORT_CONSTANTS.ID;
    private final static String HOURS = "HOURS OF USE";
    private final static String STATUS = "STATUS";
    private static List<Machinery> machineryList;
    private static int waitingTime = 2000; //5 segundos
    private final static int MACHINERY_TO_SHOW_PER_PAGE = 15;

    public static void setWaitingTime(int waitingTime) {
        Window.waitingTime = waitingTime;
    }

    public static String getSortMode() {
        return sortMode;
    }

    public static void setSortMode(String sortMode) {
        Window.sortMode = sortMode;
    }

    public void run(){
        update=true;
        machineryList=Bin.readObjetsAndAddToList();
        setWindow();
        refreshPage();
    }

    public static List<Machinery> getMachineryList() {
        return machineryList;
    }

    private void setWindow(){
        setTitle(MACHINERY);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        menuBar = new Menu();
        setJMenuBar(menuBar);
        table = Table.getTable(machineryList);
        setLayout(new GridLayout(0, 1));
        setSize(1500, 1000);
        setLocationRelativeTo(null);
        add(table);

        ScrollPane.setScrollPane(this, ScrollPane.getScrollPane(table));
        setVisible(true);
    }
    private void refreshPage(){
        sortBy(sortMode);
        while(update) {

            //update=false;
            //while (!update) ;
            sortBy(sortMode);
            System.out.println("Saliendo del WHILE");
           //setSortMode(SORT_CONSTANTS.ID);

        }
    }

    public static void setMachineryList(List<Machinery> machineryList) {
        Window.machineryList = machineryList;
    }

    public static void addMachineryToList(Machinery machinery){
        machineryList.add(machinery);
        Sort.sortMachinesById(machineryList);
        MachineryManager.printList(machineryList);
    }

   /* private void sortBy(String option){
        final int MACHINERY_TO_SHOW_PER_PAGE = 15;
        Sort.sortMachines(machineryList,option);

        //transformar listas en vetyores
        List<Machinery> list1= new ArrayList<>();

        int counter = 0;
        while(sortMode.equals(option)) {
            System.out.println("Entrando al while");
            for (int i = 0; i < machineryList.size(); i++) {

                if(!sortMode.equals(option)){
                    return;
                }
                if(MACHINERY_TO_SHOW_PER_PAGE>=machineryList.size()){
                    List<Machinery> list2 = new ArrayList<>(machineryList);
                    i=machineryList.size();
                    table.setModel(new TMMachinery(list2));
                    while(i==machineryList.size());
                    return;
                } else if (counter < MACHINERY_TO_SHOW_PER_PAGE) {
                    list1.add(machineryList.get(i));
                    counter++;
                }
                if (counter == MACHINERY_TO_SHOW_PER_PAGE) {
                    table.setModel(new TMMachinery(list1));
                    wait(waitingTime);
                    counter = 0;
                    list1.clear();
                }

            }
        }

    }*/


    private void sortBy(String option){
        //verificar cuando carga la utlima lista

        Sort.sortMachines(machineryList,option);
        final int machineryListSize = machineryList.size();
        int totalPages = (machineryList.size()/MACHINERY_TO_SHOW_PER_PAGE);
        if((machineryList.size()%MACHINERY_TO_SHOW_PER_PAGE)!=0){
            totalPages++;
        }
        System.out.println("TOTAL PAGES " + totalPages);
        //transformar listas en vetyores

        List<Machinery> copyOfList = new ArrayList<>(machineryList);
        List<Machinery>[] subList = new List[totalPages];
        int counter = 0;
        for(int page = 0; page<totalPages;page++){


            if(page!=totalPages-1){
                subList[page] = copyOfList.subList(counter, MACHINERY_TO_SHOW_PER_PAGE+counter);
                counter+=MACHINERY_TO_SHOW_PER_PAGE;
                System.out.println("TAMAÑO DE COPY OF LIST " + copyOfList.size() + "//COUNTER "+counter+"//SUBLIST SIZE " +copyOfList.size());
            }else{
                System.out.println("TAMAÑO DE LA SUBLISTA " + copyOfList.size());
                int sublistSize = copyOfList.size();
                subList[page] = copyOfList.subList(counter,sublistSize);
            }
        }
        System.out.println("Tamaño del vector " + subList.length);
        while(sortMode.equals(option) && machineryListSize == machineryList.size()){
            for(int i = 0; i<totalPages; i++){
                table.setVisible(false);
                table.setModel(new TMMachinery(subList[i]));
                table.setVisible(true);
                wait(waitingTime);
            }
        }

    }





    private void wait(int time){
        try {
            Thread.sleep(time);
        } catch (Exception e) {

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
            AddMachinery.enterData(Window.getMachineryList());
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
