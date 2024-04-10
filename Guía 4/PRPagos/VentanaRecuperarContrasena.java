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

public class VentanaRecuperarContrasena extends JFrame {
    private JTextField txtCorreo;
    private JPasswordField txtNuevaContrasena;
    private JButton btnEnviar;
    private JButton btnCancelar;

    public VentanaRecuperarContrasena() {
        super("Recuperar Contraseña");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear componentes
        JLabel lblCorreo = new JLabel("Correo:");
        txtCorreo = new JTextField();
        JLabel lblNuevaContrasena = new JLabel("Nueva Contraseña:");
        txtNuevaContrasena = new JPasswordField();
        btnEnviar = new JButton("Enviar");
        btnCancelar = new JButton("Cancelar");

        // Agregar acción a los botones
        btnEnviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                recuperarContrasena();
            }
        });
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // Crear panel y agregar componentes
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.add(lblCorreo);
        panel.add(txtCorreo);
        panel.add(lblNuevaContrasena);
        panel.add(txtNuevaContrasena);
        panel.add(btnEnviar);
        panel.add(btnCancelar);

        // Agregar panel a la ventana
        getContentPane().add(panel, BorderLayout.CENTER);
    }

    private void recuperarContrasena() {
        String correo = txtCorreo.getText();

        if (validarCorreo(correo)) {
            try {
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl", "ConexionDBA", "Qwerty159");
                CallableStatement stmt = conn.prepareCall("{CALL recuperar_contrasena(?, ?)}");
                stmt.setString(1, correo);
                stmt.setString(2, new String(txtNuevaContrasena.getPassword()));
                stmt.execute();

                JOptionPane.showMessageDialog(this, "Contraseña recuperada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al recuperar la contraseña: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "El correo electrónico no es válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean validarCorreo(String correo) {
        String regex = "^[a-zA-Z0-9_.+-]+@EAN.com$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }
}