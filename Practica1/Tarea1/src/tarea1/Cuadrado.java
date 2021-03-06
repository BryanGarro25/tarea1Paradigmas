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
public class Cuadrado extends Figura{
    private static double lado,x,y;

    public Cuadrado(double x, double y,double lado) {
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
    
    public static void dibujar(Graphics g){
        g.drawRect(
                (int) (x),
                (int) (y),
                (int) (lado),
                (int) (lado)
        );
    }
    
     public static String mensaje(){   
         String salida = "cuadrado con esquina superior derecha ("
                + x + "," + y + ") y con lado " + 
                lado;
        return salida;
    }

    @Override
    public Boolean puntoDentro(int x, int y) {
        return false;
    }
}

