package EnterData;


import Graphics.Graphics;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EnterData {

    public static String nextLine(){
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public static int nextInt(){
        Scanner in = new Scanner(System.in);
        try {
            return in.nextInt();
        }catch (InputMismatchException e){
            Graphics.enterAValidNumber();
            return nextInt();
        }

    }
}