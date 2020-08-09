
public class Practica {
	static int mults = 0;
	//P2
	public static double pow(double x, int n){
		if ( n > 0 ) mults += n - 1;
		return Math.pow(x, n); // SUPUESTO: toma n - 1 multiplicaciones x*x , x*x*x, etc si n > 0
	} 
	public static double eval(double[] p, double x){
		int n = p.length - 1;
		double s = 0;
		for (int i = 0; i < p.length; i++){
			s += p[i] * pow(x, n - i);
			/*
			  i=0 --> n  - 1
			  i=1 --> n  - 2
			  ...
			  i=n --> 0
			  Total = n-1 + n-2 + ... + 1 + 0 (suma de Gauss) = (n-1)(n)/2
			  (n-1)(n)/2 (n es grande) ~ n*n/2 ~ n^2
			  Reducir? Solucion Horner (ejercicio)
			*/
		}
		return s;
	}
	
	public static long sa(int n){ // RR para n! (n! = n*(n-1)!)
		/*if (n == 0) return 1;
		return n * sa( n - 1);*/
		return (n == 0) ? 1 : n * sa( n - 1);
	}
	
	
	public static void main(String[] args){
		// Caso 1
		System.out.println("Caso 1");
		double[] p = {1, -2 , 1};        // x^2  - 2x + 1 
		mults = 0;
		System.out.println(eval(p, 1));  // p(2) = 1*1 -2*1 + 1 = 0
		System.out.println("Mults=" + mults);
		
		// Caso 2
		System.out.println("Caso 2");
		double[] p1 = {1, 5, 2 , 1};     // x^3 + 5x^2 + 2x +1 
		mults = 0;
		System.out.println(eval(p1, 2)); // p1(2) = 1*8 + 5*4 + 2*2 + 1 = 33
		System.out.println("Mults=" + mults);
		
		// Caso 3
		System.out.println("Caso 3");
		double[] p2 = {2, 1, 5, 2 , 1};    
		mults = 0;
		System.out.println(eval(p2, 2)); 
		System.out.println("Mults=" + mults);
        for(int n = 0; n < 5; n ++){
		 System.out.println("n=" + n + " " + "sa(n)=" + sa(n));
		}
	}
}