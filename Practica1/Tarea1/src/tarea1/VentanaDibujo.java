/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

/**
 *
 * @author Fiorella Salgado
 */
public class VentanaDibujo extends JFrame{
    private JScrollPane panelDesplazable;
    
    private void ajustarComponentes(Container c) {
        c.setLayout(new BorderLayout(4, 4));

        JPanel e1a = new JPanel();
        e1a.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        e1a.setLayout(new BorderLayout());
        panelDesplazable = new JScrollPane(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        e1a.add(BorderLayout.CENTER, panelDesplazable);
        c.add(BorderLayout.CENTER, e1a);
    }

    public void init() {
        setVisible(true);
    }
    
    public void dibujarFigura(Figura f) {
        if (f != null) {
            JScrollBar vertical = panelDesplazable.getVerticalScrollBar();
            vertical.setValue(vertical.getMaximum());
        }
    }
}
