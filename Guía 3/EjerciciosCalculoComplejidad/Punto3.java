import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Punto3 extends JFrame implements ActionListener {
    private JButton btnVolver;
    private JTextArea txtArea;

    public Punto3() {
        setTitle("Punto 3. Comparacion de algoritmos");
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
        compararAlgoritmos();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVolver) {
            dispose();
        }
    }

    private void compararAlgoritmos() {
        txtArea.setText("Ejemplo 1:\n");
        txtArea.append("boolean Ex1(int[] a, int elem) {\n");
        txtArea.append("\tint pos = buscar(a, elem); // O(n log n)\n");
        txtArea.append("\tint n = a.length; // O(1)\n");
        txtArea.append("\tint x = pos; // O(1)\n");
        txtArea.append("\tfor (int i = 0; i < n; ++i) { // O(n)\n");
        txtArea.append("\t\tx += 2; // O(1)\n");
        txtArea.append("\t\tfor (int j = 0; j < n; ++j) { // O(n)\n");
        txtArea.append("\t\t\tif (a[j] > a[pos]) { // O(1)\n");
        txtArea.append("\t\t\t\tx++; // O(1)\n");
        txtArea.append("\t\t\t}\n");
        txtArea.append("\t\t}\n");
        txtArea.append("\t}\n");
        txtArea.append("\treturn x > elem; // O(1)\n");
        txtArea.append("}\n\n");
        txtArea.append("Complejidad: O(n log n) + O(n^2) = O(n^2)\n\n");

        txtArea.append("Ejemplo 2:\n");
        txtArea.append("boolean Ex2(int[] a, int elem) {\n");
        txtArea.append("\tint n = a.length; // O(1)\n");
        txtArea.append("\tint x = 0; // O(1)\n");
        txtArea.append("\tfor (int i = 0; i < n; ++i) { // O(n)\n");
        txtArea.append("\t\tint pos = buscar(a, elem); // O(n log n)\n");
        txtArea.append("\t\tx += pos + 2; // O(1)\n");
        txtArea.append("\t\tfor (int j = 0; j < n; ++j) { // O(n)\n");
        txtArea.append("\t\t\tif (a[j] > a[pos]) { // O(1)\n");
        txtArea.append("\t\t\t\tx++; // O(1)\n");
        txtArea.append("\t\t\t}\n");
        txtArea.append("\t\t}\n");
        txtArea.append("\t}\n");
        txtArea.append("\treturn x > elem; // O(1)\n");
        txtArea.append("}\n\n");
        txtArea.append("Complejidad: O(n^2 log n)\n");
        txtArea.append("Por lo tanto, es mejor utilizar el Ejemplo 1 con complejidad O(n^2).\n");
    }
}