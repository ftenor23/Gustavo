package Validator;

import Constants.SORT_CONSTANTS;

import javax.swing.*;

public abstract class IntValidator {
    private static final int ERROR=-1;
    /*public static int nextInt(String messageToShow){

        try {
            //int in = Integer.parseInt(JOptionPane.showInputDialog(messageToShow));
            String in = JOptionPane.showInputDialog(messageToShow);
            System.out.println(in);
            return 0;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Caracter no valido. Ingrese una variable numerica.");
            return nextInt(messageToShow);
        }

    }*/


    public static int nextInt(String messageToShow){

        try {
            //int in = Integer.parseInt(JOptionPane.showInputDialog(messageToShow));
            String in = JOptionPane.showInputDialog(messageToShow);
            if(in==null){
                return ERROR;
            }
            return Integer.parseInt(in);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Caracter no valido. Ingrese una variable numerica.");
            return nextInt(messageToShow);
        }

    }
}
