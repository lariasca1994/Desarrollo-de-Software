-- Crear el usuario y otorgar permisos
CREATE USER ConexionDB IDENTIFIED BY Qwerty159;
GRANT CONNECT, RESOURCE TO ConexionDBA;

-- Conectar como el nuevo usuario
CONNECT ConexionDBA/Qwerty159;

-- Crear tabla TBPagos
CREATE TABLE TBPagos (
    id_pago NUMBER PRIMARY KEY,
    monto NUMBER,
    fecha DATE,
    concepto VARCHAR2(100)
);

CREATE TABLE TBPLogin (
    id NUMBER PRIMARY KEY,
    usuario VARCHAR2(100),
    nombre VARCHAR2(100),
    password VARCHAR2(100)
);

-- Crear secuencia para la generación de IDs de pago
CREATE SEQUENCE tbpago_sequence
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

-- Procedimiento almacenado para insertar TBPagos
CREATE OR REPLACE PROCEDURE insertar_tbpago(
    monto IN NUMBER,
    fecha IN DATE,
    concepto IN VARCHAR2
) AS
BEGIN
    INSERT INTO TBPagos (id_pago, monto, fecha, concepto)
    VALUES (pago_sequence.NEXTVAL, monto, fecha, concepto);
    COMMIT;
END insertar_tbpago;

-- Procedimiento almacenado para actualizar pagos TBPagos
CREATE OR REPLACE PROCEDURE actualizar_tbpago(
    p_id_pago IN NUMBER,
    p_nuevo_monto IN NUMBER,
    p_nueva_fecha IN DATE,
    p_nuevo_concepto IN VARCHAR2
)
AS
BEGIN
    UPDATE TBPagos
    SET monto = p_nuevo_monto, 
        fecha = p_nueva_fecha,
        concepto = p_nuevo_concepto
    WHERE id_pago = p_id_pago;
    COMMIT;
END actualizar_tbpago;

-- Procedimiento almacenado para seleccionar todos los TBPagos
CREATE OR REPLACE PROCEDURE seleccionar_TBPagos(
    cur OUT SYS_REFCURSOR
) AS
BEGIN
    OPEN cur FOR
    SELECT id_pago, monto, fecha, concepto
    FROM TBPagos;
END seleccionar_TBPagos;

-- Procedimiento almacenado para validar y hacer login TBLogin
CREATE OR REPLACE PROCEDURE validar_login(
    p_usuario IN VARCHAR2,
    p_contrasena IN VARCHAR2,
    p_nombre OUT VARCHAR2
)
IS
BEGIN
    SELECT nombre
    INTO p_nombre
    FROM TBPLogin
    WHERE usuario = p_usuario
      AND password = p_contrasena;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        p_nombre := NULL;
END validar_login;

-- Procedimiento almacenado para crear usuario para login TBLogin
CREATE SEQUENCE tblogin_sequence
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- Insertar datos de muestra en la tabla TBPagos
--INSERT INTO TBPagos (id_pago, monto, fecha, concepto) VALUES (pago_sequence.NEXTVAL, 100.50, TO_DATE('2024-04-09', 'YYYY-MM-DD'), 'Pago de servicios');
--INSERT INTO TBPagos (id_pago, monto, fecha, concepto) VALUES (pago_sequence.NEXTVAL, 75.20, TO_DATE('2024-04-08', 'YYYY-MM-DD'), 'Compra de alimentos');
--INSERT INTO TBPagos (id_pago, monto, fecha, concepto) VALUES (pago_sequence.NEXTVAL, 200.00, TO_DATE('2024-04-07', 'YYYY-MM-DD'), 'Pago de alquiler');
--INSERT INTO TBPagos (id_pago, monto, fecha, concepto) VALUES (pago_sequence.NEXTVAL, 50.75, TO_DATE('2024-04-06', 'YYYY-MM-DD'), 'Compra de gasolina');
--COMMIT;


--INSERT INTO TBPLogin (id, usuario, nombre, password) VALUES (tblogin_sequence.NEXTVAL, 'usuario1@ean.com', 'Usuario 1', '123456');
--INSERT INTO TBPLogin (id, usuario, nombre, password) VALUES (tblogin_sequence.NEXTVAL, 'usuario2@ean.com', 'Usuario 2', '123456');
--INSERT INTO TBPLogin (id, usuario, nombre, password) VALUES (tblogin_sequence.NEXTVAL, 'usuario3@ean.com', 'Usuario 3', '123456');
--INSERT INTO TBPLogin (id, usuario, nombre, password) VALUES (tblogin_sequence.NEXTVAL, 'usuario4@ean.com', 'Usuario 4', '123456');
--INSERT INTO TBPLogin (id, usuario, nombre, password) VALUES (tblogin_sequence.NEXTVAL, 'lufea@ean.com', 'Luis Arias', '123456');
--COMMIT;

--UPDATE TBPagos
--    SET monto = 300, 
--        fecha = '08/04/2024',
--      concepto = 'prueba'
--    WHERE ID_PAGO = 8;
--    COMMIT;