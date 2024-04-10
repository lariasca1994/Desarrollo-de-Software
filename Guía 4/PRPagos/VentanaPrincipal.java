import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class VentanaPrincipal extends JFrame {
    private JButton btnConsultar;
    private JButton btnIngresar;
    private JButton btnSalir;

    public VentanaPrincipal() {
        super("Sistema de Pagos");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear botones
        btnConsultar = new JButton("Consultar Pagos");
        btnIngresar = new JButton("Ingresar Pago");
        btnSalir = new JButton("Salir");

        // Agregar acción al botón Consultar
        btnConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirVentanaConsultaPagos();
            }
        });

        // Agregar acción al botón Ingresar
        btnIngresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirVentanaIngresoPago();
            }
        });

        // Agregar acción al botón Salir
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Crear panel y agregar componentes
        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.add(btnConsultar);
        panel.add(btnIngresar);
        panel.add(btnSalir);

        // Agregar panel a la ventana
        getContentPane().add(panel, BorderLayout.CENTER);
    }

    private void abrirVentanaConsultaPagos() {
        VentanaConsultaPagos ventanaConsultaPagos = new VentanaConsultaPagos();
        ventanaConsultaPagos.setVisible(true);
    }

    private void abrirVentanaIngresoPago() {
        VentanaIngresoPago ventanaIngresoPago = new VentanaIngresoPago();
        ventanaIngresoPago.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                VentanaPrincipal ventana = new VentanaPrincipal();
                ventana.setVisible(true);
            }
        });
    }
}   