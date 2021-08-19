package Graphics;

import Entity.Machinery;
import Manager.StatusManager;
import Manager.ZoneManager;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.List;

public class TMPending implements TableModel {
    private List<Machinery> list;
    private final static int COLUMNS = 2;
    public TMPending(List<Machinery> machineryList){
        this.list=machineryList;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNS;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String title=null;
        switch (columnIndex){
            case 0:
                title="ID";
                break;
            case 1:
                title="Pendientes";
                break;
        }
        return title;

    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Machinery machinery = list.get(rowIndex);
        switch (columnIndex){
            case 0:
                return machinery.getId();
            case 1:
                return machinery.getPending();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Machinery machinery = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                machinery.setId(aValue.toString());
                break;
            case 1:
                machinery.setPending(aValue.toString());
                break;
        }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}
