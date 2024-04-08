package com.example.gui;

import com.example.model.Usuario;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private String databaseType;

    public MainFrame(Usuario usuario, String databaseType) {
        this.databaseType = databaseType;
        setTitle("Inventario de Productos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JButton("Productos"), gbc);
        panel.getComponent(0).addActionListener(e -> {
            ProductosFrame productosFrame = new ProductosFrame(databaseType);
            productosFrame.setVisible(true);
        });

        gbc.gridy = 1;
        panel.add(new JButton("Categorías"), gbc);
        panel.getComponent(1).addActionListener(e -> {
            CategoriasFrame categoriasFrame = new CategoriasFrame(databaseType);
            categoriasFrame.setVisible(true);
        });

        gbc.gridy = 2;
        panel.add(new JButton("Salir"), gbc);
        panel.getComponent(2).addActionListener(e -> {
            dispose();
        });

        add(panel, BorderLayout.CENTER);
    }
}