package practica.figuras;
import java.util.*;

public class Rectangle extends Figura{
  private double base, altura,x,y;

  public Rectangle(String p_nombre, double p_x, double p_y, double p_base, double p_altura){
    super(p_nombre);
    x = p_x;
    y = p_y;
    base = p_base;
    altura = p_altura;
  }

public double getX(){
  return x;
}

public double getY(){
  return y;
}

  public double getBase(){
    return base;
  }

  public double getAltura(){
    return altura;
  }

  public double calcula_area(){
    double a = base * altura;

    return a;
  }
}
