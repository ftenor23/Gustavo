package Main;

import Graphics.Windows.Window;
import Mapper.GenerateExamples;

public class Program {

    public static void main(String[] args) {


       Window window = new Window();
       window.run();
        GenerateExamples.generate();
        /*List<Machinery> list = Bin.readObjetsAndAddToList();
        for(int i = 0; i<list.size();i++){
            Bin.saveInDB(list.get(i));
        }*/
    }
}
