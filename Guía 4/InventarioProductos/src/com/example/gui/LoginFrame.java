package com.example.gui;

import com.example.dao.UsuarioDAO;
import com.example.model.Usuario;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton createUserButton;
    private JButton exitButton;
    private String databaseType;

    public LoginFrame(String databaseType) {
        this.databaseType = databaseType;
        setTitle("Inicio de Sesión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Usuario:"), gbc);

        gbc.gridx = 1;
        panel.add(usernameField = new JTextField(20), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Contraseña:"), gbc);

        gbc.gridx = 1;
        panel.add(passwordField = new JPasswordField(20), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(loginButton = new JButton("Iniciar Sesión"), gbc);

        gbc.gridy = 3;
        panel.add(createUserButton = new JButton("Crear Usuario"), gbc);

        gbc.gridy = 4;
        panel.add(exitButton = new JButton("Salir"), gbc);

        add(panel, BorderLayout.CENTER);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            Usuario usuario = UsuarioDAO.autenticarUsuario(username, password, databaseType);
            if (usuario != null) {
                JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso.");
                MainFrame mainFrame = new MainFrame(usuario, databaseType);
                mainFrame.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Credenciales inválidas.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        createUserButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            Usuario usuario = new Usuario(username, password);
            UsuarioDAO.crearUsuario(usuario, databaseType);
            JOptionPane.showMessageDialog(this, "Usuario creado exitosamente.");
        });

        exitButton.addActionListener(e -> {
            dispose();
        });
    }
}