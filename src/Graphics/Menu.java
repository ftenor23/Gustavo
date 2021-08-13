package Graphics;

import Manager.MachineryManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JMenuBar implements ActionListener{
    private final static String ARCHIVO = "Archivo";
    private final static String EDITAR = "Editar";
    private JMenuItem searchMachinery;
    private JMenuItem editMachinery;
    private JMenuItem deleteMachinery;
    private JMenuItem addMachinery;

    public Menu() {

        JMenu menuArchivo = new JMenu("Editar maquinaria");
        JMenu menuEditar = new JMenu("Informacion");
        add(menuArchivo);
        add(menuEditar);

        searchMachinery = new JMenuItem("Buscar por id");
       editMachinery = new JMenuItem("Editar");
        deleteMachinery = new JMenuItem("Eliminar");
        addMachinery = new JMenuItem("Agregar");

        searchMachinery.addActionListener((ActionListener) this);
        editMachinery.addActionListener((ActionListener) this);
        deleteMachinery.addActionListener((ActionListener) this);
        addMachinery.addActionListener((ActionListener) this);

        menuArchivo.add(addMachinery);
        menuArchivo.add(editMachinery);
        menuArchivo.add(searchMachinery);
        menuArchivo.add(new JSeparator());
        menuArchivo.add(deleteMachinery);

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
        }
    }
}
