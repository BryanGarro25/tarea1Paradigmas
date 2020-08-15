package practica.figuras;
import java.util.*;
import java.io.*;

public class Practica {


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
				commandValidator(commandSplited,3);
				break;
            case "square":
				commandValidator(commandSplited,3);
				break;
			case "rectangle":
				commandValidator(commandSplited,4);
				break;
			case "triangle":
				commandValidator(commandSplited,6);
				break;
			case "donut":
				commandValidator(commandSplited,4);
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
	public static boolean commandValidator(String[] command,int cant){
		
		//System.out.println(command.length);
		if(cant !=command.length-1){
			System.out.println("The command \""+command[0]+"\" exist, but maybe you are using the wrong number of parameters.\nUser command help for more information.\n");
			return false;
		}
		
		for (int i = 1;i<command.length;i++){
			try
			{
			  Double.parseDouble(command[i]);
			}
			catch(NumberFormatException e)
			{
				System.out.println("The parameter number "+i+": \""+command[i]+"\" has a syntax error.");
				return false;
			}
		}
		
		return true;
	}

	public static String[] spliter2(String command){
		String[] resp = command.split(" ");

		return resp;
	}

public static void leeFichero(){
	File archivo = null;
	FileReader fr = null;
	BufferedReader br = null;
	try {
         archivo = new File ("../comandos.txt");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         String comandos;
         while((comandos = br.readLine())!=null)
            System.out.println(comandos);
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         try{
            if( fr != null ){
               fr.close();
            }
         }catch (Exception e2){
            e2.printStackTrace();
         }
      }
}


	public static void main(String[] args){

		Figura figura = new Circle("circulo",2.4,4.7,3.14);
		System.out.println(figura.toString());
		leeFichero();
		boolean flag = true;
		while (flag){
			System.out.print("cmd> ");
			Scanner sc= new Scanner(System.in);
			String str= sc.nextLine(); //reads string.
			//System.out.println(str);
			  str = str+" ";
			flag = eval(str);
		
		}
		// String prueba = "Split con el metodo de java";
		// String[] array = spliter2(prueba);
		// for(int i = 0; i < array.length;i++){
		// 	System.out.println(array[i]);
		// }


	}
}
