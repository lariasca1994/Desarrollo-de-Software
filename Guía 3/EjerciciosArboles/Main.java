import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainWindow mainWindow = new MainWindow();
                mainWindow.setVisible(true);
            }
        });
    }

    private static class MainWindow extends JFrame {
        private JList<String> optionsList;
        private JButton calculateButton;

        public MainWindow() {
            setTitle("Ejercicios sobre Árboles Binarios");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(400, 300);
            setLocationRelativeTo(null);

            // Crear el JList con las opciones del menú
            String[] options = {"Punto 1", "Punto 2", "Punto 3", "Punto 4", "Punto 5"};
            optionsList = new JList<>(options);

            // Crear el botón "Calcular"
            calculateButton = new JButton("Calcular");
            calculateButton.setEnabled(false);

            // Agregar un ActionListener al JList
            optionsList.addListSelectionListener(e -> {
                if (!e.getValueIsAdjusting()) {
                    calculateButton.setEnabled(true);
                }
            });

            // Agregar un ActionListener al botón "Calcular"
            calculateButton.addActionListener(new CalculateButtonListener());

            // Crear un botón "Salir"
            JButton exitButton = new JButton("Salir");
            exitButton.addActionListener(e -> System.exit(0));

            // Crear un panel para los componentes
            JPanel panel = new JPanel(new BorderLayout());
            panel.add(new JScrollPane(optionsList), BorderLayout.CENTER);
            panel.add(calculateButton, BorderLayout.EAST);
            panel.add(exitButton, BorderLayout.SOUTH);

            add(panel);
        }

        private class CalculateButtonListener implements java.awt.event.ActionListener {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                int selectedIndex = optionsList.getSelectedIndex();
                switch (selectedIndex) {
                    case 0:
                        // Abrir la ventana para el Punto 1
                        Punto1Window punto1Window = new Punto1Window();
                        punto1Window.setVisible(true);
                        break;
                    case 1:
                        // Abrir la ventana para el Punto 2
                        Punto2Window punto2Window = new Punto2Window();
                        punto2Window.setVisible(true);
                        break;
                    case 2:
                        // Abrir la ventana para el Punto 3
                        Punto3Window punto3Window = new Punto3Window();
                        punto3Window.setVisible(true);
                        break;
                    case 3:
                        // Abrir la ventana para el Punto 4
                        Punto4Window punto4Window = new Punto4Window();
                        punto4Window.setVisible(true);
                        break;
                    case 4:
                        // Abrir la ventana para el Punto 5
                        Punto5Window punto5Window = new Punto5Window();
                        punto5Window.setVisible(true);
                        break;
                    // Agregar casos para los otros puntos
                    default:
                        break;
                }
            }
        }
    }
}