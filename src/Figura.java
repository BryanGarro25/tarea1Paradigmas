package practica.figuras;
import java.util.*;

public abstract class Figura {
	private String nombre;
	private double area;

	public Figura(String p_nombre){
			nombre = p_nombre;
			area = 0.0;
	}

	public String getNombre(){
		return nombre;
	}

	public void setArea(double p_area){
		 area = p_area;
	}

	public double getArea(){
		 return area;
	}

	public abstract double calcula_area();

}
