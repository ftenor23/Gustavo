package Manager;

import Entity.Machinery;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class Sort {
    private final static String ID = "ID";
    private final static String STATUS = "STATUS";
    private final static String HOURS_OF_USE = "HOURS OF USE";
    private final static String CLIENT = "CLIENT";
    private final static String ZONE = "ZONE";

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
        }
        return list;
    }
}
