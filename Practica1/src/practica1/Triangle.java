/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author Fiorella Salgado
 */
public class Triangle extends Figuras{
    
    
    private double x_vertice1,y_vertice1,x_vertice2, y_vertice2, x_vertice3, y_vertice3;

    public Triangle(int numero,double x_vertice1, double y_vertice1, double x_vertice2, double y_vertice2, double x_vertice3, double y_vertice3) {
        super("Triangulo",numero);
        this.x_vertice1 = x_vertice1;
        this.y_vertice1 = y_vertice1;
        this.x_vertice2 = x_vertice2;
        this.y_vertice2 = y_vertice2;
        this.x_vertice3 = x_vertice3;
        this.y_vertice3 = y_vertice3;
    }

    public double getX_vertice1() {
        return x_vertice1;
    }

    public double getY_vertice1() {
        return y_vertice1;
    }

    public double getX_vertice2() {
        return x_vertice2;
    }

    public double getY_vertice2() {
        return y_vertice2;
    }

    public double getX_vertice3() {
        return x_vertice3;
    }

    public double getY_vertice3() {
        return y_vertice3;
    }
    
    @Override
    public double calcula_area() {
        double v1 = (x_vertice1*y_vertice2)+(x_vertice2*y_vertice3)+(x_vertice3*y_vertice1);
        double v2 = (x_vertice1*y_vertice3)+(x_vertice3*y_vertice2)+(x_vertice2*y_vertice1);
        double a = (v1-v2)/2;

        return a;
    }
    
    public String toString(){
        String salida = "triangulo con vertice 1 (" + this.getX_vertice1() 
                + "," + this.getY_vertice1() + "), vertice 2 (" + this.getX_vertice2() 
                + "," + this.getY_vertice2() + ") y vertice 3 (" + this.getX_vertice3() 
                + "," + this.getY_vertice3();
        
        return salida;
    }

    @Override
    public void dibujarFigura(Graphics bg, double escala) {
        Graphics2D g = (Graphics2D) bg;
        
        g.drawLine(
                (int) (escala * x_vertice1),
                (int) (escala * y_vertice1),
                (int) (escala * x_vertice2),
                (int) (escala * y_vertice2)
        );
        
        g.drawLine(
                (int) (escala * x_vertice2),
                (int) (escala * y_vertice2),
                (int) (escala * x_vertice3),
                (int) (escala * y_vertice3)
        );
        
        g.drawLine(
                (int) (escala * x_vertice3),
                (int) (escala * y_vertice3),
                (int) (escala * x_vertice1),
                (int) (escala * y_vertice1)
        );
    }
    
}
