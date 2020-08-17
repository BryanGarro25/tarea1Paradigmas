/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1;

import java.awt.Graphics;

/**
 *
 * @author Fiorella Salgado y Bryan Garro
 */
public class Rectangulo extends Figura{
  private static double base, altura,x,y;

  public Rectangulo( double p_x, double p_y, double p_base, double p_altura){
    super("Rectangulo");
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

    @Override
    public double calcula_area() {
        double a = base * altura;

        return a;
    }
    
    public static void dibujar(Graphics g){       
        g.drawRect(
                (int) (x),
                (int) (y),
                (int) (base),
                (int) (altura)
        );
    }
    
    public static String mensaje(){
        String salida = "rectangulo con esquina superior izquierda (" + x
                + "," + y + "), con base " + base + " y con altura " 
                + altura;
        
        return salida;
    }

    @Override
    public Boolean puntoDentro(int x, int y) {
        return false;
    }
}
