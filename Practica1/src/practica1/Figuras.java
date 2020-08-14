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
public abstract class Figuras {
    private String nombre;
    private double area;

    public Figuras(String nombre) {
        this.nombre = nombre;
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
    
    public abstract double calcula_area();
    
}
