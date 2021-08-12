package Graphics;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class DTable extends JTable {
    private final static int HOURS_OF_USE_COLUMN = 6;
    public Component prepareRenderer(TableCellRenderer renderer, int rowIndex, int colIndex){
        Component component = super.prepareRenderer(renderer,rowIndex,colIndex);
        component.setBackground(Color.white);
        component.setForeground(Color.BLACK);

        if(colIndex==HOURS_OF_USE_COLUMN){
            int value = Integer.parseInt(getValueAt(rowIndex,colIndex).toString());
            if(value > 250 && value < 1000){
                component.setBackground(Color.YELLOW);
                component.setForeground(Color.RED);
            }
            if(value>=1000){
                component.setBackground(Color.RED);
                component.setForeground(Color.WHITE);
            }

        }
        return component;
    }
}
