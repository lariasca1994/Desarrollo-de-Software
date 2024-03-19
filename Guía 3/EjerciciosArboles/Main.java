import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private static final String[] PUNTOS = {"Punto 1", "Punto 2", "Punto 3", "Punto 4", "Punto 5"};

    public Main() {
        setTitle("Ejercicios sobre Árboles Binarios");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        JList<String> lista = new JList<>(PUNTOS);
        panel.add(new JScrollPane(lista), BorderLayout.CENTER);

        JButton salirButton = new JButton("Salir");
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        panel.add(salirButton, BorderLayout.SOUTH);

        lista.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int index = lista.getSelectedIndex();
                if (index != -1) {
                    switch (index) {
                        case 0:
                            new Punto1().setVisible(true);
                            break;
                        case 1:
                            new Punto2().setVisible(true);
                            break;
                        case 2:
                            new Punto3().setVisible(true);
                            break;
                        case 3:
                            new Punto4().setVisible(true);
                            break;
                        case 4:
                            new Punto5().setVisible(true);
                            break;
                    }
                }
            }
        });

        setContentPane(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}