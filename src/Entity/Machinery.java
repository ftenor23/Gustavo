package Entity;

import java.io.Serializable;

public class Machinery implements Serializable {
    private String id;
    private int status; //1:en casa central, 2:en viaje, 3: en comercio; 4 pasado a ventas o dado de baja
    private Client client;
    private String features;
    private String pending;
    private int hoursOfUse;
    private boolean service_250;
    private boolean service_1000;
    //agregar variable que indique si se le hicieron los service cada 250 horas
    //caracteristicas

    public Machinery() {
        service_250=false;
        service_1000=false;
    }

    public String getPending() {
        return pending;
    }

    public String getClientName(){
        String name = getClient().getName();
        if(name==null){
            return " ";
        }
        return name;
    }

    public boolean isService_250() {
        return service_250;
    }

    public void setService_250(boolean service_250) {
        this.service_250 = service_250;
    }

    public boolean isService_1000() {
        return service_1000;
    }

    public void setService_1000(boolean service_1000) {
        this.service_1000 = service_1000;
    }

    public int getClientZone(){
        return getClient().getZone();
    }

    public void setPending(String pending) {
        this.pending = pending;
    }

    public int getHoursOfUse() {
        return hoursOfUse;
    }

    public void setHoursOfUse(int hoursOfUse) {
        this.hoursOfUse = hoursOfUse;
    }
    //agregar String pendientes;
//agregar variable horas de uso y calcular horas para ver si hay que hace service
    //filtro 250 cambio de aceite, etc filtro


    public Machinery(String id, int status, Client client, String features, int hoursOfUse) {
        this.id = id;
        this.status = status;
        this.client = client;
        this.features = features;
        this.pending = " ";
        this.hoursOfUse = hoursOfUse;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }
}
