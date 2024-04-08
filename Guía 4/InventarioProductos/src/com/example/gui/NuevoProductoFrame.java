package com.example.gui;

import com.example.dao.CategoriaDAO;
import com.example.dao.ProductoDAO;
import com.example.model.Categoria;
import com.example.model.Producto;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.List;

public class NuevoProductoFrame extends JFrame {
    private JTextField nombreField;
    private JTextArea descripcionArea;
    private JTextField precioField;
    private JTextField stockField;
    private JComboBox<Categoria> categoriaComboBox;
    private JButton guardarButton;
    private JButton volverButton;
    private String databaseType;

    public NuevoProductoFrame(String databaseType) {
        this(null, databaseType);
    }

    public NuevoProductoFrame(Producto producto, String databaseType) {
        this.databaseType = databaseType;
        setTitle("Nuevo Producto");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Nombre:"), gbc);

        gbc.gridx = 1;
        panel.add(nombreField = new JTextField(20), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Descripción:"), gbc);

        gbc.gridx = 1;
        panel.add(new JScrollPane(descripcionArea = new JTextArea(5, 20)), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Precio:"), gbc);

        gbc.gridx = 1;
        panel.add(precioField = new JTextField(10), gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Stock:"), gbc);

        gbc.gridx = 1;
        panel.add(stockField = new JTextField(10), gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Categoría:"), gbc);

        gbc.gridx = 1;
        List<Categoria> categorias = CategoriaDAO.obtenerCategorias(databaseType);
        categoriaComboBox = new JComboBox<>(categorias.toArray(new Categoria[0]));
        panel.add(categoriaComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(guardarButton = new JButton("Guardar"), gbc);

        gbc.gridy = 6;
        panel.add(volverButton = new JButton("Volver"), gbc);

        add(panel, BorderLayout.CENTER);

        if (producto != null) {
            nombreField.setText(producto.getNombre());
            descripcionArea.setText(producto.getDescripcion());
            precioField.setText(String.valueOf(producto.getPrecio()));
            stockField.setText(String.valueOf(producto.getStock()));
            categoriaComboBox.setSelectedItem(new Categoria(producto.getCategoriaId(), null, null));
        }

        guardarButton.addActionListener(e -> {
            String nombre = nombreField.getText();
            String descripcion = descripcionArea.getText();
            double precio = Double.parseDouble(precioField.getText());
            int stock = Integer.parseInt(stockField.getText());
            Categoria categoria = (Categoria) categoriaComboBox.getSelectedItem();

            if (producto == null) {
                Producto nuevoProducto = new Producto(nombre, descripcion, precio, stock, categoria.getId());
                ProductoDAO.crearProducto(nuevoProducto, databaseType);
            } else {
                producto.setNombre(nombre);
                producto.setDescripcion(descripcion);
                producto.setPrecio(precio);
                producto.setStock(stock);
                producto.setCategoriaId(categoria.getId());
                ProductoDAO.actualizarProducto(producto, databaseType);
            }

            dispose();
        });

        volverButton.addActionListener(e -> {
            dispose();
        });
    }
}