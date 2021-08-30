package Graphics.Windows.Messages;

import Entity.Client;
import Entity.Machinery;
import Graphics.Windows.Actions.ClientGraphics;


import javax.swing.*;
import java.util.List;

public abstract class MachineryGraphics {
    public static void printActualStatus(Machinery machinery){
        System.out.println("El estado actual es " + machinery.getStatus());
    }

    public static void printStatusOptions(){
        System.out.println("Ingrese el nuevo estado de la maquina");
        System.out.println("1) en casa central\n" +
                "2)en viaje\n3) en comercio");
    }

    public static void changeClient(){
        //deberia leer el archivo completo de clientes y elegir uno
        System.out.println("Seleccione el numero de cliente a asignar: ");
    }

    public static String printMachineryData(Machinery machinery){
        return printId(machinery)+
        printStatus(machinery)+
        printFeatures(machinery)+
        printClientInfo(machinery.getClient())+printHoursOfUse(machinery)+
                printPending(machinery);

    }

    private static String printPending(Machinery machinery){
        return "Pendientes: " + machinery.getPending() + "\n";
    }
    private static String printHoursOfUse(Machinery machinery){
        return "Horas de uso: " + machinery.getHoursOfUse() + "\n";
    }
    private static String printId(Machinery machinery){
        return "Id: " + machinery.getId() + "\n";
    }

    public static String printStatus(Machinery machinery){
        String response = "Estado de la maquinaria: ";
        switch (machinery.getStatus()){
            case 1:
                response+="Se encuentra en casa central";
                break;
            case 2:
                response+="Se encuentra en viaje";
                break;
            case 3:
                response+="Se encuentra en comercio";
                break;
            default:
                response+="Error en el estado";
                break;
        }
        return response + "\n";
    }

    public static String printFeatures(Machinery machinery){
        return "Descripcion: " + machinery.getFeatures() + "\n";
    }

    public static String printClientInfo(Client client){
        return ClientGraphics.printName(client)+ ClientGraphics.printZone(client);
    }

    public static void showMachinery(List<Machinery> list){
        int counter=0;
        int limit=3;
        boolean exit=false;
        while(!exit){
            for(int i=0;i<limit;i++){
                if(i+counter<list.size()) {
                    printMachineryData(list.get(i + counter));
                }
            }


            try{
                Thread.sleep(3000);
            }catch(Exception e){

            }
            counter+=limit;
            if(counter> list.size()){
                counter=0;
            }
            Graphics.cleanConsole();
        }
    }

    public static void showInfo(Machinery machinery){
        if(machinery!=null) {
            JOptionPane.showMessageDialog(null, printMachineryData(machinery));
        }else{
            JOptionPane.showMessageDialog(null,"Maquinaria no encontrada en la base de datos");
        }
    }

    public static void showPending(Machinery machinery){
        if(machinery!=null){
            JOptionPane.showMessageDialog(null, pending(machinery));
        }else{
            JOptionPane.showMessageDialog(null,"Maquinaria no encontrada en la base de datos");
        }
    }

    private static String pending(Machinery machinery){
        return "ID: " + machinery.getId() + "\nPendiente: " + machinery.getPending();
    }
}
