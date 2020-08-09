import java.util.*;  
public class Practica {


	public static boolean eval(String command){
		switch(command){
			case "exit":
				System.out.println("bye :)");
				return false;
            case "Martes":
                     break;
            case "Miercoles":
                     break;
            case "Jueves":
                     break;
            case "Viernes":
                     break;
            case "Sabado":
                     break;
            case "Domingo":
                     break;
            default:
                     break;
		}
		return true;
		
	}
	public static String[] spliter(String command){
		String[] resp = new String[10]; 
		int respCouter =0;
		int init = 0;
		for(int i = 0;i<command.length();i++){
			if(command.charAt(i)==' '){
				resp[respCouter] = command.substring(init,i);
				respCouter++;
				init = i+1;
			}
		}
		return resp;
	}
	
	
	public static void main(String[] args){
		
		/*boolean flag = true;
		while (flag){
			System.out.print("cmd> ");  
			Scanner sc= new Scanner(System.in);
			String str= sc.nextLine(); //reads string.
			System.out.println(str);
			  
			flag = eval(str);
			
		}*/
		String[] resp = new String[10]; 
		resp = spliter("hola como estas");
		System.out.print(resp[0]+'\n'); 
		System.out.print(resp[1]+'\n'); 
		System.out.print(resp[2]); 
		
	}
}