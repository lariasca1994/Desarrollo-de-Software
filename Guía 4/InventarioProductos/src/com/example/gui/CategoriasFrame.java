package com.example.gui;

import com.example.dao.CategoriaDAO;
import com.example.model.Categoria;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.List;

public class CategoriasFrame extends JFrame {
    private JTable categoriasTable;
    private JButton nuevaButton;
    private JButton editarButton;
    private JButton eliminarButton;
    private JButton volverButton;
    private String databaseType;

    public CategoriasFrame(String databaseType) {
        this.databaseType = databaseType;
        setTitle("Categorías");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        // Tabla de categorías
        categoriasTable = new JTable(new CategoriasTableModel(databaseType));
        JScrollPane scrollPane = new JScrollPane(categoriasTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Botones
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        nuevaButton = new JButton("Nueva");
        editarButton = new JButton("Editar");
        eliminarButton = new JButton("Eliminar");
        volverButton = new JButton("Volver");
        buttonsPanel.add(nuevaButton);
        buttonsPanel.add(editarButton);
        buttonsPanel.add(eliminarButton);
        buttonsPanel.add(volverButton);
        panel.add(buttonsPanel, BorderLayout.SOUTH);

        add(panel, BorderLayout.CENTER);

        nuevaButton.addActionListener(e -> {
            NuevaCategoriaFrame nuevaCategoriaFrame = new NuevaCategoriaFrame(databaseType);
            nuevaCategoriaFrame.setVisible(true);
        });

        editarButton.addActionListener(e -> {
            int selectedRow = categoriasTable.getSelectedRow();
            if (selectedRow != -1) {
                Categoria categoria = ((CategoriasTableModel) categoriasTable.getModel()).getCategoria(selectedRow);
                NuevaCategoriaFrame nuevaCategoriaFrame = new NuevaCategoriaFrame(categoria, databaseType);
                nuevaCategoriaFrame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione una categoría para editar.");
            }
        });

        eliminarButton.addActionListener(e -> {
            int selectedRow = categoriasTable.getSelectedRow();
            if (selectedRow != -1) {
                Categoria categoria = ((CategoriasTableModel) categoriasTable.getModel()).getCategoria(selectedRow);
                int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar la categoría?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    CategoriaDAO.eliminarCategoria(categoria, databaseType);
                    ((CategoriasTableModel) categoriasTable.getModel()).removeCategoria(selectedRow);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione una categoría para eliminar.");
            }
        });

        volverButton.addActionListener(e -> {
            dispose();
        });
    }
}