package com.tienda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.modelo.productos;
import com.tienda.repository.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // Guardar o actualizar un producto
    public productos guardarProducto(productos producto) {
        return productoRepository.save(producto);
    }

    // Obtener todos los productos
    public List<productos> obtenerTodosProductos() {
        return productoRepository.findAll();
    }

    // Obtener un producto por su ID
    public Optional<productos> obtenerProductoPorId(Long id) {
        return productoRepository.findById(id);
    }

    // Eliminar un producto por su ID
    public void eliminarProductoPorId(Long id) {
        productoRepository.deleteById(id);
    }
}
