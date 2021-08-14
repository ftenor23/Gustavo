package Validator;

import javax.swing.*;

public abstract class IntValidator {
    public static int nextInt(String messageToShow){

        try {
            int in = Integer.parseInt(JOptionPane.showInputDialog(messageToShow));
            return in;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Caracter no valido. Ingrese una variable numerica.");
            return nextInt(messageToShow);
        }

    }
}
