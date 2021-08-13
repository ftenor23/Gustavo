package Graphics;

import Entity.Client;



public class ClientGraphics {
    public static String printName(Client client){
        return "Nombre del cliente: " + client.getName() + "\n";
    }

    public static String printZone(Client client){
        String response = "Ubicacion: ";

        switch (client.getZone()){
            case 1:
                response+="Zona norte";
                break;
            case 2:
                response+="Zona oeste";
                break;
            case 3:
                response+="Zona sur";
                break;
            case 4:
                response+="Capital federal";
                break;
            default:
                response+="Zona no registrada";
                break;
        }
        return response + "\n";
    }
}
