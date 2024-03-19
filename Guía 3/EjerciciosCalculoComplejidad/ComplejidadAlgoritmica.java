import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComplejidadAlgoritmica extends JFrame implements ActionListener {
    private JButton btn1, btn2, btn3, btnSalir;
    private JPanel panel;

    public ComplejidadAlgoritmica() {
        setTitle("Complejidad Algoritmica");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        panel = new JPanel(new GridLayout(4, 1, 10, 10));
        btn1 = new JButton("1. Analisis de complejidad");
        btn2 = new JButton("2. Complejidad de algoritmo");
        btn3 = new JButton("3. Comparacion de algoritmos");
        btnSalir = new JButton("Salir");

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btnSalir.addActionListener(this);

        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btnSalir);

        add(panel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            new Punto1();
        } else if (e.getSource() == btn2) {
            new Punto2();
        } else if (e.getSource() == btn3) {
            new Punto3();
        } else if (e.getSource() == btnSalir) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ComplejidadAlgoritmica().setVisible(true);
            }
        });
    }
}