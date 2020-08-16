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
public class Ellipse extends Figura{
    private static double radio_mayor,radio_menor,x,y;

    public Ellipse(String nombre) {
        super(nombre);
    }

    public Ellipse(double x, double y, double radio, double radio2) {
        super("Ellipse");
        this.radio_mayor = radio;
        this.radio_menor = radio2;
        this.x = x;
        this.y = y;
    }

    public double getRadioMayor() {
        return radio_mayor;
    }
    
    public double getRadioMenor() {
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
        double a = radio_mayor * radio_menor * Math.PI;
        return a;
    }

    public static void dibujar(Graphics g){
      g.drawOval(
                (int) (x),
                (int) (y),
                (int) (radio_mayor),
                (int) (radio_menor)
        );
    }
}
