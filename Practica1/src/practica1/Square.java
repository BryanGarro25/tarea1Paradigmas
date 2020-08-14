/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

/**
 *
 * @author Fiorella Salgado
 */
public class Square extends Figuras{
    private double lado,x,y;

    public Square(double x, double y,double lado) {
        super("Cuadrado");
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
    
    
}
