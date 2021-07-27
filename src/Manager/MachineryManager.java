package Manager;

import EnterData.EnterData;
import Entity.Client;
import Entity.Machinery;
import Graphics.MachineryGraphics;

import java.util.ArrayList;
import java.util.List;

public class MachineryManager {
    //no escribe datos al final del archivo
    public void changeStatus(Machinery machinery){
        MachineryGraphics.printActualStatus(machinery);
        MachineryGraphics.printStatusOptions();
        int status = EnterData.nextInt();
        machinery.setStatus(status);
    }

   /* public void changeClient(Machinery machinery){
        MachineryGraphics.changeClient();
        int clientNumber = EnterData.nextInt();

        Client client = ClientManager.getClient(clientNumber);
        machinery.setClient(client);
    }*/

    public List<Machinery> readArchive(){
        List<Machinery> list = new ArrayList<>();

        //leer archivo y cargarlo en lista

        return list;
    }

    public static Machinery enterData(){
        System.out.println("Ingrese el id de la maquinaria: ");
        String id = EnterData.nextLine();
        System.out.println("Ingrese el estado de la maquinaria");
        System.out.println("1:en casa central\n2:en viaje\n3: en comercio");
        int status=EnterData.nextInt(); //validar status
        System.out.println("Ingrese la descripcion de la maquinaria: ");
        String features=EnterData.nextLine();
        Client client = ClientManager.enterData();
        return new Machinery(id,status,client,features);
    }

    public static void printList(List<Machinery> list){
        for(int i=0; i<list.size();i++){
            int number=i+1;
            System.out.println("Maquinaria " + number + ":");
            MachineryGraphics.printMachineryData(list.get(i));
            System.out.println(" ");
        }
    }
}
