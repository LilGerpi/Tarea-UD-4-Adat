package com.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // Aquí puedes definir métodos personalizados si es necesario
}
