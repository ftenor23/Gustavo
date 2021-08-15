package Graphics;

import Constants.SORT_CONSTANTS;
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

        Machinery machinery = enterMachinery();
        if(machinery==null){
            return;
        }
        MachineryManager.saveNewMachine(machinery);
        JOptionPane.showMessageDialog(null, NEW_MACHINE_SAVED);
    }

    private static String enterId(){
        return JOptionPane.showInputDialog(ENTER_ID);
    }

    public static int exit(){
        return JOptionPane.showOptionDialog(null,"¿Esta seguro de que quiere dejar de cargar los datos?", "Cancelar", JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION,null,new String[]{"Si","No"},"Si");
    }

    private static String enterFeatures(){
        return JOptionPane.showInputDialog(ENTER_FEATURES);
    }

    private static Client enterClient(){
        return AddClient.enterData(true);
    }

    private static Machinery enterMachinery(){
        String id=null;
        int status = 0;
        int hoursOfUse=0;
        String features = null;
        Client client= null;
        final int EXIT = 0;

        while(id==null){
            id=enterId();
            if(id==null){
                if(exit()==EXIT){
                    return null;
                }
            }
        }


        while(status==0){
            status = JOptionPane.showOptionDialog(null, "Seleccione el estado de la maquinaria", "Seleccion", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,null,OPTIONS,OPTIONS[0]) + 1;
            if(status==0){
                if(exit()==EXIT){
                    return null;
                }
            }
        }


        while (features==null){
            features=enterFeatures();
            if(features==null){
                if(exit()==EXIT){
                    return null;
                }
            }
        }

        while(client==null){
            client=enterClient();
            if(client==null){
                if(exit()==EXIT){
                    return null;
                }
            }
        }

        hoursOfUse = IntValidator.nextInt(ENTER_HOURS);

        return new Machinery(id,status,client,features,hoursOfUse);
    }
}
