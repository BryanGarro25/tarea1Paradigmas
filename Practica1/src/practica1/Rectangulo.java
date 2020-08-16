/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author Fiorella Salgado
 */
public class Rectangulo extends Figuras{
    private double base, altura,x,y;

    public Rectangulo(int numero,double x, double y,double base, double altura) {
        super("Rectangulo",numero);
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
    
    public String toString(){
        String salida = "rectangulo con esquina superior izquierda (" + this.getX()
                + "," + this.getY() + "), con base " + this.getBase() + " y con altura " 
                + this.getAltura();
        
        return salida;
    }

    @Override
    public void dibujarFigura(Graphics bg, double escala) {
        Graphics2D g = (Graphics2D) bg;
        
        g.fillRect(
                (int) (escala * x),
                (int) (escala * y),
                (int) (escala * base),
                (int) (escala * altura)
        );
        g.drawRect(
                (int) (escala * x),
                (int) (escala * y),
                (int) (escala * base),
                (int) (escala * altura)
        );
        
        
    }
}
