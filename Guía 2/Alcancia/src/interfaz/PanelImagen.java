/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Programa de Ingeniería de Sistemas
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Desarrollo de Software - Guía 2 - Actividad 2
 * Ejercicio: alcancia
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package interfaz;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel con la imagen del banner.
 */
@SuppressWarnings("serial")
public class PanelImagen extends JPanel {
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel. <br>
     * <b>post: </b> Panel quedó inicializado.
     */
    public PanelImagen() {
        JLabel imagen = new JLabel();
        ImageIcon icono = new ImageIcon("./data/Encabezado.png");
        imagen = new JLabel("");
        imagen.setIcon(icono);
        add(imagen);
    }

}
