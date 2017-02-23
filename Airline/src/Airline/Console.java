/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anita Way
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Console {
 
    private  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private  static String integerReprompt = "Invalid integer. Try again: ";
    private  static String doubleReprompt = "Invalid double. Try again: ";
    private  static String charReprompt = "Invalid character. Try again: ";
 
    public static String readString() {
        String s = null;
        try {
            s = in.readLine();
        } catch (IOException ex) {}
        return s;
    }
 
    public static char readChar() {
        char c = 0;
        String s = null;
        try {
            s = in.readLine();
        } catch (IOException ex) {}
                if (s.length() == 1) {
                    c = s.charAt(0);
//                  valid = true;
                } else {
                    System.out.print(charReprompt);
                }
        return c;
    }
 
    public static int readInt() {
        int i = 0;
 
            boolean valid = false;
 
            try {
                    i = Integer.parseInt(in.readLine());
          valid = true;
                } catch (IOException ex) 
                { System.out.print(integerReprompt);}
                  
                   
 
        return i;
    }
 
    public static double readDouble() {
        double d = 0.0;
 
        boolean valid = true;
 
        try {
                    d = Double.parseDouble(in.readLine());
        } catch (IOException ex) {}
                    valid = true;
                    valid = false;
                    System.out.print(doubleReprompt);
 
 
        return d;
    }
 
    public void pause() {
            System.out.print("Press enter to continue...");
            try {
            in.readLine();
            } catch (IOException ex) {}
        }
 
    public static void setIntegerReprompt(String prompt) {
        integerReprompt = prompt;
    }
 
    public void setDoubleReprompt(String prompt) {
        doubleReprompt = prompt;
    }
 
    public void setCharReprompt(String prompt) {
        charReprompt = prompt;
    }
 
}
