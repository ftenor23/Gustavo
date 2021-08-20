package Main;

import Constants.SORT_CONSTANTS;
import Entity.Machinery;
import Graphics.PendingWindow;
import Graphics.Window;
import Manager.PendingListManager;
import Manager.Sort;
import Mapper.Bin;

import javax.swing.*;
import java.util.List;

public class MainTestPendingWindow {
    public static void main(String[] args) {
        List<Machinery> machineryList = Sort.sortMachines(Bin.readObjetsAndAddToList(), SORT_CONSTANTS.PENDING);
        List<Machinery> onlyPendingList = PendingListManager.getOnlyPendingList(machineryList);
        if(onlyPendingList==null){
            JOptionPane.showMessageDialog(null, "No hay lista de pendientes");
            return;
        }
        PendingWindow pendingWindow = new PendingWindow(onlyPendingList);
        pendingWindow.run();
    }
}
