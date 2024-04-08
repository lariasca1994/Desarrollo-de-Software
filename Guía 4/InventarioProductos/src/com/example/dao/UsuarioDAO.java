package com.example.dao;

import com.example.model.Usuario;

import java.sql.*;

public class UsuarioDAO {
    private static final String SQL_SERVER_URL = "jdbc:sqlserver://localhost:1433;databaseName=InventarioProductos";
    private static final String SQL_SERVER_USERNAME = "usuario";
    private static final String SQL_SERVER_PASSWORD = "contraseña";

    private static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:ORCL";
    private static final String ORACLE_USERNAME = "usuario_oracle";
    private static final String ORACLE_PASSWORD = "contraseña_oracle";

    public static Usuario autenticarUsuario(String username, String password, String databaseType) {
        try (Connection connection = obtenerConexion(databaseType);
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM Usuarios WHERE username = ? AND password = ?")) {

            statement.setString(1, username);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nombre = resultSet.getString("nombre");
                    String rol = resultSet.getString("rol");
                    return new Usuario(id, username, nombre, rol);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void crearUsuario(Usuario usuario, String databaseType) {
        try (Connection connection = obtenerConexion(databaseType);
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO Usuarios (username, password, nombre, rol) VALUES (?, ?, ?, ?)")) {

            statement.setString(1, usuario.getUsername());
            statement.setString(2, usuario.getPassword());
            statement.setString(3, usuario.getNombre());
            statement.setString(4, usuario.getRol());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection obtenerConexion(String databaseType) throws SQLException {
        if (databaseType.equalsIgnoreCase("sqlserver")) {
            return DriverManager.getConnection(SQL_SERVER_URL, SQL_SERVER_USERNAME, SQL_SERVER_PASSWORD);
        } else if (databaseType.equalsIgnoreCase("oracle")) {
            return DriverManager.getConnection(ORACLE_URL, ORACLE_USERNAME, ORACLE_PASSWORD);
        } else {
            throw new IllegalArgumentException("Tipo de base de datos no válido");
        }
    }
}