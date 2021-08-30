package Entity;

import java.io.Serializable;

public class Client implements Serializable {
    private String name;
    private int zone; //1)norte, 2)oeste, 3)sur, 4)capital
    //agregar barrio
    //opcional, agregar distancia del cliente para ordenar por ese criterio
    public Client(String name, int zone) {
        this.name = name;
        this.zone = zone;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getZone() {
        return zone;
    }

    public void setZone(int zone) {
        this.zone = zone;
    }
}
