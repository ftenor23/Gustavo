package Graphics.Windows.Actions;


import Entity.Client;

public abstract class AddClient {
    private final static String ENTER_NAME = "Ingrese el nombre del cliente: ";
    private final static String CHANGE_CLIENT_NAME = "Ingrese el nombre del nuevo cliente";

    public static Client enterData(boolean newClient){
        String message;
        if(newClient){
            message=ENTER_NAME;
        }else{
            message=CHANGE_CLIENT_NAME;
        }

        return DataIn.validateData(message);
    }


}
