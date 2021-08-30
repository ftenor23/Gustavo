package Graphics.Windows.Actions;

import Entity.Machinery;
import Enums.ServiceType;
import Manager.MachineryManager;

import javax.swing.*;

public abstract class AddService extends EditMachinery{

    public static void addService(Enum e){

        Machinery machinery = enterData();

        if(machinery==null){
            JOptionPane.showMessageDialog(null,MACHINE_NOT_FOUND);
            return;
        }

        MachineryManager.setService(e,machinery);

        JOptionPane.showMessageDialog(null, serviceDone(e));
    }


    private static String serviceDone(Enum e){
        String servicesHs=null;
        if(e.equals(ServiceType.SERVICE_250)){
            servicesHs="250";
        }
        if(e.equals(ServiceType.SERVICE_1000)){
            servicesHs="1000";
        }

        return "Se realizo el service de " + servicesHs + " horas";
    }

}
