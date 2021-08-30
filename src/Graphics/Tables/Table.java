package Graphics.Tables;

import Entity.Machinery;
import Graphics.Tables.TableModels.TMMachinery;
import Graphics.Tables.TableModels.TMPending;


import java.awt.*;
import java.util.List;

public abstract class Table {


    public static DTable getTable(List<Machinery> list) {

        DTable table = new DTable();
        TMMachinery model = new TMMachinery(list);
        table.setModel(model);
        table.setFont(new Font("Arial", Font.BOLD, 30));
        table.setBackground(new Color(192, 192, 192));
        table.setRowHeight(59);

        return table;
    }


    public static DTable getPendingTable(List<Machinery> list) {

        DTable table = new DTable();
        TMPending model = new TMPending(list);
        table.setModel(model);
        table.setRowHeight(59);
        table.setFont(new Font("Arial", Font.PLAIN, 30));
        table.setBackground(new Color(192, 192, 192));
        return table;
    }

}
