/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author Fiorella Salgado
 */
public abstract class Ventana extends JFrame{
    
    public Ventana(String titulo) throws HeadlessException {
        super(titulo);
    }
    
    
}
