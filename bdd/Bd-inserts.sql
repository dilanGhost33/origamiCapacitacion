CREATE TABLE cliente (
    id_cliente SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(255),
    telefono VARCHAR(15),
    email VARCHAR(100)
);
CREATE TABLE producto (
    id_producto SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    precio NUMERIC(10, 2) NOT NULL,
    stock INT NOT NULL
);
CREATE TABLE factura (
    id_factura SERIAL PRIMARY KEY,
    id_cliente INT REFERENCES cliente(id_cliente),
    fecha DATE NOT NULL,
    total NUMERIC(10, 2) NOT NULL
);
CREATE TABLE detalle_factura (
    id_detalle SERIAL PRIMARY KEY,
    id_factura INT REFERENCES factura(id_factura),
    id_producto INT REFERENCES producto(id_producto),
    cantidad INT NOT NULL,
    precio_unitario NUMERIC(10, 2) NOT NULL,
    subtotal NUMERIC(10, 2) NOT NULL
);

--insersion de datos 
INSERT INTO cliente (nombre, direccion, telefono, email) VALUES
('Juan Pérez', 'Calle Falsa 123, Ciudad X', '555-1234', 'juan.perez@example.com'),
('María García', 'Av. Siempre Viva 456, Ciudad Y', '555-5678', 'maria.garcia@example.com'),
('Carlos López', 'Calle 8, Ciudad Z', '555-8765', 'carlos.lopez@example.com');

INSERT INTO producto (nombre, descripcion, precio, stock) VALUES
('Laptop', 'Laptop de 15 pulgadas con 8GB RAM y 256GB SSD', 750.00, 10),
('Teléfono', 'Teléfono móvil con pantalla de 6.5 pulgadas y 128GB de almacenamiento', 500.00, 25),
('Tablet', 'Tablet de 10 pulgadas con 64GB de almacenamiento', 300.00, 15),
('Monitor', 'Monitor de 24 pulgadas Full HD', 200.00, 20),
('Teclado', 'Teclado mecánico retroiluminado', 80.00, 50);
INSERT INTO factura (id_cliente, fecha, total) VALUES
(1, '2024-08-20', 1250.00),
(2, '2024-08-21', 300.00),
(3, '2024-08-22', 780.00);

INSERT INTO detalle_factura (id_factura, id_producto, cantidad, precio_unitario, subtotal) VALUES
(1, 1, 1, 750.00, 750.00),
(1, 2, 1, 500.00, 500.00),
(2, 3, 1, 300.00, 300.00),
(3, 4, 2, 200.00, 400.00),
(3, 5, 1, 80.00, 80.00);

select * from factura;
select * from detalle_factura;
  

SELECT 
    f.id_factura,
    f.fecha,
    f.total,
    c.nombre AS nombre_cliente,
    df.cantidad,
    df.precio_unitario,
    df.subtotal,
    p.nombre AS nombre_producto
FROM 
    factura f
JOIN 
    cliente c ON f.id_cliente = c.id_cliente
JOIN 
    detalle_factura df ON f.id_factura = df.id_factura
JOIN 
    producto p ON df.id_producto = p.id_producto
WHERE 
    f.id_factura = 1;