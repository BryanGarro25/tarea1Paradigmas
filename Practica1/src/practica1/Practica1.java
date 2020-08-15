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
    
    public static List<String> leeFichero(){
        List<String> comando = new ArrayList();
	try {
            Scanner input = new Scanner(new File("comandos.txt"));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                comando.add(line);
            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return comando;
    }
    
    
    
    public static String[] spliter2(String command){
        String[] resp = command.split(" ");

        return resp;
    }
    
    public static boolean eval(String command){
        String[] commandSplited = spliter2(command);
        //System.out.println("entra");
        //System.out.println(commandSplited[0]);
        //System.out.println("entra");
        switch(commandSplited[0]){
            case "exit":
                System.out.println("bye :)");
                return false;
            case "help":
                    System.out.println("You can use any of this commands:\n");
                    System.out.println("circle <x> <y> <radius>");
                    System.out.println("rectangle <x> <y> <base> <altura>");
                    System.out.println("square <x> <y> <lado>");
                    System.out.println("triangle <x vertice 1> <y vertice 1> <x vertice 2> <y vertice 2> <x vertice 3> <y vertice 3>");
                    System.out.println("donut <x> <y> <radio mayor> <radio menor>");
                    System.out.println("ellipse <x> <y> <nose> <nose>");
                    System.out.println("delete <position>");
                    System.out.println("<coordenadas>");
                    System.out.println("list");
                    System.out.println("exit\n");
                break;
            case "delete":
                break;
            case "list":
                break;
            case "circle":
                break;
            case "square":
                break;
            case "rectangle":
                break;
            case "triangle":
                break;
            case "donut":
                break;
            case "ellipse":
                break;
            default:
            //System.out.println("wrong");
                    System.out.println("The command \""+commandSplited[0]+"\" does not exist, use command help for more information.\n");
                break;
            }
        return true;
    }
    
    public static void main(String[] args) {
    }
    
}
