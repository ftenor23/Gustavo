package Graphics;

import EnterData.EnterData;
import Entity.Client;

import javax.swing.*;

public abstract class AddClient {
    private final static String ENTER_NAME = "Ingrese el nombre del cliente: ";
    private final static String ENTER_CLIENT_ZONE = "Ingrese la zona del cliente:";
    private final static String[] OPTIONS = {"Norte","Oeste","Sur","Capital Federal"};
    private final static String CHANGE_CLIENT_NAME = "Ingrese el nombre del nuevo cliente";

    public static Client enterData(boolean newClient){
        String message;
        if(newClient){
            message=ENTER_NAME;
        }else{
            message=CHANGE_CLIENT_NAME;
        }
        String clientName = JOptionPane.showInputDialog(message);
        int clientZone = JOptionPane.showOptionDialog(null, ENTER_CLIENT_ZONE, "Zona", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,null,OPTIONS,OPTIONS[0]) + 1;

        return new Client(clientName,clientZone);
    }
}
