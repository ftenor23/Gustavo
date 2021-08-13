package Graphics;

import Entity.Client;
import Entity.Machinery;
import Manager.MachineryManager;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;

public abstract class AddMachinery {
    private final static String ENTER_ID = "Ingrese el ID";
    private final static String ENTER_STATUS = "Ingrese el estado de la maquinaria\n1:en casa central\n2:en viaje\n3: en comercio";
    private final static String ENTER_FEATURES = "Ingrese la descripcion de la maquinaria:";
    private final static String ENTER_HOURS = "Ingrese las horas de uso hasta el momento. Recuerde que cada 250 se debe realizar un service.";
    private final static String NEW_MACHINE_SAVED = "Se guardo la nueva maquinaria. Presione actualizar.";
    public static void enterData(){

        Machinery machinery = new Machinery();
        String id = JOptionPane.showInputDialog(ENTER_ID);
        int status = Integer.parseInt(JOptionPane.showInputDialog(ENTER_STATUS));
        String features = JOptionPane.showInputDialog(ENTER_FEATURES);
        Client client = AddClient.enterData();
        int hoursOfUse = Integer.parseInt(JOptionPane.showInputDialog(ENTER_HOURS));
        MachineryManager.saveNewMachine(new Machinery(id,status,client,features,hoursOfUse));
        JOptionPane.showMessageDialog(null, NEW_MACHINE_SAVED);
    }
}
