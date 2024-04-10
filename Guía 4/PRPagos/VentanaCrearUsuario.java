import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("unused")
public class VentanaCrearUsuario extends JFrame {
    private JTextField txtUsuario;
    private JTextField txtNombre;
    private JPasswordField txtContrasena;
    private JButton btnCrear;
    private JButton btnCancelar;

    public VentanaCrearUsuario() {
        super("Crear Usuario");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear componentes
        JLabel lblUsuario = new JLabel("Usuario:");
        txtUsuario = new JTextField();
        JLabel lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField();
        JLabel lblContrasena = new JLabel("Contraseña:");
        txtContrasena = new JPasswordField();
        btnCrear = new JButton("Crear");
        btnCancelar = new JButton("Cancelar");

        // Agregar acción a los botones
        btnCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crearUsuario();
            }
        });
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // Crear panel y agregar componentes
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.add(lblUsuario);
        panel.add(txtUsuario);
        panel.add(lblNombre);
        panel.add(txtNombre);
        panel.add(lblContrasena);
        panel.add(txtContrasena);
        panel.add(btnCrear);
        panel.add(btnCancelar);

        // Agregar panel a la ventana
        getContentPane().add(panel, BorderLayout.CENTER);
    }

    private void crearUsuario() {
        String usuario = txtUsuario.getText();
        String nombre = txtNombre.getText();
        String contrasena = new String(txtContrasena.getPassword());

        try {
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl", "ConexionDBA", "Qwerty159");
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO TBPLogin (id, usuario, nombre, password) VALUES (tblogin_sequence.NEXTVAL, ?, ?, ?)");
            stmt.setString(1, usuario);
            stmt.setString(2, nombre);
            stmt.setString(3, contrasena);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected == 1) {
                JOptionPane.showMessageDialog(this, "Usuario creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error al crear el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            stmt.close();
            conn.close();
            dispose();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al crear el usuario: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}