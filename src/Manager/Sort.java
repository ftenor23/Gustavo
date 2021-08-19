package Manager;

import Constants.SORT_CONSTANTS;
import Entity.Machinery;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class Sort {
    private final static String ID = SORT_CONSTANTS.ID;
    private final static String STATUS = SORT_CONSTANTS.STATUS;
    private final static String HOURS_OF_USE = SORT_CONSTANTS.HOURS_OF_USE;
    private final static String CLIENT = SORT_CONSTANTS.CLIENT;
    private final static String ZONE = SORT_CONSTANTS.ZONE;
    private final static String PENDING = SORT_CONSTANTS.PENDING;

    public static void sortMachinesById(List<Machinery> list){
        //ordenar por algun criterio
        list.sort(Comparator.comparing(Machinery::getId));

    }

    public static List<Machinery> sortMachines(List<Machinery> list, String sortBy){

        switch (sortBy){
            case ID:
                list.sort(Comparator.comparing(Machinery::getId));
                break;
            case STATUS:
                list.sort(Comparator.comparing(Machinery::getStatus));
                break;
            case HOURS_OF_USE:
                list.sort(Comparator.comparing(Machinery::getHoursOfUse));
                Collections.reverse(list);
                break;
            case CLIENT:
                list.sort(Comparator.comparing(Machinery::getClientName));
                break;
            case ZONE:
                list.sort(Comparator.comparing(Machinery::getClientZone));
                break;
            case PENDING:
                list.sort(Comparator.comparing(Machinery::getPending));
                break;
        }
        return list;
    }
}
