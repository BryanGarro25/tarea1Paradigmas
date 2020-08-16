/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1;

import java.awt.Graphics;

/**
 *
 * @author Fiorella Salgado
 */
public class Circulo extends Figura{
    private static double radio,x,y;

    public Circulo(double x, double y, double radio) {
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

    public static void dibujar(Graphics g){
      g.drawOval(
                (int) ((x - (radio/2))),
                (int) ((y - (radio/2))),
                (int) (radio),
                (int) (radio)
        );
    }
}
