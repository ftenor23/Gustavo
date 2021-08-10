package Entity;

import java.io.Serializable;

public class Machinery implements Serializable {
    private String id;
    private int status; //1:en casa central, 2:en viaje, 3: en comercio; 4 pasado a ventas o dado de baja
    private Client client;
    private String features; //caracteristicas
//agregar variable horas de uso y calcular horas para ver si hay que hace service
    public Machinery(String id, int status, Client client, String features) {
        this.id = id;
        this.status = status;
        this.client = client;
        this.features = features;
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
