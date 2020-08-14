package practica.figuras;
import java.util.*;

public class Square extends Figura{
  private double lado,x,y;

  public Square(String p_nombre, double p_x,double p_y,double p_lado){
    super(p_nombre);
    x = p_x;
    x = p_y;
    lado = p_lado;
  }

  public double getX(){
    return x;
  }

  public double getY(){
    return y;
  }

  public double getLado(){
    return lado;
  }

  public double calcula_area(){
      double a = lado*lado;

      return a;
  }
}
