package Graphics;

import Manager.MachineryManager;

import javax.swing.*;

public abstract class DeleteMachinery {
    private final static String DELETE_MACHINE = "Ingrese el ID de la maquina a eliminar:";
    private final static String ERROR = "No se encontro el ID ingresado.\n";
    private final static String MACHINE_DELETED = "Se elimino la maquina ";

    public static void delete(){
        String id = JOptionPane.showInputDialog(DELETE_MACHINE);
        while (!MachineryManager.deleteMachine(id)){
               id = JOptionPane.showInputDialog(ERROR + DELETE_MACHINE);
        }
        JOptionPane.showMessageDialog(null,machineDeleted(id));
    }

    private static String machineDeleted(String id){
        return MACHINE_DELETED + id +". Presione actualizar para ver los cambios.";
    }
}
