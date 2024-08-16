package com.basset_back.infraestructure.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "carritos")
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carrito_id")
    private Long idCarrito;

    @Column(name = "usuario_id")
    private Long idUsuario;

    @Column(name = "fecha_creacion")
    private Timestamp fechaCreacion;


    //carrito usuario
    @ManyToOne
    @JoinColumn(name = "usuario_id", insertable = false, updatable = false)
    private Usuario usuario;


    //carriot items carrito
    @OneToMany(mappedBy = "carrito")
    private List<ItemsCarrito> itemsCarritos;



}
