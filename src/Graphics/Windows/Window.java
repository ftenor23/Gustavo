package Graphics.Windows;

import Graphics.Tables.DTable;
import Graphics.Tables.Table;
import Graphics.Tables.TableModels.TMMachinery;
import Graphics.Windows.Actions.AddMachinery;
import Graphics.Windows.Actions.DeleteMachinery;
import Graphics.Windows.Actions.EditMachinery;
import Graphics.Windows.Info.ShowInfo;
import Graphics.Windows.Messages.MachineryGraphics;
import Mapper.Bin;
import Constants.SORT_CONSTANTS;
import Entity.Machinery;
import Manager.MachineryManager;
import Manager.Sort;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import Graphics.Windows.Menu.Menu;
import Graphics.Windows.Scrollpane.ScrollPane;
import Graphics.Windows.Messages.Graphics;

public class Window extends JFrame implements ActionListener {
    private Menu menuBar;
    private DTable table;
    private static List<Machinery> machineryList;
    private static int waitingTime = 2000; //5 segundos
    private final static int MACHINERY_TO_SHOW_PER_PAGE = 14;
    private final static String MACHINERY = "Maquinaria";
    private static boolean update;
    private static String sortMode = SORT_CONSTANTS.ID;

    private static boolean machineryUpdate;

    public static void setWaitingTime(int waitingTime) {
        Window.waitingTime = waitingTime;
    }


    public static void setSortMode(String sortMode) {
        Window.sortMode = sortMode;
    }

    public void run() {
        update = true;
        machineryUpdate=false;
        machineryList = Bin.readObjetsAndAddToList();
        setWindow();
        refreshPage();
    }

    public static List<Machinery> getMachineryList() {
        return machineryList;
    }

    public static void setMachineryUpdate(boolean machineryUpdate) {
        Window.machineryUpdate = machineryUpdate;
    }

    private void setWindow() {
        setTitle(MACHINERY);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        menuBar = new Menu();
        setJMenuBar(menuBar);
        setTable();
        setLayout(new GridLayout(0, 1));
        setSize(1500, 1000);
        setLocationRelativeTo(null);
        add(table);

        ScrollPane.setScrollPane(this, ScrollPane.getScrollPane(table));
        setVisible(true);
    }

    private void refreshPage() {
        sortBy(sortMode);
        while (update) {
            sortBy(sortMode);
        }
    }

    public static void setMachineryList(List<Machinery> machineryList) {
        Window.machineryList = machineryList;
    }

    public static void addMachineryToList(Machinery machinery) {
        machineryList.add(machinery);
        Sort.sortMachinesById(machineryList);
        MachineryManager.printList(machineryList);
    }


    private void setTable() {
        table = Table.getTable(machineryList);
        table.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 75));
        table.getTableHeader().setFont(new Font("arial", Font.BOLD, 35));
        table.getTableHeader().setBackground(new Color(200, 200, 200));
        setColumnsWidth();
    }

    private void sortBy(String option) {
        //verificar cuando carga la utlima lista
        machineryUpdate=false;

        Sort.sortMachines(machineryList, option);
        final int machineryListSize = machineryList.size();
        int totalPages = (machineryList.size() / MACHINERY_TO_SHOW_PER_PAGE);
        if ((machineryList.size() % MACHINERY_TO_SHOW_PER_PAGE) != 0) {
            totalPages++;
        }

        //transformar listas en vetyores

        List<Machinery> copyOfList = new ArrayList<>(machineryList);
        List<Machinery>[] subList = new List[totalPages];
        int counter = 0;
        for (int page = 0; page < totalPages; page++) {


            if (page != totalPages - 1) {
                subList[page] = copyOfList.subList(counter, MACHINERY_TO_SHOW_PER_PAGE + counter);
                counter += MACHINERY_TO_SHOW_PER_PAGE;
             } else {

                int sublistSize = copyOfList.size();
                subList[page] = copyOfList.subList(counter, sublistSize);
            }
        }

        while (sortMode.equals(option) && machineryListSize == machineryList.size()) {
            for (int i = 0; i < totalPages; i++) {
                table.setVisible(false);
                table.setModel(new TMMachinery(subList[i]));
                table.setVisible(true);
                wait(waitingTime);
                if(machineryUpdate || !sortMode.equals(option)){
                    return;
                }
            }
        }

    }


    private void wait(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }



    public static void setUpdate(boolean up) {
        update = up;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(menuBar.getSearchMachinery())) {
            String id = Graphics.showMessage("Ingrese el ID de la maquinaria a buscar");
            MachineryGraphics.showInfo(MachineryManager.search(id));
            return;
        }
        if (e.getSource().equals(menuBar.getAddMachinery())) {
            AddMachinery.enterData(Window.getMachineryList());
            return;
        }
        if (e.getSource().equals(menuBar.getEditMachinery())) {
            EditMachinery.edit();
            return;
        }
        if (e.getSource().equals(menuBar.getDeleteMachinery())) {
            DeleteMachinery.delete();
            return;
        }
        if (e.getSource().equals(menuBar.getShowDevInfo())) {
            ShowInfo.showData();
            return;
        }
    }

    private void setColumnsWidth() {
        table.getColumnModel().getColumn(0).setPreferredWidth(400);
        table.getColumnModel().getColumn(0).setResizable(false);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setResizable(false);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setResizable(false);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setResizable(false);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setResizable(false);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);
        table.getColumnModel().getColumn(5).setResizable(false);

    }
}
