package Graphics;

import Manager.MachineryManager;

import javax.swing.*;

public abstract class DeleteMachinery {
    private final static String DELETE_MACHINE = "Ingrese el ID de la maquina a eliminar:";
    private final static String ERROR = "No se encontro el ID ingresado.\n";
    private final static String MACHINE_DELETED = "Se elimino la maquina ";

    public static void delete(){

        String id = JOptionPane.showInputDialog(DELETE_MACHINE);
        int pos = MachineryManager.getMachineryPosition(id);
        while(pos<0){
            id = JOptionPane.showInputDialog(ERROR + DELETE_MACHINE);
        }

        int input = JOptionPane.showConfirmDialog(null,"Esta seguro de que desea eliminar la maquina " + id + "?");
        if(input==0) {
            MachineryManager.deleteMachine(id);
            JOptionPane.showMessageDialog(null, machineDeleted(id));
        } else {
            JOptionPane.showMessageDialog(null, "La maquina " + id + " no fue eliminada.");
        }
    }

    private static String machineDeleted(String id){
        return MACHINE_DELETED + id +". Presione actualizar para ver los cambios.";
    }
}
