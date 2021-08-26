package Graphics;

import Entity.Client;
import Entity.Machinery;
import Manager.MachineryManager;

import javax.swing.*;
import java.util.List;

public abstract class AddMachinery {
    private final static String ENTER_ID = "Ingrese el ID";
    private final static String ENTER_STATUS = "Ingrese el estado de la maquinaria\n1:en casa central\n2:en viaje\n3: en comercio";
    private final static String ENTER_FEATURES = "Ingrese la descripcion de la maquinaria:";
    private final static String ENTER_HOURS = "Ingrese las horas de uso hasta el momento. Recuerde que cada 250 se debe realizar un service.";
    private final static String NEW_MACHINE_SAVED = "Se guardo la nueva maquinaria correctamente.";
    private final static String[] OPTIONS = {"Casa central", "En viaje", "En comercio"};
    private final static int EXIT = 0;

    public static void enterData(List<Machinery> machineryList) {

        Machinery machinery = enterMachinery();
        if (machinery == null) {
            return;
        }
        MachineryManager.saveNewMachine(machinery, machineryList);
        JOptionPane.showMessageDialog(null, NEW_MACHINE_SAVED);
    }


    private static String enterFeatures() {
        return JOptionPane.showInputDialog(ENTER_FEATURES);
    }

    private static Client enterClient() {
        return AddClient.enterData(true);
    }

    private static Machinery enterMachinery() {
        String id = null;
        int status = 0;
        int hoursOfUse = -1;
        String features = null;
        Client client = null;
        final int EXIT = 0;

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

        hoursOfUse = DataIn.enterHoursOfUse(ENTER_HOURS);
        if (hoursOfUse == -1) {
            return null;
        }
        return new Machinery(id, status, client, features, hoursOfUse);
    }
}
