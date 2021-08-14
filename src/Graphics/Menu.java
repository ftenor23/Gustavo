package Graphics;

import BinArchive.Bin;
import Manager.MachineryManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JMenuBar implements ActionListener{
    private final static String ARCHIVO = "Archivo";
    private final static String EDITAR = "Editar";
    private JMenuItem searchMachinery;
    private JMenuItem editMachinery;
    private JMenuItem deleteMachinery;
    private JMenuItem addMachinery;
    private JMenuItem showDevInfo;
    private JMenuItem update;
    private JMenuItem sortByStatus;
    private JMenuItem sortByClient;
    private JMenuItem sortByHours;
    private TMMachinery model;

    public Menu() {

        JMenu menuEdicion = new JMenu("Editar maquinaria");
        JMenu menuInformacion = new JMenu("Informacion");
        JMenu menuTabla = new JMenu("Tabla");
        add(menuEdicion);
        add(menuTabla);
        add(menuInformacion);

        addItems(menuEdicion,menuInformacion,menuTabla);
    }

    private void addItems(JMenu menuEdicion, JMenu menuInformacion, JMenu menuTabla){
        searchMachinery = new JMenuItem("Buscar por id");
        editMachinery = new JMenuItem("Editar");
        deleteMachinery = new JMenuItem("Eliminar");
        addMachinery = new JMenuItem("Agregar");
        showDevInfo = new JMenuItem("Acerca de");
        sortByHours = new JMenuItem("Ordenar por cantidad de horas sin mantenimiento");
        sortByStatus = new JMenuItem("Ordenar por estado");


        searchMachinery.addActionListener((ActionListener) this);
        editMachinery.addActionListener((ActionListener) this);
        deleteMachinery.addActionListener((ActionListener) this);
        addMachinery.addActionListener((ActionListener) this);
        showDevInfo.addActionListener((ActionListener) this);
        sortByStatus.addActionListener((ActionListener) this);
        sortByHours.addActionListener((ActionListener) this);


        menuEdicion.add(addMachinery);
        menuEdicion.add(editMachinery);
        menuEdicion.add(searchMachinery);
        menuEdicion.add(new JSeparator());
        menuEdicion.add(deleteMachinery);
        menuTabla.add(sortByHours);
        menuTabla.add(sortByStatus);

        menuInformacion.add(showDevInfo);
    }

    public JMenuItem getShowDevInfo() {
        return showDevInfo;
    }

    public void setShowDevInfo(JMenuItem showDevInfo) {
        this.showDevInfo = showDevInfo;
    }

    public JMenuItem getSearchMachinery() {
        return searchMachinery;
    }

    public void setSearchMachinery(JMenuItem searchMachinery) {
        this.searchMachinery = searchMachinery;
    }

    public JMenuItem getEditMachinery() {
        return editMachinery;
    }

    public void setEditMachinery(JMenuItem editMachinery) {
        this.editMachinery = editMachinery;
    }

    public JMenuItem getUpdate() {
        return update;
    }

    public void setUpdate(JMenuItem update) {
        this.update = update;
    }

    public JMenuItem getDeleteMachinery() {
        return deleteMachinery;
    }

    public void setDeleteMachinery(JMenuItem deleteMachinery) {
        this.deleteMachinery = deleteMachinery;
    }

    public JMenuItem getAddMachinery() {
        return addMachinery;
    }

    public void setAddMachinery(JMenuItem addMachinery) {
        this.addMachinery = addMachinery;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(getSearchMachinery())){
            try{
                String id = Graphics.showMessage("Ingrese el ID de la maquinaria a buscar");
                MachineryGraphics.showInfo(MachineryManager.search(id));
                Window.setUpdate(true);
            }catch(Exception ex){
                //esta seguro de que desea cancelar?
            }

            return;
        }
        if(e.getSource().equals(getAddMachinery())){
            try {
                AddMachinery.enterData();
                Window.setUpdate(true);
            }catch(Exception ex){

            }
            return;
        }
        if(e.getSource().equals(getEditMachinery())){
            EditMachinery.edit();
            Window.setUpdate(true);
            return;
        }
        if(e.getSource().equals(getDeleteMachinery())){
            DeleteMachinery.delete();
            Window.setUpdate(true);
            return;
        }
        if(e.getSource().equals(getShowDevInfo())){
            ShowInfo.showData();
            Window.setUpdate(true);
            return;
        }
        if(e.getSource().equals(getUpdate())){
            Window.setUpdate(true);
           // Window.setTable(Table.getTable());
            return;
        }
        if(e.getSource().equals(sortByStatus)){
            Window.setSortMode(1);
            Window.setUpdate(true);
            return;
        }
        if(e.getSource().equals(sortByHours)){
            Window.setSortMode(2);
            Window.setUpdate(true);
            return;
        }
    }

    public TMMachinery getModel() {
        return model;
    }


}
