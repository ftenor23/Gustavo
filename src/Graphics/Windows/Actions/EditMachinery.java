package Graphics.Windows.Actions;

import Entity.Client;
import Entity.Machinery;
import Manager.MachineryManager;
import Validator.IntValidator;

import javax.swing.*;

public abstract class EditMachinery {
    private final static String SELECT_OPTION = "Elija la opcion a realizar:";
    private final static String[] OPTIONS = {"Editar caracteristicas", "Cambiar de cliente", "Modificar pendientes", "Actualizar horas de uso"};
    public final static String ENTER_ID = "Ingrese el ID de la maquinaria a editar";
    private final static String ENTER_NEW_FEATURES = "Ingrese las nuevas caracteristicas:";
    private final static String ENTER_NEW_PENDING = "Ingrese los nuevos pendientes:";
    private final static String ADD_HOURS = "Ingrese la cantidad de horas de uso (se sumaran a las acumuladas):";
    private final static String CHANGES_SAVED = "Se guardaron todos los cambios";
    private final static String DO_YOU_WANT_TO_CHANGE_SOMETHING_ELSE = "¿Quiere realizar algun cambio mas sobre la misma maquinaria?";
    private final static String[] YES_NO_OPTIONS = {"Si", "No"};
    private final static String DO_YOU_WANT_TO_CANCEL = "¿Quiere cancelar la edicion de maquinaria?";
    public final static int EXIT = 0;
    public final static String MACHINE_NOT_FOUND = "No se encontro la maquina solicitada";
    private final static String EDITION_CANCELLED = "Edicion cancelada";

    public static void edit() {

        Machinery machinery = enterData();
        if (machinery == null) {
            JOptionPane.showMessageDialog(null, MACHINE_NOT_FOUND);
            return;
        }


        showOption(machinery);
        //cambiar maquina en lista

    }

    public static Machinery enterData() {
        String id = JOptionPane.showInputDialog(ENTER_ID);
        if (id == null) {
            int option = JOptionPane.showOptionDialog(null, DO_YOU_WANT_TO_CANCEL, "Cancelar", JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, null, new String[]{"Si", "No"}, "Si");
            if (option == EXIT) {
                return null;
            }
            enterData();
        }
        Machinery machinery = MachineryManager.search(id);
        if (machinery == null) {
            JOptionPane.showInputDialog(idNotFound(id));
        }
        return machinery;
    }


    private static String idNotFound(String id) {
        return "No se encontro el ID " + id + ". Vuelva a ingresar un id valido.";
    }

    private static void showOption(Machinery machinery) {
        final int CANCEL = 0;
        final int NEW_FEATURES = 1;
        final int NEW_CLIENT = 2;
        final int NEW_PENDING = 3;
        final int HOURS_TO_ADD = 4;


        int option = JOptionPane.showOptionDialog(null, SELECT_OPTION, "Seleccion",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                OPTIONS, OPTIONS[0]) + 1;

        switch (option) {
            case CANCEL:
                JOptionPane.showMessageDialog(null, EDITION_CANCELLED);
                return;
            case NEW_FEATURES:
                String newFeatures = JOptionPane.showInputDialog(ENTER_NEW_FEATURES);
                if (newFeatures == null) {
                    JOptionPane.showMessageDialog(null, EDITION_CANCELLED);
                    return;
                }
                MachineryManager.changeFeatures(machinery, newFeatures);
                break;
            case NEW_CLIENT:
                Client newClient = AddClient.enterData(false);
                if (newClient == null) {
                    JOptionPane.showMessageDialog(null, EDITION_CANCELLED);
                    return;
                }
                MachineryManager.changeClient(machinery, newClient);
                break;
            case NEW_PENDING:
                String newPending = JOptionPane.showInputDialog(ENTER_NEW_PENDING);
                if (newPending == null) {
                    JOptionPane.showMessageDialog(null, EDITION_CANCELLED);
                    return;
                }
                MachineryManager.changePending(machinery, newPending);
                break;
            case HOURS_TO_ADD:
                int hoursToAdd = IntValidator.nextInt(ADD_HOURS);
                if (hoursToAdd < 0) {
                    JOptionPane.showMessageDialog(null, EDITION_CANCELLED);
                    return;
                }
                MachineryManager.changeHours(machinery, hoursToAdd);
                break;


        }

        option = JOptionPane.showOptionDialog(null, DO_YOU_WANT_TO_CHANGE_SOMETHING_ELSE, "Seleccion", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, YES_NO_OPTIONS, YES_NO_OPTIONS[0]);

        if (option == 0) { //si = 0
            showOption(machinery);
        }
        JOptionPane.showMessageDialog(null, CHANGES_SAVED);

    }

    public static void changePending(Machinery machinery) {
        String newPending = JOptionPane.showInputDialog(ENTER_NEW_PENDING);
        MachineryManager.changePending(machinery, newPending);
    }
}
