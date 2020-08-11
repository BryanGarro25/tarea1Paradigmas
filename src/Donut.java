package practica.figuras;
import java.util.*;

public class Donut extends Figura{
  double radio_mayor, radio_menor,x,y;

  public Donut(String p_nombre, double p_x, double p_y, double p_radio_mayor, double p_radio_menor){
    super(p_nombre);
    radio_mayor = p_radio_mayor;
    radio_menor = p_radio_menor;
    x = p_x;
    y = p_y;
  }

  public double getX(){
    return x;
  }

  public double getY(){
    return y;
  }
  
  public double getRadio_mayor(){
    return radio_mayor;
  }

  public double getRadio_menor(){
    return radio_menor;
  }
}
