package practica.figuras;
import java.util.*;

public class Triangle extends Figura{
  private double x_vertice1,y_vertice1,x_vertice2, y_vertice2, x_vertice3, y_vertice3;

  public Triangle(String p_nombre, double p_x, double p_y, double p_xV2,double p_yV2, double p_xV3, double p_yV3){
      super(p_nombre);
      x_vertice1 = p_x;
      x_vertice2 = p_xV2;
      x_vertice3 = p_xV3;
      y_vertice1 = p_x;
      y_vertice2 = p_yV2;
      y_vertice3 = p_yV3;
  }
  public double getX_vertice1(){
    return x_vertice1;
  }

  public double getY_vertice1(){
    return y_vertice1;
  }
  public double getX_vertice2(){
    return x_vertice2;
  }

  public double getX_vertice3(){
    return x_vertice3;
  }

  public double getY_vertice2(){
    return y_vertice2;
  }

  public double getY_vertice3(){
    return y_vertice3;
  }

  public double calcula_area(){
    return 0.0
  }

  public double area(){
    double v1 = (x_vertice1*y_vertice2)+(x_vertice2*y_vertice3)+(x_vertice3*y_vertice1);
    double v2 = (x_vertice1*y_vertice3)+(x_vertice3*y_vertice2)+(x_vertice2*y_vertice1);
    double a = (v1-v2)/2;

    return a;

  }
}
