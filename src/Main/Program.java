package Main;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import BinArchive.Bin;
import Entity.Machinery;
import Graphics.TMMachinery;
public class Program {


    public static void main(String[] args) {
        JFrame frame = new JFrame("Maquinaria");
        JTable table = new JTable();
        List<Machinery> machineryList = Bin.readObjetsAndAddToList();
        TMMachinery model = new TMMachinery(machineryList);
        table.setModel(model);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0,1));
        frame.setSize(1000,1000);
        frame.setLocationRelativeTo(null);
        frame.add(table);
        JScrollPane s = new JScrollPane(table); //barra de desplazamiento
        frame.getContentPane().add(s,BorderLayout.PAGE_START);
        s.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        s.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        frame.setVisible(true);
    }
}
