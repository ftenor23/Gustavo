package Manager;

import Mapper.Bin;

public abstract class MachineryCounter {
    public static int getNumberOfMachines(){
        return Bin.getNumberOfMachines();
    }
}
