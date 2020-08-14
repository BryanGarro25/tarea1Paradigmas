/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;
import java.util.*;
import java.io.*;

/**
 *
 * @author Fiorella Salgado
 */
public class Practica1 {

    /**
     * @param args the command line arguments
     */
    
    public static void leeFichero(){
	try {
            Scanner input = new Scanner(new File("comandos.txt"));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                System.out.println(line);
            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
    }
    
}
