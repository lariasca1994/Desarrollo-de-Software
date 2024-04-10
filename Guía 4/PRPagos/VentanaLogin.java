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

public class VentanaLogin extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    private JButton btnIngresar;
    private JButton btnSalir;
    private JButton btnNuevoUsuario;
    private JButton btnOlvidarContrasena;

    public VentanaLogin() {
        super("Login");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear componentes
        JLabel lblUsuario = new JLabel("Usuario:");
        txtUsuario = new JTextField();
        JLabel lblContrasena = new JLabel("Contraseña:");
        txtContrasena = new JPasswordField();
        btnIngresar = new JButton("Ingresar");
        btnSalir = new JButton("Salir");
        btnNuevoUsuario = new JButton("Crear Usuario");
        btnOlvidarContrasena = new JButton("Olvidé mi contraseña");

        // Agregar acción a los botones
        btnIngresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnNuevoUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirVentanaCrearUsuario();
            }
        });
        btnOlvidarContrasena.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirVentanaRecuperarContrasena();
            }
        });

        // Crear panel y agregar componentes
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.add(lblUsuario);
        panel.add(txtUsuario);
        panel.add(lblContrasena);
        panel.add(txtContrasena);
        panel.add(btnIngresar);
        panel.add(btnSalir);
        panel.add(btnNuevoUsuario);
        panel.add(btnOlvidarContrasena);

        // Agregar panel a la ventana
        getContentPane().add(panel, BorderLayout.CENTER);
    }

    private void login() {
        String usuario = txtUsuario.getText();
        String contrasena = new String(txtContrasena.getPassword());

        try {
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl", "ConexionDBA", "Qwerty159");
            CallableStatement stmt = conn.prepareCall("{CALL validar_login(?, ?, ?)}");
            stmt.setString(1, usuario);
            stmt.setString(2, contrasena);
            stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
            stmt.execute();

            String nombre = stmt.getString(3);
            if (nombre != null) {
                JOptionPane.showMessageDialog(this, "Bienvenido, " + nombre + ".");

                // Abrir la ventana principal y pasar el nombre del usuario
                VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(nombre);
                ventanaPrincipal.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al conectar a la base de datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void abrirVentanaCrearUsuario() {
        VentanaCrearUsuario ventanaCrearUsuario = new VentanaCrearUsuario();
        ventanaCrearUsuario.setVisible(true);
    }

    private void abrirVentanaRecuperarContrasena() {
        VentanaRecuperarContrasena ventanaRecuperarContrasena = new VentanaRecuperarContrasena();
        ventanaRecuperarContrasena.setVisible(true);
    }

    public static void main(String[] args) {
        VentanaLogin ventanaLogin = new VentanaLogin();
        ventanaLogin.setVisible(true);
    }
}