import com.example.gui.LoginFrame;
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
        LoginFrame loginFrame = new LoginFrame(null);
        loginFrame.setVisible(true);
    }
}