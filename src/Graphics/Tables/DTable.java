package Graphics.Tables;

import Entity.Machinery;
import Manager.MachineryManager;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class DTable extends JTable {
    private final static int HOURS_OF_USE_COLUMN = 5;
    private final static int ID_COLUMN = 1;
    private final static int SERVICE_1000 = 1000;
    private final static int SERVICE_250 = 250;
    private final static int MAX_HOURS = 8000; //Cuando se cumplen 8000 hs, se debe retirar al a maquina

    public Component prepareRenderer(TableCellRenderer renderer, int rowIndex, int colIndex) {
        Component component = super.prepareRenderer(renderer, rowIndex, colIndex);
        try {

            component.setBackground(Color.white);
            component.setForeground(Color.BLACK);

            if (colIndex == HOURS_OF_USE_COLUMN) {
                int hoursSince250hsService = Integer.parseInt(getValueAt(rowIndex, colIndex).toString());
                String id = getValueAt(rowIndex, ID_COLUMN).toString();
                Machinery machinery = MachineryManager.search(id);
                if (machinery == null) {
                    return component;
                }
                //obtiene la cantidad de horas desde el ultimo service e imprime color segun el caso
                int hsSinceLast1000hsService = machinery.getHsSinceLast1000hsService();

                int totalHours = machinery.getTotalHours();


                if (totalOf8000hs(totalHours)) {
                    component.setBackground(Color.RED);
                    component.setForeground(Color.WHITE);
                }

                if (service1000(hsSinceLast1000hsService)) {
                    component.setBackground(Color.YELLOW);
                    component.setForeground(Color.RED);
                } else if (service250(hoursSince250hsService)) {
                    component.setBackground(Color.GREEN);
                    component.setForeground(Color.BLACK);
                }


            }
        }catch(Exception e){
            System.out.println("Exception: " + e);
        }

        return component;
    }

    private boolean service1000(int totalHours) {
        return totalHours > SERVICE_1000;
    }

    private boolean service250(int hoursSince250hsService) {
        return hoursSince250hsService > SERVICE_250;
    }

    private boolean totalOf8000hs(int totalHours) {
        return totalHours > MAX_HOURS;
    }
}
