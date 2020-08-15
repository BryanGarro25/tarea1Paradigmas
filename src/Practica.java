package practica.figuras;
import java.util.*;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.UIManager;
import javax.swing.SwingUtilities;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.KeyStroke;
import java.awt.Stroke;
import javax.swing.JSlider;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.BasicStroke;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.Event;

import java.io.IOException;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.HeadlessException;
import javax.swing.event.ChangeEvent;
public class Practica extends VentanaAplicacion{
	
	private static final Color COLOR_FONDO = new Color(220, 220, 220);
    private static final float MIN_ESCALA = 0.10f;
    private static final float MAX_ESCALA = 4.00f;

    private static final Stroke TRAZO_BASE = new BasicStroke(1f);
    private static final Color[] COLORES_BASE = {
        new Color(1.0f, 0.7f, 0.7f),
        new Color(0.7f, 0.7f, 1.0f),
        new Color(1.0f, 0.85f, 0.7f),
        new Color(0.85f, 1.0f, 0.7f),
        new Color(1.0f, 0.7f, 0.85f)
    };

    private JPanel areaDibujo;
    private JSlider controlEscala;
    private JButton btnEscala;
    private JLabel etqEscala;

    private JMenuBar menuPrincipal;
    private JMenu menuArchivo;
    private JMenu menuDatos;
    private JMenuItem itemSalir;
    private JMenuItem itemPrueba;

    private float escala = 1f;
    private Rectangle limites = null;
    private final List<Figura> figuras;
	
	public Practica() throws HeadlessException {
        super("Ejemplo Base");
        this.figuras = new ArrayList<>();
        configurar();
    }
	private void configurar() {
        ajustarComponentes(getContentPane());
        pack();

        setLocationByPlatform(true);
        try {
            restaurar();
        } catch (IllegalArgumentException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
	 private void ajustarEscala() {
        fijarEscala(trasladar(
                controlEscala.getMinimum(), controlEscala.getMaximum(),
                MIN_ESCALA, MAX_ESCALA,
                controlEscala.getValue()));
    }
	
	private void ajustarComponentes(Container c) {
        c.setLayout(new BorderLayout());

        JPanel d = new JPanel();
        d.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        d.setLayout(new FlowLayout(FlowLayout.LEFT));
        d.add(btnEscala = new JButton("100%"));
        d.add(etqEscala = new JLabel());
        c.add(BorderLayout.PAGE_END, d);

        c.add(BorderLayout.CENTER, new JScrollPane(
                areaDibujo = new PanelDibujo() {
            @Override
            public void paintComponent(Graphics bg) {
                super.paintComponent(bg);
                Graphics2D g = (Graphics2D) bg;

                g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

                figuras.forEach((f) -> {
                    f.dibujar(g, escala);
                });
            }

        },
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));

        areaDibujo.setBackground(COLOR_FONDO);

        c.add(BorderLayout.LINE_END, controlEscala = new JSlider(JSlider.VERTICAL, 0, 100, 0));
        controlEscala.setMajorTickSpacing(5);
        controlEscala.setPaintTicks(true);
        controlEscala.addChangeListener((ChangeEvent e) -> {
            ajustarEscala();
            ajustarPanel();
            repaint();
        });

        btnEscala.addActionListener((ActionEvent e) -> {
            fijarEscala(1f);
            ajustarControl();
        });

        setResizable(true);
        setMinimumSize(new Dimension(640, 480));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ajustarMenus();
    }

	public static boolean eval(String command){
		String[] commandSplited = spliter2(command);
		//System.out.println("entra");
		//System.out.println(commandSplited[0]);
		//System.out.println("entra");
		switch(commandSplited[0]){
			case "exit":
				System.out.println("bye :)");
				return false;
            case "help":
				System.out.println("You can use any of this commands:\n");
				System.out.println("circle <x> <y> <radius>");
				System.out.println("rectangle <x> <y> <base> <altura>");
				System.out.println("square <x> <y> <lado>");
				System.out.println("triangle <x vertice 1> <y vertice 1> <x vertice 2> <y vertice 2> <x vertice 3> <y vertice 3>");
				System.out.println("donut <x> <y> <radio mayor> <radio menor>");
				System.out.println("ellipse <x> <y> <nose> <nose>");
				System.out.println("delete <position>");
				System.out.println("<coordenadas>");
				System.out.println("list");
				System.out.println("exit\n");
                break;
            case "delete":
				break;
            case "list":
				break;
            case "circle":
				commandValidator(commandSplited,3);
				break;
            case "square":
				commandValidator(commandSplited,3);
				break;
			case "rectangle":
				commandValidator(commandSplited,4);
				break;
			case "triangle":
				commandValidator(commandSplited,6);
				break;
			case "donut":
				commandValidator(commandSplited,4);
				break;
			case "ellipse":
				break;
            default:
			//System.out.println("wrong");
				System.out.println("The command \""+commandSplited[0]+"\" does not exist, use command help for more information.\n");
                break;
		}
		return true;

	}
	
	public static boolean commandValidator(String[] command,int cant){
		
		//System.out.println(command.length);
		if(cant !=command.length-1){
			System.out.println("The command \""+command[0]+"\" exist, but maybe you are using the wrong number of parameters.\nUser command help for more information.\n");
			return false;
		}
		
		for (int i = 1;i<command.length;i++){
			try
			{
			  Double.parseDouble(command[i]);
			}
			catch(NumberFormatException e)
			{
				System.out.println("The parameter number "+i+": \""+command[i]+"\" has a syntax error.");
				return false;
			}
		}
		
		return true;
	}

	public static String[] spliter2(String command){
		String[] resp = command.split(" ");

		return resp;
	}

	public static void leeFichero(){
	File archivo = null;
	FileReader fr = null;
	BufferedReader br = null;
		try {
			 archivo = new File ("../comandos.txt");
			 fr = new FileReader (archivo);
			 br = new BufferedReader(fr);

			 String comandos;
			 while((comandos = br.readLine())!=null)
				System.out.println(comandos);
		}
      catch(Exception e){
         e.printStackTrace();
      }finally{
         try{
            if( fr != null ){
               fr.close();
            }
         }catch (Exception e2){
            e2.printStackTrace();
         }
      }
	}

	private void fijarEscala(float nuevaEscala) {
        escala = Math.max(MIN_ESCALA, Math.min(MAX_ESCALA, nuevaEscala));
        etqEscala.setText(String.format("%4.2f%%", escala * 100f));
    }

	private float trasladar(float a0, float b0, float a1, float b1, float x) {
        float y = (x - a0) / (b0 - a0);
        return a1 + y * (b1 - a1);
    }
	
	private void ajustarPanel() {
        areaDibujo.setPreferredSize(new Dimension(
                (int) (escala * limites.width),
                (int) (escala * limites.height)
        ));
        areaDibujo.invalidate();
    }
	
	private void ajustarMenus() {
        menuPrincipal = new JMenuBar();
        menuPrincipal.add(menuArchivo = new JMenu("Archivo"));
        menuPrincipal.add(menuDatos = new JMenu("Datos"));

        menuArchivo.add(itemSalir = new JMenuItem("Salir"));
        menuDatos.add(itemPrueba = new JMenuItem("Generar Prueba", 'P'));
        itemPrueba.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, Event.CTRL_MASK));

        itemSalir.addActionListener((ActionEvent e) -> {
            dispose();
        });
        itemPrueba.addActionListener((ActionEvent e) -> {
            generarPrueba();
            repaint();
        });

        setJMenuBar(menuPrincipal);
    }
	
	private void generarPrueba() {
        Random rnd = new Random();
        int n = 24;
        System.out.printf("Generando prueba con %d figura(s)..%n", n);

        int mp = 800;
        int ms = 120;
        int Ms = 160;

        int minX = 0;
        int maxX = 0;
        int minY = 0;
        int maxY = 0;

        figuras.clear();

        for (int i = 0; i < n; i++) {
            int x = 0 + rnd.nextInt(mp);
            int y = 0 + rnd.nextInt(mp);
            int w = ms + rnd.nextInt(Ms);
            int h = ms + rnd.nextInt(Ms);
            figuras.add(new Figura(
                    TRAZO_BASE,
                    COLORES_BASE[rnd.nextInt(COLORES_BASE.length)],
                    new Rectangle(x, y, w, h)));

            if (i > 0) {
                minX = Math.min(minX, x);
                minY = Math.min(minY, y);
                maxX = Math.max(maxX, x + w);
                maxY = Math.max(maxY, y + h);
            } else {
                minX = x;
                minY = y;
                maxX = x + w;
                maxY = y + h;
            }
        }

        System.out.printf("min x: %d%n", minX);
        System.out.printf("max x: %d%n", maxX);
        System.out.printf("min y: %d%n", minY);
        System.out.printf("max y: %d%n", maxY);

        int margen = 8;
        for (Figura f : figuras) {
            f.desplazar(margen - minX, margen - minY);
        }

        limites = new Rectangle(0, 0, maxX - minX, maxY - minY);
        limites.grow(margen, margen);
        ajustarPanel();
    }
	
	public void init() {
        generarPrueba();

        fijarEscala(1f);
        ajustarControl();
        setVisible(true);
    }
	
  private void ajustarControl() {
        controlEscala.setValue((int) trasladar(
                MIN_ESCALA, MAX_ESCALA,
                controlEscala.getMinimum(), controlEscala.getMaximum(),
                escala));
    }

	private static void mostrarInterfaz() {
        new Practica().init();
    }

	public static void main(String[] args){
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            JFrame.setDefaultLookAndFeelDecorated(true);
        } catch (ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | UnsupportedLookAndFeelException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }

        SwingUtilities.invokeLater(() -> {
            mostrarInterfaz();
        });

		
		
		boolean flag = true;
		while (flag){
			System.out.print("cmd> ");
			Scanner sc= new Scanner(System.in);
			String str= sc.nextLine(); //reads string.
			//System.out.println(str);
			  str = str+" ";
			flag = eval(str);
		
		}
		// String prueba = "Split con el metodo de java";
		// String[] array = spliter2(prueba);
		// for(int i = 0; i < array.length;i++){
		// 	System.out.println(array[i]);
		// }


	}
}
