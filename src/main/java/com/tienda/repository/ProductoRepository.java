package com.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.modelo.productos;

public interface ProductoRepository extends JpaRepository<productos, Long> {
    // Aquí puedes definir métodos personalizados si es necesario
}
