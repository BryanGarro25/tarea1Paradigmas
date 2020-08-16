/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author Fiorella Salgado
 */
public class Square extends Figuras{
    private double lado,x,y;

    public Square(int numero,double x, double y,double lado) {
        super("Cuadrado", numero);
        this.lado = lado;
        this.x = x;
        this.y = y;
    }

    public double getLado() {
        return lado;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public double calcula_area() {
        double a = lado*lado;

        return a;
    }
    
    public String toString(){
        String salida = "cuadrado con esquina superior derecha ("
                + this.getX() + "," + this.getY() + ") y con lado " + 
                this.getLado();
        return salida;
    }

    @Override
    public void dibujarFigura(Graphics bg, double escala) {
       Graphics2D g = (Graphics2D) bg;
        
        g.fillRect(
                (int) (escala * x),
                (int) (escala * y),
                (int) (escala * lado),
                (int) (escala * lado)
        );
        g.drawRect(
                (int) (escala * x),
                (int) (escala * y),
                (int) (escala * lado),
                (int) (escala * lado)
        );
    }
    
}
