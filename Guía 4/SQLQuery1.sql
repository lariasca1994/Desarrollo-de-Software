CREATE DATABASE InventarioProductos;
USE InventarioProductos;

-- Tabla Usuarios
CREATE TABLE Usuarios (
    id INT PRIMARY KEY IDENTITY(1,1),
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    rol VARCHAR(50) NOT NULL
);

-- Tabla Categorías
CREATE TABLE Categorias (
    id INT PRIMARY KEY IDENTITY(1,1),
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT
);

-- Tabla Productos
CREATE TABLE Productos (
    id INT PRIMARY KEY IDENTITY(1,1),
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    precio DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL,
    categoriaId INT FOREIGN KEY REFERENCES Categorias(id)
);

-- Vista para mostrar los productos con su categoría
CREATE VIEW VistaProdutosConCategorias AS
SELECT
    p.id,
    p.nombre,
    p.descripcion,
    p.precio,
    p.stock,
    c.nombre AS categoria,
    c.descripcion AS descripcionCategoria
FROM Productos p
JOIN Categorias c ON p.categoriaId = c.id;

-- Procedimiento almacenado para buscar productos por nombre
CREATE PROCEDURE BuscarProductosPorNombre
    @nombreProducto VARCHAR(100)
AS
BEGIN
    SELECT
        id,
        nombre,
        descripcion,
        precio,
        stock,
        categoriaId
    FROM Productos
    WHERE nombre LIKE '%' + @nombreProducto + '%';
END;

-- Procedimiento almacenado para obtener los 10 productos más vendidos
CREATE PROCEDURE ObtenerProductosMasVendidos
AS
BEGIN
    SELECT TOP 10
        p.id,
        p.nombre,
        p.descripcion,
        p.precio,
        p.stock,
        p.categoriaId
    FROM Productos p
    ORDER BY p.stock DESC;
END;

CREATE VIEW VistaCategoriaConProductos AS
SELECT
    c.id,
    c.nombre,
    CAST(c.descripcion AS VARCHAR(MAX)) AS descripcion,
    (SELECT COUNT(*) FROM Productos WHERE categoriaId = c.id) AS numProductos
FROM Categorias c;