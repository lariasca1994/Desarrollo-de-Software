package com.example.dao;

import com.example.model.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    private static final String SQL_SERVER_URL = "jdbc:sqlserver://localhost:1433;databaseName=InventarioProductos";
    private static final String SQL_SERVER_USERNAME = "usuario";
    private static final String SQL_SERVER_PASSWORD = "contraseña";

    private static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:ORCL";
    private static final String ORACLE_USERNAME = "usuario_oracle";
    private static final String ORACLE_PASSWORD = "contraseña_oracle";

    public static List<Producto> obtenerProductos(String databaseType) {
        List<Producto> productos = new ArrayList<>();

        try (Connection connection = obtenerConexion(databaseType);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Productos")) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String descripcion = resultSet.getString("descripcion");
                double precio = resultSet.getDouble("precio");
                int stock = resultSet.getInt("stock");
                int categoriaId = resultSet.getInt("categoriaId");

                Producto producto = new Producto(id, nombre, descripcion, precio, stock, categoriaId);
                productos.add(producto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productos;
    }

    public static void crearProducto(Producto producto, String databaseType) {
        try (Connection connection = obtenerConexion(databaseType);
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO Productos (nombre, descripcion, precio, stock, categoriaId) VALUES (?, ?, ?, ?, ?)")) {

            statement.setString(1, producto.getNombre());
            statement.setString(2, producto.getDescripcion());
            statement.setDouble(3, producto.getPrecio());
            statement.setInt(4, producto.getStock());
            statement.setInt(5, producto.getCategoriaId());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Implementar los métodos actualizarProducto y eliminarProducto de manera similar

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