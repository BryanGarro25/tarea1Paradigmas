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
public class Rectangle extends Figuras{
    private double base, altura,x,y;

    public Rectangle(double x, double y,double base, double altura) {
        super("Rectangulo");
        this.base = base;
        this.altura = altura;
        this.x = x;
        this.y = y;
    }

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public double calcula_area() {
        double a = base * altura;

        return a;
    }
    
    
}
