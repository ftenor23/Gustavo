package Main;

import BinArchive.Bin;
import Manager.MachineryManager;

public class Main {
    //deberia leer el archivo de maquinaria y tenerlo siempre en memoria
    private final static String ID = "ID";
    private final static  String ZONE = "ZONE";
    private final static  String HOURS_OF_USE = "HOURS OF USE";

    public static void main(String[] args) {
        //Machinery machinery = new Machinery("124",1,new Client("Juan", 2), "Maquinaria pesada");
        Bin bin = new Bin();
        //bin.writeMachineryInDisc(); //sobreescribe el archi REVISAR
        /*List<Machinery> list = bin.readObjetsAndAddToList();
        MachineryManager.printList(list);
*/

        //MachineryManager.search();





    }

}
