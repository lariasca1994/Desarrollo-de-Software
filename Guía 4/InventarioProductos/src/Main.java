import com.example.dao.UsuarioDAO;
import com.example.gui.LoginFrame;
import com.example.model.Usuario;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Configurar la apariencia de la aplicación
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        // Crear y mostrar la pantalla de inicio de sesión
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
    }
}