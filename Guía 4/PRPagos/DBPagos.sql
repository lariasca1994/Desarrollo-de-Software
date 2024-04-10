-- Crear el usuario y otorgar permisos
--CREATE USER BDPagos IDENTIFIED BY Qwerty159;
--GRANT CONNECT, RESOURCE TO BDPagos;

-- Conectar como el nuevo usuario
--CONNECT ConexionDBA/Qwerty159;

-- Crear tabla TBPagos
CREATE TABLE TBPagos (
    id_pago NUMBER PRIMARY KEY,
    monto NUMBER,
    fecha DATE,
    concepto VARCHAR2(100)
);

CREATE TABLE TBPLogin (
    id NUMBER PRIMARY KEY,
    usuario VARCHAR2(50),
    nombre VARCHAR2(30),
    password VARCHAR2(30)
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

-- Procedimiento almacenado para actualizar un pago
CREATE OR REPLACE PROCEDURE actualizar_tbpago(
    id_pago IN NUMBER,
    nuevo_monto IN NUMBER,
    nueva_fecha IN DATE
) AS
BEGIN
    UPDATE TBPagos
    SET monto = nuevo_monto, fecha = nueva_fecha
    WHERE id_pago = id_pago;
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

CREATE OR REPLACE PROCEDURE crear_usuario_app(
    p_usuario IN VARCHAR2,
    p_nombre IN VARCHAR2,
    p_contrasena IN VARCHAR2
)
IS
BEGIN
    INSERT INTO TBPLogin (usuario, nombre, password)
    VALUES (p_usuario, p_nombre, p_contrasena);
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error al crear el usuario: ' || SQLCODE || ' - ' || SQLERRM);
END crear_usuario_app;

CREATE OR REPLACE PROCEDURE recuperar_contrasena(
    p_correo IN VARCHAR2,
    p_nueva_contrasena IN VARCHAR2
)
IS
    v_usuario VARCHAR2(50);
BEGIN
    SELECT usuario
    INTO v_usuario
    FROM TBPLogin
    WHERE usuario = p_correo;

    UPDATE TBPLogin
    SET password = p_nueva_contrasena
    WHERE usuario = v_usuario;

    COMMIT;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('No se encontró el usuario con el correo especificado.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error al recuperar la contraseña: ' || SQLCODE || ' - ' || SQLERRM);
END recuperar_contrasena;

-- Insertar datos de muestra en la tabla TBPagos
--INSERT INTO TBPagos (id_pago, monto, fecha, concepto) VALUES (pago_sequence.NEXTVAL, 100.50, TO_DATE('2024-04-09', 'YYYY-MM-DD'), 'Pago de servicios');
--INSERT INTO TBPagos (id_pago, monto, fecha, concepto) VALUES (pago_sequence.NEXTVAL, 75.20, TO_DATE('2024-04-08', 'YYYY-MM-DD'), 'Compra de alimentos');
--INSERT INTO TBPagos (id_pago, monto, fecha, concepto) VALUES (pago_sequence.NEXTVAL, 200.00, TO_DATE('2024-04-07', 'YYYY-MM-DD'), 'Pago de alquiler');
--INSERT INTO TBPagos (id_pago, monto, fecha, concepto) VALUES (pago_sequence.NEXTVAL, 50.75, TO_DATE('2024-04-06', 'YYYY-MM-DD'), 'Compra de gasolina');
--COMMIT;

CREATE SEQUENCE tblogin_sequence
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

--INSERT INTO TBPLogin (id, usuario, nombre, password) VALUES (tblogin_sequence.NEXTVAL, 'usuario1@ean.com', 'Usuario 1', '123456');
--INSERT INTO TBPLogin (id, usuario, nombre, password) VALUES (tblogin_sequence.NEXTVAL, 'usuario2@ean.com', 'Usuario 2', '123456');
--INSERT INTO TBPLogin (id, usuario, nombre, password) VALUES (tblogin_sequence.NEXTVAL, 'usuario3@ean.com', 'Usuario 3', '123456');
--INSERT INTO TBPLogin (id, usuario, nombre, password) VALUES (tblogin_sequence.NEXTVAL, 'usuario4@ean.com', 'Usuario 4', '123456');
--INSERT INTO TBPLogin (id, usuario, nombre, password) VALUES (tblogin_sequence.NEXTVAL, 'lufea@ean.com', 'Luis Arias', '123456');
--COMMIT;