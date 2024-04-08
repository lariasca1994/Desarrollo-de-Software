package com.example.dao;

import com.example.model.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    private static final String SQL_SERVER_URL = "jdbc:sqlserver://localhost:1433;databaseName=InventarioProductos";
    private static final String SQL_SERVER_USERNAME = "usuario";
    private static final String SQL_SERVER_PASSWORD = "contraseña";

    private static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:ORCL";
    private static final String ORACLE_USERNAME = "usuario_oracle";
    private static final String ORACLE_PASSWORD = "contraseña_oracle";

    public static List<Categoria> obtenerCategorias(String databaseType) {
        List<Categoria> categorias = new ArrayList<>();

        try (Connection connection = obtenerConexion(databaseType);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Categorias")) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String descripcion = resultSet.getString("descripcion");

                Categoria categoria = new Categoria(id, nombre, descripcion);
                categorias.add(categoria);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categorias;
    }

    public static void crearCategoria(Categoria categoria, String databaseType) {
        try (Connection connection = obtenerConexion(databaseType);
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO Categorias (nombre, descripcion) VALUES (?, ?)")) {

            statement.setString(1, categoria.getNombre());
            statement.setString(2, categoria.getDescripcion());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void actualizarCategoria(Categoria categoria, String databaseType) {
        try (Connection connection = obtenerConexion(databaseType);
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE Categorias SET nombre = ?, descripcion = ? WHERE id = ?")) {

            statement.setString(1, categoria.getNombre());
            statement.setString(2, categoria.getDescripcion());
            statement.setInt(3, categoria.getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void eliminarCategoria(Categoria categoria, String databaseType) {
        try (Connection connection = obtenerConexion(databaseType);
             PreparedStatement statement = connection.prepareStatement(
                     "DELETE FROM Categorias WHERE id = ?")) {

            statement.setInt(1, categoria.getId());
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