package Graphics;

import Manager.MachineryManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPendingWindow extends JMenuBar implements ActionListener {
    private final static String EDITAR = "Editar";
    private final static String ENTER_ID = "Ingrese el ID de la maquinaria a buscar";
    private JMenuItem editPending;
    private JMenuItem searchPending;

    public MenuPendingWindow() {

        JMenu menuEdicion = new JMenu(EDITAR);

        add(menuEdicion);

        addItems(menuEdicion);
    }

    private void addItems(JMenu menuEdicion) {
        editPending = new JMenuItem("Editar");
        searchPending = new JMenuItem("Buscar");

        editPending.addActionListener((ActionListener) this);
        searchPending.addActionListener((ActionListener) this);

        menuEdicion.add(editPending);
        menuEdicion.add(searchPending);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getEditPending())) {
            String id = Graphics.showMessage(ENTER_ID);
            EditMachinery.changePending(MachineryManager.search(id));
            //ACTUALIZAR EL ARCHIVO
            return;
        }
        if (e.getSource().equals(getSearchPending())) {
            String id = Graphics.showMessage(ENTER_ID);
            MachineryGraphics.showPending(MachineryManager.search(id));

            return;
        }
    }

    public JMenuItem getEditPending() {
        return editPending;
    }

    public JMenuItem getSearchPending() {
        return searchPending;
    }
}
