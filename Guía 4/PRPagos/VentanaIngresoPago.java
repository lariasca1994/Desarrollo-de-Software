import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaIngresoPago extends JFrame {
    private JTextField txtMonto;
    private JTextField txtFecha;
    private JTextField txtConcepto;
    private JButton btnAgregar;
    private JButton btnVolver;

    public VentanaIngresoPago() {
        super("Ingresar Pago");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear componentes
        JLabel lblMonto = new JLabel("Monto:");
        txtMonto = new JTextField();
        JLabel lblFecha = new JLabel("Fecha (dd/MM/yyyy):");
        txtFecha = new JTextField();
        JLabel lblConcepto = new JLabel("Concepto:");
        txtConcepto = new JTextField();
        btnAgregar = new JButton("Agregar");
        btnVolver = new JButton("Volver");

        // Agregar acción a los botones
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ingresarPago();
            }
        });
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // Crear panel y agregar componentes
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.add(lblMonto);
        panel.add(txtMonto);
        panel.add(lblFecha);
        panel.add(txtFecha);
        panel.add(lblConcepto);
        panel.add(txtConcepto);
        panel.add(btnAgregar);
        panel.add(btnVolver);

        // Agregar panel a la ventana
        getContentPane().add(panel, BorderLayout.CENTER);
    }

    private void ingresarPago() {
        try {
            double monto = Double.parseDouble(txtMonto.getText());
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = sdf.parse(txtFecha.getText());
            java.sql.Date sqlFecha = new java.sql.Date(fecha.getTime());
            String concepto = txtConcepto.getText();

            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl", "ConexionDBA", "Qwerty159");
            PreparedStatement stmt = conn.prepareStatement("CALL insertar_tbpago(?, ?, ?)");
            stmt.setDouble(1, monto);
            stmt.setDate(2, sqlFecha);
            stmt.setString(3, concepto);
            stmt.executeUpdate();

            stmt.close();
            conn.close();

            JOptionPane.showMessageDialog(this, "Pago ingresado correctamente.");
            dispose();
        } catch (NumberFormatException | ParseException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al ingresar el pago: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}