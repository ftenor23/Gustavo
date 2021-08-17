package Graphics;

import Entity.Machinery;
import Mapper.Bin;

import javax.swing.*;
import java.util.List;

public abstract class Table {
    private JTable table;
    private TMMachinery model;


    public static DTable getTable(List<Machinery> list){

        DTable table = new DTable();
        TMMachinery model = new TMMachinery(list);
        table.setModel(model);
        //table.setFont(new Font("Arial",Font.PLAIN,16));
        //table.setBackground(new Color(192,192,192));
        return table;
    }
}
