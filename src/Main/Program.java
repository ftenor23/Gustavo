package Main;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import BinArchive.Bin;
import Entity.Machinery;
import Graphics.TMMachinery;
import Graphics.Window;
import Manager.MachineryManager;

public class Program {


    public static void main(String[] args) {
        MachineryManager.saveMachinesInOrder(Bin.readObjetsAndAddToList(),"ID");
        Window window = new Window(); //agregar barrra de menu

    }
}
