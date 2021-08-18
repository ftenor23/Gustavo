package Graphics;

import Entity.Client;
import Validator.IntValidator;

import javax.swing.*;

public abstract class DataIn {
    private final static int EXIT=0;
    private final static String ENTER_NAME = "Ingrese el nombre del cliente: ";
    private final static String ENTER_CLIENT_ZONE = "Ingrese la zona del cliente:";
    private final static String[] OPTIONS = {"Norte","Oeste","Sur","Capital Federal"};
    private final static String CHANGE_CLIENT_NAME = "Ingrese el nombre del nuevo cliente";

    public static String enterInfo(String message){
        String info = null;
        while(info==null){
            info= JOptionPane.showInputDialog(message);
            if(info==null){
                if(exit()==EXIT){
                    return null;
                }
            }
        }
        return info;
    }

    public static int exit(){
        return JOptionPane.showOptionDialog(null,"¿Esta seguro de que quiere dejar de cargar los datos?", "Cancelar", JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION,null,new String[]{"Si","No"},"Si");
    }

    public static Client validateData(String message){
        String clientName = null;
        final int EXIT=0;

        clientName = enterInfo(message);
        if(clientName==null){
            return null;
        }
        int clientZone = enterZone();
        return new Client(clientName,clientZone);
    }

    public static int enterStatus(){
        int status=0;
        while(status==0){
            status = JOptionPane.showOptionDialog(null, "Seleccione el estado de la maquinaria", "Seleccion", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,null,OPTIONS,OPTIONS[0]) + 1;
            if(status==0){
                if(exit()==EXIT){
                    return -1;
                }
            }
        }
        return status;
    }

    public static int enterZone(){
        return JOptionPane.showOptionDialog(null, ENTER_CLIENT_ZONE, "Zona", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,null,OPTIONS,OPTIONS[0]) + 1;
    }

    public static int enterHoursOfUse(String message){
        int hoursOfUse=-1;
        while(hoursOfUse==-1) {
            hoursOfUse = IntValidator.nextInt(message);
            if(hoursOfUse==-1){
                if(DataIn.exit()==EXIT){
                    return hoursOfUse;
                }
            }
        }
        return hoursOfUse;
    }
}
