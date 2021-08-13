package Graphics;

import Entity.Machinery;
import Manager.MachineryManager;

import javax.crypto.Mac;
import javax.swing.*;

public abstract class EditMachinery {
    private final static String OPTIONS = "1) Editar caracteristicas\n2)Cambiar de cliente\n3)Modificar pendientes\n4)Sumar horas de uso";
    private final static String ENTER_ID="Ingrese el ID de la maquinaria a editar";
    private final static String ENTER_NEW_FEATURES = "Ingrese las nuevas caracteristicas:";
    private final static String ENTER_NEW_CLIENT_NAME = "Ingrese el nombre del nuevo cliente";
    private final static String ENTER_NEW_CLIENT_ZONE = "Ingrese la zona del nuevo cliente:\n1)norte\n2)oeste\n3)sur\n4)capital";
    private final static String ENTER_NEW_PENDING = "Ingrese los nuevos pendientes:";
    private final static String ADD_HOURS = "Ingrese la cantidad de horas de uso (se sumaran a las acumuladas):";
    private final static String INVALID_OPTION = "Opcion invalida. Vuelva a intentar\n";
    private final static String CHANGES_SAVED = "Se guardaron todos los cambios. Presione actualizar.";

    public static void edit(){
        String id = JOptionPane.showInputDialog(ENTER_ID);
        Machinery machinery = MachineryManager.search(id);
        if(machinery==null){
            JOptionPane.showInputDialog(idNotFound(id));
            edit();
        }
        showOption(machinery);
        JOptionPane.showMessageDialog(null, CHANGES_SAVED);
    }

    private final static String idNotFound(String id){
        return "No se encontro el ID " + id + ". Vuelva a ingresar un id valido.";
    }

    private static void showOption(Machinery machinery){
        int option = Integer.parseInt(JOptionPane.showInputDialog(OPTIONS));
        while(option<1 || option>4){
            option= Integer.parseInt(JOptionPane.showInputDialog(INVALID_OPTION+OPTIONS));
        }

        switch(option){
            case 1:
                String newFeatures = JOptionPane.showInputDialog(ENTER_NEW_FEATURES);
                MachineryManager.changeFeatures(machinery,newFeatures);
                return;
            case 2:
                String newClientName = JOptionPane.showInputDialog(ENTER_NEW_CLIENT_NAME);
                int zone = Integer.parseInt(JOptionPane.showInputDialog(ENTER_NEW_CLIENT_ZONE));
                MachineryManager.changeClient(machinery,newClientName,zone);
                return;
            case 3:
                String newPending = JOptionPane.showInputDialog(ENTER_NEW_PENDING);
                MachineryManager.changePending(machinery,newPending);
                return;
            case 4:
                int hoursToAdd = Integer.parseInt(JOptionPane.showInputDialog(ADD_HOURS));
                MachineryManager.changeHours(machinery,hoursToAdd);
                return;
        }
    }
}
