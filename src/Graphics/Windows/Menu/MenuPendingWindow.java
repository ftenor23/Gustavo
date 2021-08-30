package Graphics.Windows.Menu;

import Entity.Machinery;
import Graphics.Windows.Actions.EditMachinery;
import Graphics.Windows.Messages.MachineryGraphics;
import Graphics.Windows.PendingWindow;
import Manager.MachineryManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Graphics.Windows.Messages.Graphics.showMessage;

public class MenuPendingWindow extends JMenuBar implements ActionListener {
    private final static String EDITAR = "Editar";
    private final static String ENTER_ID = "Ingrese el ID de la maquinaria a buscar";
    private final static String MACHINE_NOT_FOUND = "No se encontro a la maquinaria ";
    private JMenuItem editPending;
    private JMenuItem searchPending;

    public MenuPendingWindow() {

        JMenu menuEdicion = new JMenu(EDITAR);
        menuEdicion.setFont(new Font("arial", Font.PLAIN, 16));
        add(menuEdicion);

        addItems(menuEdicion);
    }

    private void addItems(JMenu menuEdicion) {
        editPending = new JMenuItem("Editar");
        searchPending = new JMenuItem("Buscar");

        addActionListener();
        setFonts(new Font("arial", Font.PLAIN, 16));
        menuEdicion.add(editPending);
        menuEdicion.add(searchPending);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getEditPending())) {
            String id = showMessage(ENTER_ID);
            Machinery machinery = MachineryManager.search(id);
            if (machinery != null) {
                EditMachinery.changePending(machinery);
                PendingWindow.addMachinery(machinery);
                PendingWindow.setUpdate(true);
                JOptionPane.showMessageDialog(null, dataUpdated(id));
            } else {
                JOptionPane.showMessageDialog(null, MACHINE_NOT_FOUND + id);
            }

        }
        if (e.getSource().equals(getSearchPending())) {
            String id = showMessage(ENTER_ID);
            MachineryGraphics.showPending(MachineryManager.search(id));
        }
    }

    public JMenuItem getEditPending() {
        return editPending;
    }

    public JMenuItem getSearchPending() {
        return searchPending;
    }

    private void setFonts(Font font) {
        editPending.setFont(font);
        searchPending.setFont(font);
    }

    private void addActionListener() {
        editPending.addActionListener(this);
        searchPending.addActionListener(this);
    }

    private static String dataUpdated(String id) {
        return "Datos de la maquinaria " + id + " actualizados." +
                " Cierre la ventana de pendientes para actualizar.";
    }
}
