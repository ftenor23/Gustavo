package Manager;

import Entity.Machinery;

import java.util.ArrayList;
import java.util.List;

public abstract class PendingListManager {

    public static List<Machinery> getOnlyPendingList(List<Machinery> machineryList){
        List<Machinery> pendingList = new ArrayList<>();
        for (Machinery machinery : machineryList) {
            if (!machinery.getPending().equals("")) {
                pendingList.add(machinery);
            }
        }
        if (pendingList.size()==0){
            return null;
        }
        return pendingList;
    }
}
