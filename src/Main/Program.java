package Main;

import BinArchive.Bin;
import Entity.Machinery;
import Graphics.Window;
import Manager.MachineryCounter;
import Manager.MachineryManager;

import java.util.ArrayList;
import java.util.List;

public class Program {
    private final static int MACHINES_PER_PAGE = 5;


    public static void main(String[] args) {
        /*List<Machinery> machineryList = Bin.readObjetsAndAddToList();
        MachineryManager.saveMachinesInOrder(machineryList,"ID");
        int machinesNumber = MachineryCounter.getNumberOfMachines();

        int numberOfLists = machinesNumber/MACHINES_PER_PAGE;*/



        Window window = new Window();
        window.run();


    }
}
