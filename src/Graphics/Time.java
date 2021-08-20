package Graphics;

import Validator.IntValidator;

import javax.swing.*;

public class Time {
    private final static String ENTER_NEW_UPDATE_TIME = "Ingrese la cantidad de segundos deseada:";
    private final static String NEW_UPDATE_TIME_IS = "El nuevo tiempo de actualizacion es de ";
    private final static int TURN_TO_SECONDS = 1000;

    public static int enterTime(){
        return IntValidator.nextInt(ENTER_NEW_UPDATE_TIME) * TURN_TO_SECONDS;
    }

    public static void confirmation(int time){
        JOptionPane.showMessageDialog(null, message(time));
    }

    private static String message(int time){
        String seconds=null;
        int newTime = time/1000;
        if(newTime!=1){
            seconds=" segundos";
        }else{
            seconds = " segundo";
        }
        return NEW_UPDATE_TIME_IS + newTime + seconds;
    }
}
