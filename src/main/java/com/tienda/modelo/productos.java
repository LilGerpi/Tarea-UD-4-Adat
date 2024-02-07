package com.tienda.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "productos") // Asegura que la entidad se mapee a la tabla 'productos'
public class productos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nombre", nullable = false, length = 255)
	private String nombre;

	@Column(name = "precio", nullable = false)
	private Double precio;

	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;

	@Column(name = "categoria", length = 255)
	private String categoria;

	// Constructores
	public productos() {
	}

	public productos(String nombre, Double precio, Integer cantidad, String categoria) {
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
		this.categoria = categoria;
	}

	// Getters y setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
