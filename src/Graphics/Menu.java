package Graphics;

import Constants.SORT_CONSTANTS;
import Entity.Machinery;
import Manager.MachineryManager;
import Manager.PendingListManager;
import Manager.Sort;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
    private JMenuItem sortByZone;
    private JMenuItem checkPending;
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

    public JMenuItem getSortByStatus() {
        return sortByStatus;
    }

    public void setSortByStatus(JMenuItem sortByStatus) {
        this.sortByStatus = sortByStatus;
    }

    public JMenuItem getSortByClient() {
        return sortByClient;
    }

    public void setSortByClient(JMenuItem sortByClient) {
        this.sortByClient = sortByClient;
    }

    public JMenuItem getSortByHours() {
        return sortByHours;
    }

    public void setSortByHours(JMenuItem sortByHours) {
        this.sortByHours = sortByHours;
    }

    public JMenuItem getSortByZone() {
        return sortByZone;
    }

    public void setSortByZone(JMenuItem sortByZone) {
        this.sortByZone = sortByZone;
    }

    private void addItems(JMenu menuEdicion, JMenu menuInformacion, JMenu menuTabla){
        searchMachinery = new JMenuItem("Buscar por id");
        editMachinery = new JMenuItem("Editar");
        deleteMachinery = new JMenuItem("Eliminar");
        addMachinery = new JMenuItem("Agregar");
        showDevInfo = new JMenuItem("Acerca de");
        sortByHours = new JMenuItem("Ordenar por cantidad de horas sin mantenimiento");
        sortByStatus = new JMenuItem("Ordenar por estado");
        sortByClient = new JMenuItem("Ordenar por cliente");
        sortByZone = new JMenuItem("Ordenar por zona");
        checkPending = new JMenuItem("Consultar pendientes");


        searchMachinery.addActionListener((ActionListener) this);
        editMachinery.addActionListener((ActionListener) this);
        deleteMachinery.addActionListener((ActionListener) this);
        addMachinery.addActionListener((ActionListener) this);
        showDevInfo.addActionListener((ActionListener) this);
        sortByStatus.addActionListener((ActionListener) this);
        sortByHours.addActionListener((ActionListener) this);
        sortByClient.addActionListener((ActionListener) this);
        sortByZone.addActionListener((ActionListener) this);
        checkPending.addActionListener((ActionListener) this);


        menuEdicion.add(addMachinery);
        menuEdicion.add(editMachinery);
        menuEdicion.add(searchMachinery);
        menuEdicion.add(new JSeparator());
        menuEdicion.add(deleteMachinery);
        menuTabla.add(sortByHours);
        menuTabla.add(sortByStatus);
        menuTabla.add(sortByClient);
        menuTabla.add(sortByZone);
        menuTabla.add(checkPending);

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

    public JMenuItem getCheckPending() {
        return checkPending;
    }

    public void setCheckPending(JMenuItem checkPending) {
        this.checkPending = checkPending;
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
                AddMachinery.enterData(Window.getMachineryList());
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
        if(e.getSource().equals(getSortByStatus())){
            Window.setSortMode(SORT_CONSTANTS.STATUS);
            Window.setUpdate(true);
            return;
        }
        if(e.getSource().equals(getSortByHours())){
            Window.setSortMode(SORT_CONSTANTS.HOURS_OF_USE);
            Window.setUpdate(true);
            return;
        }
        if(e.getSource().equals(getSortByClient())){
            Window.setSortMode(SORT_CONSTANTS.CLIENT);
            Window.setUpdate(true);
            return;
        }
        if(e.getSource().equals(getSortByZone())){
            Window.setSortMode(SORT_CONSTANTS.ZONE);
            Window.setUpdate(true);
            return;
        }
        if(e.getSource().equals(getCheckPending())){
            List<Machinery> machineryList = Sort.sortMachines(Window.getMachineryList(),SORT_CONSTANTS.PENDING);
            MachineryManager.printList(machineryList);
            List<Machinery> onlyPendingList = PendingListManager.getOnlyPendingList(machineryList);
            if(onlyPendingList==null){
                JOptionPane.showMessageDialog(null, "No hay lista de pendientes");
                return;
            }
            PendingWindow pendingWindow = new PendingWindow(onlyPendingList);
            pendingWindow.run();
            return;
        }

    }

    public TMMachinery getModel() {
        return model;
    }


}
