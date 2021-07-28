package Graphics;

import Entity.Client;



public class ClientGraphics {
    public static void printName(Client client){
        System.out.println("Nombre del cliente: " + client.getName());
    }

    public static void printZone(Client client){
        System.out.print("Ubicacion: ");
        switch (client.getZone()){
            case 1:
                System.out.println("Zona norte");
                break;
            case 2:
                System.out.println("Zona oeste");
                break;
            case 3:
                System.out.println("Zona sur");
                break;
            case 4:
                System.out.println("Capital federal");
                break;
            default:
                System.out.println("Zona no registrada");
                break;
        }
    }
}
