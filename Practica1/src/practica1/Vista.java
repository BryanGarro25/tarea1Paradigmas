/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Fiorella Salgado
 */
public class Vista extends JFrame{
    JPanel panel = null;
    Figuras f = null;

    public Vista() throws HeadlessException {
        super("Tarea 1");
        this.setVisible(true);
        this.setSize(1000,500);
        panel = new Panel();
        panel.setName("PanelDibujo");
        this.setContentPane(panel);
    }
    
    public JPanel getPanel(){
        return panel;
    }
    
    public void paintComponent(Figuras f) {
        super.paintComponents(panel.getGraphics());
        
        f.dibujarFigura(panel.getGraphics(), 1);
    }
}
