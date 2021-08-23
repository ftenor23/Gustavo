package Graphics;

import Entity.Machinery;
import Manager.StatusManager;
import Manager.ZoneManager;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.List;

public class TMMachinery implements TableModel {
    private List<Machinery> machineryList;
    private static final int COLUMNS=6;

    public TMMachinery(List<Machinery> list){
        this.machineryList =list;
    }
    @Override
    public int getRowCount() {
        return machineryList.size();

        //aca deberia crear una funcion para definir cuantas muestr a la vez por pantalla
    }

    @Override
    public int getColumnCount() {
        //cuantas columnas muestro (verificar con gustavo la info que necesita mostrar)
        return COLUMNS;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String title=null;
        switch (columnIndex){
            case 1:
                title="ID";
                break;
            case 2:
                title="Estado";
                break;
            case 3:
                title="Cliente";
                break;
            case 0:
                title="Zona";
                break;
            case 4:
                title="Caracteristicas";
                break;
            case 5:/*
                title="Pendientes";
                break;
            case 6:*/
                title="Horas de uso";
                break;
        }
        return title;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex!=5 && columnIndex!=1){
            return String.class;
        }
        return Integer.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Machinery machinery = machineryList.get(rowIndex);
        switch (columnIndex){
            case 1:
                return machinery.getId();
            case 2:
                int status = machinery.getStatus();
                return StatusManager.getStatus(status);
            case 3:
                String name = machinery.getClientName();
                if(name==null){
                    return "";
                }
                return name;

            case 0:
                int zone = machinery.getClient().getZone();
                return ZoneManager.getZone(zone);
            case 4:
                return machinery.getFeatures();
            case 5:/*
                return machinery.getPending();
            case 6:*/
                return machinery.getHoursOfUse();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Machinery machinery = machineryList.get(rowIndex);
        switch (columnIndex) {
            case 1:
                machinery.setId(aValue.toString());
                break;
            case 2:
                machinery.setStatus((Integer) aValue);
                break;
            case 3:
                machinery.getClient().setName(aValue.toString());
                break;
            case 0:
                machinery.getClient().setZone((Integer) aValue);
                break;//verificar si le paso string o int
            case 4:
                machinery.setFeatures(aValue.toString());
                break;
            case 5:
                /*machinery.setPending(aValue.toString());
                break;
            case 6:*/
                machinery.setHoursOfUse((Integer) aValue);
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
