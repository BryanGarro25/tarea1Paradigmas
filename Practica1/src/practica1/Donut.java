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
public class Donut extends Figuras {
    double radio_mayor, radio_menor,x,y;

    public Donut(double x, double y,double radio_mayor, double radio_menor) {
        super("Dona");
        this.radio_mayor = radio_mayor;
        this.radio_menor = radio_menor;
        this.x = x;
        this.y = y;
    }

    public double getRadio_mayor() {
        return radio_mayor;
    }

    public double getRadio_menor() {
        return radio_menor;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    
    @Override
    public double calcula_area() {
        double a = (Math.pow(radio_mayor,2) - Math.pow(radio_menor,2))* Math.PI;
        return a;
    }
      
}
