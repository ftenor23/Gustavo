package Graphics.Windows.Messages;

import javax.swing.*;

public abstract class Graphics {

    public static void enterAValidNumber(){
        System.out.println("Caracter no valido. Ingrese solo una variable numerica.");
    }

    public static void cleanConsole(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static String showMessage(String message){
        return JOptionPane.showInputDialog(message);
    }
}
