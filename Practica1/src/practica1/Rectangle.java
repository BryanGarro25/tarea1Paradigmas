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

    public Rectangle(int numero,double x, double y,double base, double altura) {
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
}
