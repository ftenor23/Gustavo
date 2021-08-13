package Graphics;

import EnterData.EnterData;
import Entity.Client;

import javax.swing.*;

public abstract class AddClient {
    private final static String ENTER_NAME = "Ingrese el nombre del cliente: ";
    private final static String ENTER_CLIENT_ZONE = "Ingrese la zona del cliente:\n1)norte\n2)oeste\n3)sur\n4)capital";
    public static Client enterData(){

        String clientName = JOptionPane.showInputDialog(ENTER_NAME);
        int clientZone = Integer.parseInt(JOptionPane.showInputDialog(ENTER_CLIENT_ZONE));
        return new Client(clientName,clientZone);
    }
}
