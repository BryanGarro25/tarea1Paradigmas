package practica.figuras;
import java.util.*;  
public class Practica {


	public static boolean eval(String command){
		String[] commandSplited = spliter(command);
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
				System.out.println("rectangle <nose> <nose> <nose> <nose>");
				System.out.println("square <nose> <nose> <nose>");
				System.out.println("triangle <nose> <nose> <nose> <nose> <nose> <nose>");
				System.out.println("donut <nose> <nose> <nose> <nose>");
				System.out.println("ellipse <nose> <nose> <nose> <nose>");
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
	public static String[] spliter(String command){
		String[] resp = new String[10]; 
		int respCounter =0;
		int init = 0;
		for(int i = 0;i<command.length();i++){
			//System.out.print(command.charAt(i)); 
			//System.out.print("\n"); 
			if(command.charAt(i)==' '){
				//System.out.print("entro\n"); 
				//System.out.print("palabra: "+command.substring(init,i)+"\n"); 
				resp[respCounter] = command.substring(init,i);
				respCounter++;
				init = i+1;
			}
		}
		return resp;
	}
	
	
	public static void main(String[] args){
		
		boolean flag = true;
		while (flag){
			System.out.print("cmd> ");  
			Scanner sc= new Scanner(System.in);
			String str= sc.nextLine(); //reads string.
			//System.out.println(str);
			  str = str+" ";
			flag = eval(str);
			
		}
		
	
		
	}
}