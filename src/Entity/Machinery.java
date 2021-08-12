package Entity;

import java.io.Serializable;

public class Machinery implements Serializable {
    private String id;
    private int status; //1:en casa central, 2:en viaje, 3: en comercio; 4 pasado a ventas o dado de baja
    private Client client;
    private String features;
    private String pending;
    private int hoursOfUse;
    //agregar variable que indique si se le hicieron los service cada 250 horas
    //caracteristicas

    public String getPending() {
        return pending;
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
