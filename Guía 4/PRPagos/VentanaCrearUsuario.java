import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

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

        if (validarUsuario(usuario)) {
            try {
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl", "ConexionDBA", "Qwerty159");
                CallableStatement stmt = conn.prepareCall("{CALL crear_usuario_app(?, ?, ?)}");
                stmt.setString(1, usuario);
                stmt.setString(2, nombre);
                stmt.setString(3, contrasena);
                stmt.execute();

                JOptionPane.showMessageDialog(this, "Usuario creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al crear el usuario: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "El usuario no es válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean validarUsuario(String usuario) {
        // Puedes agregar más validaciones si lo deseas
        return usuario.length() >= 5;
    }
}