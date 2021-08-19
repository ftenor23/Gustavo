package Manager;

import Entity.Machinery;

import java.util.ArrayList;
import java.util.List;

public abstract class PendingListManager {

    public static List<Machinery> getOnlyPendingList(List<Machinery> machineryList){
        List<Machinery> pendingList = new ArrayList<>();
        for(int i = 0; i<machineryList.size();i++){
            if(!machineryList.get(i).getPending().equals(" ")){
                pendingList.add(machineryList.get(i));
            }
        }
        return pendingList;
    }
}
