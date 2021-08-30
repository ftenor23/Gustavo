package Graphics.Windows.Menu;

import Constants.SORT_CONSTANTS;
import Entity.Machinery;
import Enums.ServiceType;
import Graphics.Windows.Actions.AddMachinery;
import Graphics.Windows.Actions.AddService;
import Graphics.Windows.Actions.DeleteMachinery;
import Graphics.Windows.Actions.EditMachinery;
import Graphics.Windows.Info.ShowInfo;
import Graphics.Windows.Messages.MachineryGraphics;
import Graphics.Windows.Messages.Time;
import Graphics.Windows.PendingWindow;
import Graphics.Windows.Window;
import Manager.MachineryManager;
import Manager.PendingListManager;
import Manager.Sort;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import Graphics.Windows.Messages.Graphics;

public class Menu extends JMenuBar implements ActionListener {
    private final JMenu menuEdicion;
    private final JMenu menuInformacion;
    private final JMenu menuTabla;
    private final JMenu menuPendientes;
    private final JMenu menuService;
    private JMenuItem searchMachinery;
    private JMenuItem editMachinery;
    private JMenuItem deleteMachinery;
    private JMenuItem addMachinery;
    private JMenuItem showDevInfo;

    private JMenuItem sortByStatus;
    private JMenuItem sortByClient;
    private JMenuItem sortByHours;
    private JMenuItem sortByZone;
    private JMenuItem checkPending;
    private JMenuItem changeWaitingTime;
    private JMenuItem addService250;
    private JMenuItem addService1000;


    public Menu() {

        menuEdicion = new JMenu("Editar maquinaria");
        menuInformacion = new JMenu("Informacion");
        menuTabla = new JMenu("Tabla");
        menuService = new JMenu("Service");
        menuPendientes = new JMenu("Pendientes");
        setMenuFonts(new Font("arial", Font.PLAIN, 16));
        add(menuEdicion);
        add(menuTabla);
        add(menuPendientes);
        add(menuService);
        add(menuInformacion);

        addItems();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(searchMachinery)) {
            try {
                String id = Graphics.showMessage("Ingrese el ID de la maquinaria a buscar");
                MachineryGraphics.showInfo(MachineryManager.search(id));
                Window.setUpdate(true);
            } catch (Exception ex) {
                //esta seguro de que desea cancelar?
            }


        }
        if (e.getSource().equals(addMachinery)) {
            try {
                AddMachinery.enterData(Window.getMachineryList());
                Window.setUpdate(true);
            } catch (Exception ex) {
                System.out.println("Exception: " + ex);
            }

        }
        if (e.getSource().equals(editMachinery)) {
            EditMachinery.edit();
            Window.setUpdate(true);

        }
        if (e.getSource().equals(deleteMachinery)) {

            DeleteMachinery.delete();
            Window.setUpdate(true);

        }
        if (e.getSource().equals(showDevInfo)) {
            ShowInfo.showData();
            Window.setUpdate(true);

        }

        if (e.getSource().equals(sortByStatus)) {
            Window.setSortMode(SORT_CONSTANTS.STATUS);
            Window.setUpdate(true);

        }
        if (e.getSource().equals(sortByHours)) {
            Window.setSortMode(SORT_CONSTANTS.HOURS_OF_USE);
            Window.setUpdate(true);

        }
        if (e.getSource().equals(sortByClient)) {
            Window.setSortMode(SORT_CONSTANTS.CLIENT);
            Window.setUpdate(true);

        }
        if (e.getSource().equals(sortByZone)) {
            Window.setSortMode(SORT_CONSTANTS.ZONE);
            Window.setUpdate(true);

        }
        if (e.getSource().equals(checkPending)) {
            List<Machinery> machineryList = Sort.sortMachines(Window.getMachineryList(), SORT_CONSTANTS.PENDING);
            List<Machinery> onlyPendingList = PendingListManager.getOnlyPendingList(machineryList);
            if (onlyPendingList == null) {
                JOptionPane.showMessageDialog(null, "No hay lista de pendientes");
                return;
            }

            PendingWindow pendingWindow = new PendingWindow(onlyPendingList);
            pendingWindow.run();


        }
        if (e.getSource().equals(changeWaitingTime)) {
            int time = Time.enterTime();
            Window.setWaitingTime(time);
            Window.setUpdate(true);
            Time.confirmation(time);
        }

        if (e.getSource().equals(addService250)) {
            AddService.addService(ServiceType.SERVICE_250);
        }
        if (e.getSource().equals(addService1000)) {
            AddService.addService(ServiceType.SERVICE_1000);
        }

    }


    private void addItems() {
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
        changeWaitingTime = new JMenuItem("Cambiar el tiempo de actualizacion de pantalla");
        addService250 = new JMenuItem("Agregar service de 250hs realizado");
        addService1000 = new JMenuItem("Agregar service de 1000hs realizado");

        addActionListeners();

        setFonts(new Font("arial", Font.PLAIN, 16));


        menuEdicion.add(addMachinery);
        menuEdicion.add(editMachinery);
        menuEdicion.add(searchMachinery);
        menuEdicion.add(new JSeparator());
        menuEdicion.add(deleteMachinery);
        menuTabla.add(sortByHours);
        menuTabla.add(sortByStatus);
        menuTabla.add(sortByClient);
        menuTabla.add(sortByZone);
        menuTabla.add(changeWaitingTime);
        menuPendientes.add(checkPending);

        menuInformacion.add(showDevInfo);

        menuService.add(addService250);
        menuService.add(addService1000);
    }


    private void setFonts(Font font) {

        searchMachinery.setFont(font);
        editMachinery.setFont(font);
        deleteMachinery.setFont(font);
        addMachinery.setFont(font);
        showDevInfo.setFont(font);
        sortByStatus.setFont(font);
        sortByHours.setFont(font);
        sortByClient.setFont(font);
        sortByZone.setFont(font);
        checkPending.setFont(font);
        changeWaitingTime.setFont(font);
        addService1000.setFont(font);
        addService250.setFont(font);
    }

    private void setMenuFonts(Font font) {
        menuEdicion.setFont(font);
        menuInformacion.setFont(font);
        menuTabla.setFont(font);
        menuService.setFont(font);
        menuPendientes.setFont(font);
    }

    private void addActionListeners() {
        searchMachinery.addActionListener(this);
        editMachinery.addActionListener(this);
        deleteMachinery.addActionListener(this);
        addMachinery.addActionListener(this);
        showDevInfo.addActionListener(this);
        sortByStatus.addActionListener(this);
        sortByHours.addActionListener(this);
        sortByClient.addActionListener(this);
        sortByZone.addActionListener(this);
        checkPending.addActionListener(this);
        changeWaitingTime.addActionListener(this);
        addService250.addActionListener(this);
        addService1000.addActionListener(this);
    }

    //GETTERS Y SETTERS

    public JMenuItem getShowDevInfo() {
        return showDevInfo;
    }

    public JMenuItem getSearchMachinery() {
        return searchMachinery;
    }

    public JMenuItem getEditMachinery() {
        return editMachinery;
    }

    public JMenuItem getDeleteMachinery() {
        return deleteMachinery;
    }

    public JMenuItem getAddMachinery() {
        return addMachinery;
    }

}
