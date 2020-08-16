package practica.figuras;
import java.awt.HeadlessException;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Properties;
import javax.swing.JFrame;

public abstract class VentanaAplicacion extends JFrame {

    public VentanaAplicacion(String titulo) throws HeadlessException {
        super(titulo);
        configurar();
    }

    private void configurar() {
        configuracion = new Properties();

        rutaConfiguracion = getClass().getSimpleName().toLowerCase() + ".cfg";
        //System.out.printf("Configuración en: '%s'%n", rutaConfiguracion);

        try {
            configuracion.loadFromXML(new FileInputStream(rutaConfiguracion));
        } catch (IOException ex) {
            System.err.println("No se pudo cargar el archivo de configuración..");
        }

        addComponentListener(new ComponentAdapter() {

            @Override
            public void componentMoved(ComponentEvent e) {
                guardarConfiguracion();
            }

            @Override
            public void componentResized(ComponentEvent e) {
                guardarConfiguracion();
            }

            private void guardarConfiguracion() {
                try {
                    guardar();
                } catch (IOException ex) {
                    System.err.printf("Excepción: '%s'%n", ex.getMessage());
                }
            }

        });
    }

    public void guardar() throws IOException {
        configuracion.setProperty("wlocx", String.valueOf(getLocation().x));
        configuracion.setProperty("wlocy", String.valueOf(getLocation().y));
        configuracion.setProperty("wlocw", String.valueOf(getWidth()));
        configuracion.setProperty("wloch", String.valueOf(getHeight()));
        try {
            configuracion.storeToXML(new FileOutputStream(rutaConfiguracion),
                    Calendar.getInstance().toString());
        } catch (IOException ex) {
            System.err.printf("Error al guardar la configuración: '%s'%n", ex.getMessage());
            throw ex;
        }
    }

    public void restaurar() throws IllegalArgumentException {
        try {
            int x = Integer.parseInt(configuracion.getProperty("wlocx"));
            int y = Integer.parseInt(configuracion.getProperty("wlocy"));
            int w = Integer.parseInt(configuracion.getProperty("wlocw"));
            int h = Integer.parseInt(configuracion.getProperty("wloch"));

            setLocation(x, y);
            setSize(w, h);

        } catch (NumberFormatException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            throw ex;
        }
    }

    private String rutaConfiguracion;
    private Properties configuracion;
}
