package Graphics;

import Entity.Client;
import Entity.Machinery;
import Manager.MachineryManager;
import Validator.IntValidator;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class AddMachinery {
    private final static String ENTER_ID = "Ingrese el ID";
    private final static String ENTER_STATUS = "Ingrese el estado de la maquinaria\n1:en casa central\n2:en viaje\n3: en comercio";
    private final static String ENTER_FEATURES = "Ingrese la descripcion de la maquinaria:";
    private final static String ENTER_HOURS = "Ingrese las horas de uso hasta el momento. Recuerde que cada 250 se debe realizar un service.";
    private final static String NEW_MACHINE_SAVED = "Se guardo la nueva maquinaria correctamente.";
    private final static String[] OPTIONS = {"Casa central", "En viaje", "En comercio"};

    public static void enterData(){

        Machinery machinery = new Machinery();
        String id = JOptionPane.showInputDialog(ENTER_ID);
        int status = JOptionPane.showOptionDialog(null, "Seleccione el estado de la maquinaria", "Seleccion", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,null,OPTIONS,OPTIONS[0]) + 1;
        String features = JOptionPane.showInputDialog(ENTER_FEATURES);
        Client client = AddClient.enterData(true);
        int hoursOfUse = IntValidator.nextInt(ENTER_HOURS);
        MachineryManager.saveNewMachine(new Machinery(id,status,client,features,hoursOfUse));
        JOptionPane.showMessageDialog(null, NEW_MACHINE_SAVED);
    }


}
