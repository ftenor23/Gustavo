package Graphics.Windows.Actions;

import Entity.Client;
import Entity.Machinery;
import Manager.MachineryManager;

import javax.swing.*;
import java.util.List;

public abstract class AddMachinery {
    private final static String ENTER_ID = "Ingrese el ID";
    private final static String ENTER_FEATURES = "Ingrese la descripcion de la maquinaria:";

    private final static String ENTER_TOTAL_HOURS = "Ingrese la cantidad total de horas de trabajo de la maquina.";
    private final static String NEW_MACHINE_SAVED = "Se guardo la nueva maquinaria correctamente.";


    public static void enterData(List<Machinery> machineryList) {

        Machinery machinery = enterMachinery();
        if (machinery == null) {
            return;
        }
        MachineryManager.saveNewMachine(machinery, machineryList);
        JOptionPane.showMessageDialog(null, NEW_MACHINE_SAVED);
    }


    private static Client enterClient() {
        return AddClient.enterData(true);
    }

    private static Machinery enterMachinery() {
        String id;
        int status;
        int hsSinceLast250hsService;
        int hsSinceLast1000hsService;
        int totalHours;
        String features;
        Client client;

        id = DataIn.enterInfo(ENTER_ID);
        if (id == null) {
            return null;
        }

        status = DataIn.enterStatus();
        if (status == -1) {
            return null;
        }

        features = DataIn.enterInfo(ENTER_FEATURES);
        if (features == null) {
            return null;
        }

        client = enterClient();
        if (client == null) {
            return null;
        }

        hsSinceLast250hsService = DataIn.enterHoursOfUse(hoursSinceService(250));
        if (hsSinceLast250hsService == -1) {
            return null;
        }

        hsSinceLast1000hsService = DataIn.enterHoursOfUse(hoursSinceService(1000));
        if (hsSinceLast1000hsService == -1) {
            return null;
        }

        totalHours = DataIn.enterHoursOfUse(ENTER_TOTAL_HOURS);
        if (totalHours == -1) {
            return null;
        }


        return new Machinery(id, status, client, features, hsSinceLast250hsService, hsSinceLast1000hsService,totalHours);
    }

    private static String hoursSinceService(int service){
        return "Ingrese las horas de uso hasta el momento desde el ultimo service de " + service + "hs";
    }
}
