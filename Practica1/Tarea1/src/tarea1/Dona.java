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
public class Dona extends Figura{
    public static double radio_mayor, radio_menor,x,y;

    public Dona(double p_x, double p_y, double p_radio_mayor, double p_radio_menor){
      super("Dona");
      radio_mayor = p_radio_mayor;
      radio_menor = p_radio_menor;
      x = p_x;
      y = p_y;
    }

    public double getX(){
      return x;
    }

    public double getY(){
      return y;
    }

    public double getRadio_mayor(){
      return radio_mayor;
    }

    public double getRadio_menor(){
      return radio_menor;
    }

    @Override
    public double calcula_area() {
        double a = (Math.pow(radio_mayor,2) - Math.pow(radio_menor,2))* Math.PI;

        return a;
    }
    
    public static void dibujar(Graphics g) {
        
        g.drawOval(
                (int) ((x - (radio_mayor/2))), 
                (int) ((y - (radio_mayor/2))), 
                (int) (radio_mayor), 
                (int) (radio_mayor)
        );
        
        g.drawOval(
                (int) ((x - (radio_menor/2))), 
                (int) ((y - (radio_menor/2))), 
                (int) (radio_menor), 
                (int) (radio_menor)
        );
    }
    
     public static String mensaje(){   
        String salida = "dona con centro en(" + x
                +","+ y + "), radio mayor "+ 
                radio_mayor + " y radio menor " + radio_menor;
        return salida;
    }

    @Override
    public Boolean puntoDentro(int x, int y) {
        return false;
    }
}
