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
public class Triangulo extends Figura{
    private static double x_vertice1,y_vertice1,x_vertice2, y_vertice2, x_vertice3, y_vertice3;

    public Triangulo(double p_x, double p_y, double p_xV2,double p_yV2, double p_xV3, double p_yV3){
        super("Triangulo");
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

    @Override
    public double calcula_area() {
        double v1 = (x_vertice1*y_vertice2)+(x_vertice2*y_vertice3)+(x_vertice3*y_vertice1);
        double v2 = (x_vertice1*y_vertice3)+(x_vertice3*y_vertice2)+(x_vertice2*y_vertice1);
        double a = (v1-v2)/2;

        return a;
    }
    
    public static void dibujar(Graphics g){
        g.drawLine(
                (int) (x_vertice1),
                (int) (y_vertice1),
                (int) (x_vertice2),
                (int) (y_vertice2)
        );
        
        g.drawLine(
                (int) (x_vertice2),
                (int) (y_vertice2),
                (int) (x_vertice3),
                (int) (y_vertice3)
        );
        
        g.drawLine(
                (int) (x_vertice3),
                (int) (y_vertice3),
                (int) (x_vertice1),
                (int) (y_vertice1)
        );
    }
    
    public static String mensaje(){
        String salida = "triangulo con vertice 1 (" + x_vertice1 
                + "," + y_vertice1 + "), vertice 2 (" + x_vertice2 
                + "," + y_vertice2 + ") y vertice 3 (" + x_vertice3 
                + "," + y_vertice3;
        
        return salida;
    }

    @Override
    public Boolean puntoDentro(int x, int y) {
        
        return false;
    }
}
