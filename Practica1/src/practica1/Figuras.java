/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.awt.Graphics;

/**
 *
 * @author Fiorella Salgado
 */
public abstract class Figuras {
    private String nombre;
    private double area;
    private int numero;

    public Figuras(String nombre, int numero) {
        this.nombre = nombre;
        this.numero = numero;
        this.area = 0.0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public abstract double calcula_area();
    
    public abstract void dibujarFigura(Graphics g, double escala);

}
