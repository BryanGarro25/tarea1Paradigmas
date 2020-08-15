package practica.figuras;
import java.util.*;

public class Circle extends Figura{
  private double radio,x,y;

  public Circle(String p_nombre,double p_x,double p_y,double p_radio){
    super(p_nombre);
    x = p_x;
    y = p_y;
    radio = p_radio;
  }

  public double getRadio(){
    return radio;
  }

  public double getX(){
    return x;
  }

  public double getY(){
    return y;
  }

  public String toString(){
    return "Circulo con centro en (" + getX() + "," + getY() + ") y radio " + getRadio();
  }

  public double calcula_area(){
    double a = Math.pow(radio,2) * Math.PI;

    return a;
  }
}
