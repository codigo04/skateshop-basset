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

    @JoinColumn(name = "categoria_id", nullable = false)
    private Integer categoriaID;

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
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
