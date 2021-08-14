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
    private TMMachinery model;

    public Menu() {

        JMenu menuEdicion = new JMenu("Editar maquinaria");
        JMenu menuInformacion = new JMenu("Informacion");
        add(menuEdicion);
        add(menuInformacion);

        searchMachinery = new JMenuItem("Buscar por id");
        editMachinery = new JMenuItem("Editar");
        deleteMachinery = new JMenuItem("Eliminar");
        addMachinery = new JMenuItem("Agregar");
        showDevInfo = new JMenuItem("Acerca de");


        searchMachinery.addActionListener((ActionListener) this);
        editMachinery.addActionListener((ActionListener) this);
        deleteMachinery.addActionListener((ActionListener) this);
        addMachinery.addActionListener((ActionListener) this);
        showDevInfo.addActionListener((ActionListener) this);


        menuEdicion.add(addMachinery);
        menuEdicion.add(editMachinery);
        menuEdicion.add(searchMachinery);
        menuEdicion.add(new JSeparator());
        menuEdicion.add(deleteMachinery);

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
            String id = Graphics.showMessage("Ingrese el ID de la maquinaria a buscar");
            MachineryGraphics.showInfo(MachineryManager.search(id));
            Window.setUpdate(true);
            return;
        }
        if(e.getSource().equals(getAddMachinery())){
            AddMachinery.enterData();
            Window.setUpdate(true);
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
    }

    public TMMachinery getModel() {
        return model;
    }


}
