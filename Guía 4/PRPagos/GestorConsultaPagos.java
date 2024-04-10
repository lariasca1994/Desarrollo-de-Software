// Archivo: VentanaPrincipal.java

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class GestorConsultaPagos extends JFrame {
    // Componentes de la ventana
    private JButton btnConsultar;
    private JButton btnIngresar;
    private JButton btnSalir;

    // Constructor
    public GestorConsultaPagos() {
        super("Sistema de Pagos"); // Título de la ventana
        setSize(300, 150); // Tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al cerrar la ventana
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        // Crear botones
        btnConsultar = new JButton("Consultar Pagos");
        btnIngresar = new JButton("Ingresar Pago");
        btnSalir = new JButton("Salir");

        // Agregar acción al botón Consultar
        btnConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirGestorConsultaPagos();
            }
        });

        // Agregar acción al botón Ingresar
        btnIngresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ingresarPago();
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

    // Método para abrir la ventana de consulta de pagos
    private void abrirGestorConsultaPagos() {
        // Conectar a la base de datos
        try {
            // Establecer conexión con la base de datos
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl", "ConexionDBA", "Qwerty159");
            System.out.println("Conexión exitosa a la base de datos Oracle");

            // Crear una instancia de la ventana de consulta de pagos y mostrarla
            GestorConsultaPagos GestorConsultaPagos = new GestorConsultaPagos();
            GestorConsultaPagos.setVisible(true);

            // Cerrar la conexión
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al conectar a la base de datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para ingresar un pago
    private void ingresarPago() {
        // Aquí se implementaría la lógica para mostrar la ventana de ingreso de pago
        JOptionPane.showMessageDialog(this, "Funcionalidad de ingreso de pago aún no implementada");
    }

    // Método principal
    public static void main(String[] args) {
        // Crear y mostrar la ventana principal
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GestorConsultaPagos ventana = new GestorConsultaPagos();
                ventana.setVisible(true);
            }
        });
    }

    public void setModal(boolean b) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setModal'");
    }
}