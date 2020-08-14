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
public class Circle extends Figuras{
    private double radio,x,y;

    public Circle(double x, double y, double radio) {
        super("Circulo");
        this.radio = radio;
        this.x = x;
        this.y = y;
    }

    public double getRadio() {
        return radio;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    
    @Override
    public double calcula_area() {
        double a = Math.pow(radio,2) * Math.PI;        
        return a; 
    }
    
}