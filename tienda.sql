CREATE DATABASE tienda;

USE tienda;

CREATE TABLE productos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(255) NOT NULL,
  precio DOUBLE NOT NULL,
  cantidad INT NOT NULL,
  categoria VARCHAR(255)
);

INSERT INTO `productos` (`id`, `nombre`, `precio`, `cantidad`, `categoria`) VALUES (NULL, 'Patatas', '2.00', '1', 'Verduras');