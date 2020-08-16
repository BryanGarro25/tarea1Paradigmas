/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;

/**
 *
 * @author Fiorella Salgado
 */
public class Donut extends Figuras {
    double radio_mayor, radio_menor,x,y;

    public Donut(int numero,double x, double y,double radio_mayor, double radio_menor) {
        super("Dona", numero);
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
      
    public String toString(){   
        String salida = "dona con centro en(" + this.getX()
                +","+ this.getY() + "), radio mayor "+ 
                this.getRadio_mayor() + " y radio menor " + this.getRadio_menor();
        return salida;
    }

    @Override
    public void dibujarFigura(Graphics bg, double escala) {
        Graphics2D g = (Graphics2D) bg;
        
        g.fillOval(
                (int) (escala * (x - (radio_mayor/2))), 
                (int) (escala * (y - (radio_mayor/2))), 
                (int) (escala * radio_mayor), 
                (int) (escala * radio_mayor)
        );
        g.drawOval(
                (int) (escala * (x - (radio_mayor/2))), 
                (int) (escala * (y - (radio_mayor/2))), 
                (int) (escala * radio_mayor), 
                (int) (escala * radio_mayor)
        );
        
        g.drawOval(
                (int) (escala * (x - (radio_menor/2))), 
                (int) (escala * (y - (radio_menor/2))), 
                (int) (escala * radio_menor), 
                (int) (escala * radio_menor)
        );
    }
}
