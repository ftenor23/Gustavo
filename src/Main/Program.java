package Main;

import Entity.Machinery;
import Graphics.Window;
import Mapper.Bin;
import Mapper.GenerateExamples;

import javax.crypto.Mac;
import java.util.List;

public class Program {
    private final static int MACHINES_PER_PAGE = 5;


    public static void main(String[] args) {


       Window window = new Window();
       window.run();
        //GenerateExamples.generate();
        /*List<Machinery> list = Bin.readObjetsAndAddToList();
        for(int i = 0; i<list.size();i++){
            Bin.saveInDB(list.get(i));
        }*/
    }
}
