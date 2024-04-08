package com.example.gui;

import com.example.dao.ProductoDAO;
import com.example.model.Producto;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.List;

public class ProductosFrame extends JFrame {
    private JTable productosTable;
    private JButton nuevoButton;
    private JButton editarButton;
    private JButton eliminarButton;
    private JButton volverButton;
    private String databaseType;

    public ProductosFrame(String databaseType) {
        this.databaseType = databaseType;
        setTitle("Productos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        // Tabla de productos
        productosTable = new JTable(new ProductosTableModel(databaseType));
        JScrollPane scrollPane = new JScrollPane(productosTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Botones
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        nuevoButton = new JButton("Nuevo");
        editarButton = new JButton("Editar");
        eliminarButton = new JButton("Eliminar");
        volverButton = new JButton("Volver");
        buttonsPanel.add(nuevoButton);
        buttonsPanel.add(editarButton);
        buttonsPanel.add(eliminarButton);
        buttonsPanel.add(volverButton);
        panel.add(buttonsPanel, BorderLayout.SOUTH);

        add(panel, BorderLayout.CENTER);

        nuevoButton.addActionListener(e -> {
            NuevoProductoFrame nuevoProductoFrame = new NuevoProductoFrame(databaseType);
            nuevoProductoFrame.setVisible(true);
        });

        editarButton.addActionListener(e -> {
            int selectedRow = productosTable.getSelectedRow();
            if (selectedRow != -1) {
                Producto producto = ((ProductosTableModel) productosTable.getModel()).getProducto(selectedRow);
                NuevoProductoFrame nuevoProductoFrame = new NuevoProductoFrame(producto, databaseType);
                nuevoProductoFrame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un producto para editar.");
            }
        });

        eliminarButton.addActionListener(e -> {
            int selectedRow = productosTable.getSelectedRow();
            if (selectedRow != -1) {
                Producto producto = ((ProductosTableModel) productosTable.getModel()).getProducto(selectedRow);
                int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar el producto?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    ProductoDAO.eliminarProducto(producto, databaseType);
                    ((ProductosTableModel) productosTable.getModel()).removeProducto(selectedRow);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un producto para eliminar.");
            }
        });

        volverButton.addActionListener(e -> {
            dispose();
        });
    }
}