package Graphics;

import Entity.Client;
import Entity.Machinery;
import Manager.ClientManager;

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

    public static void printMachineryData(Machinery machinery){
        printId(machinery);
        printStatus(machinery);
        printFeatures(machinery);
        printClientInfo(machinery.getClient());
    }

    public static void printId(Machinery machinery){
        System.out.println("Id: " + machinery.getId());
    }

    public static void printStatus(Machinery machinery){
        System.out.print("Estado de la maquinaria: ");
        switch (machinery.getStatus()){
            case 1:
                System.out.println("Se encuentra en casa central");
                break;
            case 2:
                System.out.println("Se encuentra en viaje");
                break;
            case 3:
                System.out.println("Se encuentra en comercio");
                break;
            default:
                System.out.println("Error en el estado");
                break;
        }
    }

    public static void printFeatures(Machinery machinery){
        System.out.println("Descripcion: " + machinery.getFeatures());
    }

    public static void printClientInfo(Client client){
        ClientGraphics.printName(client);
        ClientGraphics.printZone(client);
    }
}
