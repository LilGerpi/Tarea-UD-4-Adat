CREATE DATABASE tienda;

USE tienda;

CREATE TABLE productos (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(255) NOT NULL,
  precio DOUBLE NOT NULL,
  cantidad INT NOT NULL,
  categoria VARCHAR(255)
);
