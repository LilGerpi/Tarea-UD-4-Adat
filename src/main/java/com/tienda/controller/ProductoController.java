package com.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.modelo.productos;
import com.tienda.service.ProductoService;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*") // Habilitar CORS para el puerto 8080
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	// Crear un nuevo producto
	@PostMapping("/crear")
	public productos crearProducto(@RequestBody productos producto) {
		return productoService.guardarProducto(producto);
	}

	// Obtener todos los productos
	@GetMapping("/listar")
	public List<productos> listarProductos() {
		return productoService.obtenerTodosProductos();
	}

	// Obtener un producto por su ID
	@GetMapping("/{id}")
	public ResponseEntity<productos> obtenerProductoPorId(@PathVariable Long id) {
		return productoService.obtenerProductoPorId(id).map(producto -> ResponseEntity.ok().body(producto))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	// Actualizar un producto
	@PutMapping("/{id}")
	public ResponseEntity<productos> actualizarProducto(@PathVariable Long id, @RequestBody productos detallesProducto) {
		return productoService.obtenerProductoPorId(id).map(productoExistente -> {
			productoExistente.setNombre(detallesProducto.getNombre());
			productoExistente.setPrecio(detallesProducto.getPrecio());
			productoExistente.setCantidad(detallesProducto.getCantidad());
			productoExistente.setCategoria(detallesProducto.getCategoria());
			productos productoActualizado = productoService.guardarProducto(productoExistente);
			return ResponseEntity.ok().body(productoActualizado);
		}).orElseGet(() -> ResponseEntity.notFound().build());
	}

	// Eliminar un producto
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarProducto(@PathVariable Long id) {
		return productoService.obtenerProductoPorId(id).map(producto -> {
			productoService.eliminarProductoPorId(id);
			return ResponseEntity.ok().build();
		}).orElseGet(() -> ResponseEntity.notFound().build());
	}
}