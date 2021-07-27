package Manager;

import EnterData.EnterData;
import Entity.Client;

public class ClientManager {

   /*public static Client getClient(int num){
        Client client;
        //con el numero ingresado, buscamos en el archivo binario el numero correcto
        return client;
    }*/

    public static Client enterData(){
        System.out.println("Ingrese el nombre del cliente: ");
        String clientName = EnterData.nextLine();
        System.out.println("Ingrese la zona del cliente");
        System.out.println("1)norte\n2)oeste\n3)sur\n4)capital");
        int clientZone = EnterData.nextInt();
        return new Client(clientName,clientZone);
    }
}
