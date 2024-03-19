import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Punto1 extends JFrame implements ActionListener {
    private JTextField txtN;
    private JButton btnCalcular, btnVolver;
    private JTextArea txtArea;

    public Punto1() {
        setTitle("Punto 1. Analisis de complejidad");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        JPanel panelNorte = new JPanel(new FlowLayout());
        JPanel panelSur = new JPanel(new FlowLayout());

        panelNorte.add(new JLabel("Ingrese el valor de n (max 25):"));
        txtN = new JTextField(10);
        panelNorte.add(txtN);
        btnCalcular = new JButton("Calcular");
        panelNorte.add(btnCalcular);
        btnCalcular.addActionListener(this);

        txtArea = new JTextArea(15, 30);
        txtArea.setEditable(false);
        panel.add(new JScrollPane(txtArea), BorderLayout.CENTER);

        btnVolver = new JButton("Volver");
        panelSur.add(btnVolver);
        btnVolver.addActionListener(this);

        panel.add(panelNorte, BorderLayout.NORTH);
        panel.add(panelSur, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCalcular) {
            int n = Integer.parseInt(txtN.getText());
            if (n > 25) {
                JOptionPane.showMessageDialog(this, "El valor de n no debe superar 25.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            txtArea.setText("a. T(n) = 2n^3 - 3n^2 + 1 es O(n^3)\n");
            txtArea.append("Demostracion:\n");
            txtArea.append("Sea c = 2 y n0 = 1\n");
            txtArea.append("Para n >= n0:\n");
            txtArea.append("2n^3 - 3n^2 + 1 <= 2n^3 + n^3 + 1 (ya que -3n^2 <= n^3 para n >= 1)\n");
            txtArea.append("= 3n^3 + 1\n");
            txtArea.append("<= 3cn^3 (ya que c = 2 y 1 <= 2n^3 para n >= 1)\n");
            txtArea.append("Por lo tanto, T(n) = O(n^3)\n\n");

            txtArea.append("b. T(n) = n^5 + 4^2 - sqrt(n) + 1 es O(n^5)\n");
            txtArea.append("Demostracion:\n");
            txtArea.append("Sea c = 1 y n0 = 1\n");
            txtArea.append("Para n >= n0:\n");
            txtArea.append("n^5 + 4^2 - sqrt(n) + 1 <= n^5 + 16 + 1 (ya que -sqrt(n) <= 0 para n >= 1)\n");
            txtArea.append("= n^5 + 17\n");
            txtArea.append("<= n^5 + 17n^5 (ya que 17 <= 17n^5 para n >= 1)\n");
            txtArea.append("= 18n^5\n");
            txtArea.append("<= 18cn^5 (ya que c = 1)\n");
            txtArea.append("Por lo tanto, T(n) = O(n^5)\n\n");

            txtArea.append("c. T(n) = n^2 log n + 2n^4 + sqrt(2n) es O(n^4)\n");
            txtArea.append("Demostracion:\n");
            txtArea.append("Sea c = 3 y n0 = 1\n");
            txtArea.append("Para n >= n0:\n");
            txtArea.append("n^2 log n + 2n^4 + sqrt(2n) <= n^2n + 2n^4 + n (ya que log n <= n para n >= 1 y sqrt(2n) <= n para n >= 2)\n");
            txtArea.append("= n^3 + 2n^4 + n\n");
            txtArea.append("<= 2n^4 + n^4 + n^4 (ya que n^3 <= n^4 para n >= 1)\n");
            txtArea.append("= 3n^4 + n^4\n");
            txtArea.append("= 4n^4\n");
            txtArea.append("<= 4cn^4 (ya que c = 3)\n");
            txtArea.append("Por lo tanto, T(n) = O(n^4)\n");
        } else if (e.getSource() == btnVolver) {
            dispose();
        }
    }
}