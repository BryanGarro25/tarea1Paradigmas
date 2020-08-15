package practica.figuras;
import java.util.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;

public class Figura {
	private String nombre;
	private double area;
	
	private static final Font TIPO_BASE = new Font(Font.SANS_SERIF, Font.PLAIN, 12);
    private final Stroke trazo;
    private final Color colorTrazo;
    private final Color colorFigura;
    private final Rectangle r;
	
	
	public Figura(Stroke trazo, Color color, Rectangle r) {
        this.trazo = trazo;

        float[] c = color.getColorComponents(null);
        this.colorTrazo = new Color(c[0], c[1], c[2], 0.35f);
        this.colorFigura = color.darker();
		this.nombre ="isnertar nombre";
		this.area = 0;
        this.r = r;
    }
	public void dibujar(Graphics bg, float escala) {
        Graphics2D g = (Graphics2D) bg;

        g.setColor(colorTrazo);
        g.fillRect(
                (int) (escala * r.x),
                (int) (escala * r.y),
                (int) (escala * r.width),
                (int) (escala * r.height)
        );

        g.setStroke(trazo);
        g.setColor(colorFigura);
        g.drawRect(
                (int) (escala * r.x),
                (int) (escala * r.y),
                (int) (escala * r.width),
                (int) (escala * r.height)
        );

        float s = 9f;
        Font tipo = TIPO_BASE.deriveFont(escala * s);
        g.setFont(tipo);
        g.setColor(g.getColor().darker());
        g.drawString(String.format("{%d, %d, %d, %d}",
                r.x, r.y, r.width, r.height),
                (int) (escala * (r.x + 6)),
                (int) (escala * (r.y + 4 + s))
        );

    }
	public void desplazar(int dx, int dy) {
        r.x += dx;
        r.y += dy;
    }

	public String getNombre(){
		return nombre;
	}

	public void setArea(double p_area){
		 area = p_area;
	}

	public double getArea(){
		 return area;
	}

	

}
