package Graphics;

import Entity.Machinery;
import Manager.MachineryManager;
import Validator.IntValidator;

import javax.crypto.Mac;
import javax.swing.*;

public abstract class EditMachinery {
    private final static String SELECT_OPTION = "Elija la opcion a realizar:";
    private final static String[] OPTIONS = {"Editar caracteristicas","Cambiar de cliente","Modificar pendientes", "Actualizar horas de uso"};
    private final static String ENTER_ID="Ingrese el ID de la maquinaria a editar";
    private final static String ENTER_NEW_FEATURES = "Ingrese las nuevas caracteristicas:";
    private final static String ENTER_NEW_CLIENT_NAME = "Ingrese el nombre del nuevo cliente";
    private final static String ENTER_NEW_CLIENT_ZONE = "Ingrese la zona del nuevo cliente:\n1)norte\n2)oeste\n3)sur\n4)capital";
    private final static String ENTER_NEW_PENDING = "Ingrese los nuevos pendientes:";
    private final static String ADD_HOURS = "Ingrese la cantidad de horas de uso (se sumaran a las acumuladas):";
    private final static String INVALID_OPTION = "Opcion invalida. Vuelva a intentar\n";
    private final static String CHANGES_SAVED = "Se guardaron todos los cambios. Presione actualizar.";
    private final static String DO_YOU_WANT_TO_CHANGE_SOMETHING_ELSE = "¿Quiere realizar algun cambio mas sobre la misma maquinaria?";
    private final static String[] YES_NO_OPTIONS = {"Si", "No"};
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
        int option = JOptionPane.showOptionDialog(null, SELECT_OPTION, "Seleccion", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,null,OPTIONS,OPTIONS[0]) + 1;
        while(option<1 || option>4){
            option= Integer.parseInt(JOptionPane.showInputDialog(INVALID_OPTION+OPTIONS));
        }

        switch(option){
            case 1:
                String newFeatures = JOptionPane.showInputDialog(ENTER_NEW_FEATURES);
                MachineryManager.changeFeatures(machinery,newFeatures);
                break;
            case 2:
                MachineryManager.changeClient(machinery,AddClient.enterData(false));
                break;
            case 3:
                String newPending = JOptionPane.showInputDialog(ENTER_NEW_PENDING);
                MachineryManager.changePending(machinery,newPending);
                break;
            case 4:
                int hoursToAdd = IntValidator.nextInt(ADD_HOURS);
                MachineryManager.changeHours(machinery,hoursToAdd);
                break;
        }

        option = JOptionPane.showOptionDialog(null,DO_YOU_WANT_TO_CHANGE_SOMETHING_ELSE,"Seleccion",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,YES_NO_OPTIONS,YES_NO_OPTIONS[0]);

        if(option==0){ //si = 0
            showOption(machinery);
        }
    }
}
