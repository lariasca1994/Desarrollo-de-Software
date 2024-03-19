import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Punto2 extends JFrame implements ActionListener {
    private JButton btnCalcular, btnVolver;
    private JTextArea txtArea;

    public Punto2() {
        setTitle("Punto 2. Complejidad de algoritmo");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        JPanel panelSur = new JPanel(new FlowLayout());

        txtArea = new JTextArea(15, 30);
        txtArea.setEditable(false);
        panel.add(new JScrollPane(txtArea), BorderLayout.CENTER);

        btnVolver = new JButton("Volver");
        panelSur.add(btnVolver);
        btnVolver.addActionListener(this);

        panel.add(panelSur, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
        calcular();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVolver) {
            dispose();
        }
    }

    private void calcular() {
        txtArea.setText("void XXXXXX(int n)\n");
        txtArea.append("int x = 0;\n");
        txtArea.append("for (int i = 1; i <= n; i *= 5) {\n");
        txtArea.append("\tint j = 1;\n");
        txtArea.append("\tfor (int j = 1; j <= n; j += 2) {\n");
        txtArea.append("\t\tx = x + j;\n");
        txtArea.append("\t}\n");
        txtArea.append("\tfor (int k = n; k >= 1; k /= 2) {\n");
        txtArea.append("\t\tx = x + 1;\n");
        txtArea.append("\t}\n");
        txtArea.append("}\n\n");

        txtArea.append("Analisis de complejidad:\n");
        txtArea.append("El ciclo externo se ejecuta log5(n) + 1 veces.\n");
        txtArea.append("El ciclo interno se ejecuta n/2 veces.\n");
        txtArea.append("El tercer ciclo se ejecuta log2(n) + 1 veces.\n");
        txtArea.append("Por lo tanto, la complejidad del algoritmo es O(n log n).\n");
    }
}