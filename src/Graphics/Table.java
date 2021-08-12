package Graphics;

import BinArchive.Bin;
import Entity.Machinery;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public abstract class Table {
    private JTable table;
    private TMMachinery model;


    public static JTable getTable(){

        DTable table = new DTable();
        TMMachinery model = new TMMachinery(Bin.readObjetsAndAddToList());
        table.setModel(model);
        //table.setBackground(new Color(192,192,192));
        return table;
    }
}
