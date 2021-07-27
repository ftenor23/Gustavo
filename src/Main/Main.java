package Main;

import BinArchive.Bin;
import Entity.Client;
import Entity.Machinery;
import Manager.MachineryManager;

import java.util.List;

public class Main {
    //deberia leer el archivo de maquinaria y tenerlo siempre en memoria
    public static void main(String[] args) {
        //Machinery machinery = new Machinery("124",1,new Client("Juan", 2), "Maquinaria pesada");
        Bin bin = new Bin();
        //bin.writeMachineryInDisc(); //sobreescribe el archi REVISAR
        List<Machinery> list = bin.readObjetsAndAddToList();
        MachineryManager.printList(list);

        bin.writeMachineryInDisc();
        list.clear();
        list = bin.readObjetsAndAddToList();
        MachineryManager.printList(list);
    }

}
