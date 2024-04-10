import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class VentanaConsultaPagos extends JFrame {
    private JTable tablaPagos;
    private JLabel lblTotalPagado;
    private JButton btnModificar;
    private JButton btnVolver;
    @SuppressWarnings("unused")
    private JTextField txtMonto;
    @SuppressWarnings("unused")
    private JTextField txtFecha;
    @SuppressWarnings("unused")
    private JTextField txtConcepto;

    public VentanaConsultaPagos() {
        super("Consulta de Pagos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear tabla para mostrar los pagos
        tablaPagos = new JTable();
        JScrollPane scrollPane = new JScrollPane(tablaPagos);

        // Crear etiqueta para mostrar el total pagado
        lblTotalPagado = new JLabel("Total Pagado: ");

        // Botón para modificar un pago
        btnModificar = new JButton("Modificar Pago");
        btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modificarPago();
            }
        });

        // Botón de Volver
        btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // Crear panel y agregar componentes
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(lblTotalPagado, BorderLayout.SOUTH);
        JPanel panelBotones = new JPanel(new BorderLayout());
        panelBotones.add(btnModificar, BorderLayout.WEST);
        panelBotones.add(btnVolver, BorderLayout.EAST);
        panel.add(panelBotones, BorderLayout.NORTH);

        // Agregar panel a la ventana
        getContentPane().add(panel);

        cargarDatosDePagos();
    }

    private void cargarDatosDePagos() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl", "ConexionDBA", "Qwerty159");
            PreparedStatement stmt = conn.prepareStatement("SELECT id_pago, monto, fecha, concepto FROM TBPagos");
            ResultSet rs = stmt.executeQuery();

            // Crear un modelo de tabla para mostrar los datos
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID Pago");
            modelo.addColumn("Monto");
            modelo.addColumn("Fecha");
            modelo.addColumn("Concepto");

            double totalPagado = 0.0;
            while (rs.next()) {
                Vector<Object> fila = new Vector<>();
                fila.add(rs.getInt("id_pago"));
                fila.add(rs.getDouble("monto"));
                fila.add(rs.getDate("fecha"));
                fila.add(rs.getString("concepto"));
                modelo.addRow(fila);
                totalPagado += rs.getDouble("monto");
            }

            tablaPagos.setModel(modelo);
            actualizarTotalPagado(totalPagado);

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void modificarPago() {
        int selectedRow = tablaPagos.getSelectedRow();
        if (selectedRow != -1) {
            int idPago = (int) tablaPagos.getValueAt(selectedRow, 0);
            double montoActual = (double) tablaPagos.getValueAt(selectedRow, 1);
            java.sql.Date fechaActual = (java.sql.Date) tablaPagos.getValueAt(selectedRow, 2);
            String conceptoActual = (String) tablaPagos.getValueAt(selectedRow, 3);

            VentanaModificarPago ventanaModificarPago = new VentanaModificarPago(idPago, montoActual, fechaActual, conceptoActual);
            ventanaModificarPago.setVisible(true);
        }
    }

    public void actualizarTotalPagado(double total) {
        lblTotalPagado.setText("Total Pagado: " + total);
    }
}