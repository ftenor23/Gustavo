package Manager;

import Mapper.Bin;
import Constants.SORT_CONSTANTS;
import EnterData.EnterData;
import Entity.Client;
import Entity.Machinery;
import Graphics.MachineryGraphics;

import javax.crypto.Mac;
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

    public static Machinery enterData(){
        System.out.println("Ingrese el id de la maquinaria: ");
        String id = EnterData.nextLine();
        System.out.println("Ingrese el estado de la maquinaria");
        System.out.println("1:en casa central\n2:en viaje\n3: en comercio");
        int status=EnterData.nextInt(); //validar status
        System.out.println("Ingrese la descripcion de la maquinaria: ");
        String features=EnterData.nextLine();
        Client client = ClientManager.enterData();
        System.out.println("Ingrese las horas de uso:");
        int hoursOfUse = EnterData.nextInt();
        return new Machinery(id,status,client,features, hoursOfUse);
    }

    public static void printList(List<Machinery> list){

        for(int i=0; i<list.size();i++){
            int number=i+1;
            System.out.println("Maquinaria " + number + ":");
            System.out.println(MachineryGraphics.printMachineryData(list.get(i)));
            System.out.println(" ");
        }
    }



    public static void saveMachinesInOrder(List<Machinery> list, String sortBy){
        Sort.sortMachines(list, sortBy); //SIEMPRE SE TINENE QUE GUARDAR POR ID. A LA HORA DE MOSTRARLAS EN PANTALLA
        //SE PUEDEN ORDENAR POR ALGUN CRITERIO A ALECCION DEL USUARIO
        Bin.overwriteArchive(list);
    }

    public static void saveNewMachine(Machinery machinery, List<Machinery> list){

        list.add(machinery);
        saveMachinesInOrder(list, SORT_CONSTANTS.ID);
    }

    public static void writeInDisc(Machinery machinery){
        Bin.addNewMachinery(machinery);
    }

//funciona no tocar
    public static int binarySearch(List<Machinery> list, String idToSearch) {
            int inicio = 0;
            int fin = list.size()-1;
            int pos;
            while (inicio <= fin) {
                pos = (inicio+fin) / 2;
                if (list.get(pos).getId().equalsIgnoreCase(idToSearch)) {
                    return pos;
                }else if (list.get(pos).getId().compareTo(idToSearch) < 0 ) {
                    inicio = pos+1;
                } else if (list.get(pos).getId().compareTo(idToSearch) > 0 ) {
                    fin = pos-1;
                }
            }
            return -1;
        }




    public static Machinery search(String id){
        int pos = binarySearch(Bin.readObjetsAndAddToList(),id);
        if(pos>-1) {
            return Bin.readObjetsAndAddToList().get(pos);
        } return null;

    }

    public static int getMachineryPosition(String id){
        return binarySearch(Bin.readObjetsAndAddToList(),id);
    }


    private static void replaceMachine(Machinery machinery){
        List<Machinery> machineryList = Bin.readObjetsAndAddToList();
        machineryList.remove(binarySearch(machineryList, machinery.getId()));
        machineryList.add(machinery);
        saveMachinesInOrder(machineryList,SORT_CONSTANTS.ID);
    }

    public static void changeFeatures(Machinery machinery, String line){
        machinery.setFeatures(line);
        replaceMachine(machinery);
    }

    public static void changeClient(Machinery machinery, Client client){
        machinery.setClient(client);
        replaceMachine(machinery);
    }

    public static void changePending(Machinery machinery, String line){
        machinery.setPending(line);
        replaceMachine(machinery);
    }

    public static void changeHours(Machinery machinery, int hours){
        machinery.setHoursOfUse(machinery.getHoursOfUse() + hours);
        //preguntar a gus si quiere que cuando nos pasamos de 1000 lo cambiemos automatico
        replaceMachine(machinery);
    }

    public static boolean deleteMachine(String id){
        List<Machinery> machineryList = Bin.readObjetsAndAddToList();
        int pos = binarySearch(machineryList,id);
        if(pos>-1){
            machineryList.remove(pos);
            saveMachinesInOrder(machineryList,SORT_CONSTANTS.ID);
            return true;
        }
        return false;
    }

    public static void serService250(Machinery machinery){
        machinery.setService_250(true);
        replaceMachine(machinery);
    }

    public static void serService1000(Machinery machinery){
        machinery.setService_1000(true);
        replaceMachine(machinery);
    }
}
