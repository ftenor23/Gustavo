package Manager;

import Entity.Machinery;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class Sort {

    public static void sortMachinesById(List<Machinery> list){
        //ordenar por algun criterio
        list.sort(Comparator.comparing(Machinery::getId));

    }

    public static List<Machinery> sortMachines(List<Machinery> list, String sortBy){
        final String ID = "ID";
        final String STATUS = "STATUS";
        final String HOURS_OF_USE = "HOURS OF USE";
        final String CLIENT = "CLIENT";
        final String ZONE = "ZONE";

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
