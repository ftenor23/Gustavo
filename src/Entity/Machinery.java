package Entity;

import java.io.Serializable;


public class Machinery implements Serializable {
    private String id;
    private int status; //1:en casa central, 2:en viaje, 3: en comercio; 4 pasado a ventas o dado de baja
    private Client client;
    private String features;
    private String pending;
    private int hsSinceLast250hsService;
    private int hsSinceLast1000hsService;
    private int totalHours;

    //agregar variable que indique si se le hicieron los service cada 250 horas
    //caracteristicas
    public Machinery(String id, int status, Client client, String features, int hsSinceLast250hsService, int hsSinceLast1000hsService, int totalHours) {
        this.id = id;
        this.status = status;
        this.client = client;
        this.features = features;
        this.pending = "";
        this.hsSinceLast250hsService = hsSinceLast250hsService;
        this.hsSinceLast1000hsService = hsSinceLast1000hsService;
        //preguntar a gus
        this.totalHours = totalHours;
    }

    public String getPending() {
        return pending;
    }

    public String getClientName() {

        return getClient().getName();

    }

    public int getHsSinceLast1000hsService() {
        return hsSinceLast1000hsService;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public int getHsSinceLast250hsService() {
        return hsSinceLast250hsService;
    }

    public void setHsSinceLast1000hsService(int totalHours) {
        this.hsSinceLast1000hsService = totalHours;
    }

    public int getClientZone() {
        return getClient().getZone();
    }

    public void setPending(String pending) {
        this.pending = pending;
    }

    public int getHoursOfUse() {
        return hsSinceLast250hsService;
    }

    public void setHoursOfUse(int hoursOfUse) {

        this.hsSinceLast250hsService = hoursOfUse;
        this.hsSinceLast1000hsService += hoursOfUse;
        this.totalHours += hoursOfUse;
    }
    //agregar String pendientes;
//agregar variable horas de uso y calcular horas para ver si hay que hace service
    //filtro 250 cambio de aceite, etc filtro


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
