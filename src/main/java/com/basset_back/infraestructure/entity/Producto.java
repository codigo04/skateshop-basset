package com.basset_back.infraestructure.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producto_id")
    private  Long idProducto;

    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Column(name = "categoria_id")
    private Long categoriaId;

    @Column(name = "imagen_url", length = 255)
    private String imagenUrl;

    @Column(name = "fecha_creacion")
    private Timestamp fechaCreacion;


    //productos items_orden
    @OneToMany(mappedBy = "producto")
    private List<ItemsOrden> itemsOrdens;

   //producto items_carrito
    @OneToMany(mappedBy = "producto")
    private List<ItemsCarrito> itemsCarritos;

   //producto categoria
    @ManyToOne
    @JoinColumn(name = "categoria_id", insertable = false, updatable = false)
    private Categoria categoria;

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaID) {
        this.categoriaId = categoriaID;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public List<ItemsOrden> getItemsOrdens() {
        return itemsOrdens;
    }

    public void setItemsOrdens(List<ItemsOrden> itemsOrdens) {
        this.itemsOrdens = itemsOrdens;
    }

    public List<ItemsCarrito> getItemsCarritos() {
        return itemsCarritos;
    }

    public void setItemsCarritos(List<ItemsCarrito> itemsCarritos) {
        this.itemsCarritos = itemsCarritos;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
