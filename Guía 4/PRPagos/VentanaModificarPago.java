import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("unused")
public class VentanaModificarPago extends JFrame {
    private JTextField txtMonto;
    private JTextField txtFecha;
    private JTextField txtConcepto;
    private JButton btnModificar;
    private JButton btnVolver;
    private int idPago;
    private VentanaConsultaPagos ventanaConsultaPagos;

    public VentanaModificarPago(int idPago, double montoActual, java.sql.Date fechaActual, String conceptoActual, VentanaConsultaPagos ventanaConsultaPagos) {
        super("Modificar Pago");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        this.idPago = idPago;
        this.ventanaConsultaPagos = ventanaConsultaPagos;

        // Crear componentes
        JLabel lblMonto = new JLabel("Monto:");
        txtMonto = new JTextField(String.valueOf(montoActual));
        JLabel lblFecha = new JLabel("Fecha (dd/MM/yyyy):");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        txtFecha = new JTextField(sdf.format(fechaActual));
        JLabel lblConcepto = new JLabel("Concepto:");
        txtConcepto = new JTextField(conceptoActual);
        btnModificar = new JButton("Modificar");
        btnVolver = new JButton("Volver");

        // Agregar acción a los botones
        btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modificarPago();
            }
        });
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // Crear panel y agregar componentes
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.add(lblMonto);
        panel.add(txtMonto);
        panel.add(lblFecha);
        panel.add(txtFecha);
        panel.add(lblConcepto);
        panel.add(txtConcepto);
        panel.add(btnModificar);
        panel.add(btnVolver);

        // Agregar panel a la ventana
        getContentPane().add(panel, BorderLayout.CENTER);
    }

    private void modificarPago() {
        try {
            double nuevoMonto = Double.parseDouble(txtMonto.getText());
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date fechaUtil = sdf.parse(txtFecha.getText());
            java.sql.Date nuevoFecha = new java.sql.Date(fechaUtil.getTime());
            String nuevoConcepto = txtConcepto.getText();

            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl", "ConexionDBA", "Qwerty159");
            CallableStatement stmt = conn.prepareCall("{CALL actualizar_tbpago(?, ?, ?, ?)}");
            stmt.setInt(1, idPago);
            stmt.setDouble(2, nuevoMonto);
            stmt.setDate(3, nuevoFecha);
            stmt.setString(4, nuevoConcepto);
            stmt.execute();

            stmt.close();
            conn.close();

            JOptionPane.showMessageDialog(this, "Pago modificado correctamente.");
            ventanaConsultaPagos.actualizarListaDePagos(); // Llamar al método de actualización
            dispose();
        } catch (NumberFormatException | ParseException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al modificar el pago: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}