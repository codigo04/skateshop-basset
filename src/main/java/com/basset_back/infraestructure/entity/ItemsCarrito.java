package com.basset_back.infraestructure.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "items_carrito")
public class ItemsCarrito {

    @EmbeddedId
    private CarritosItemPK idPk;


    private Integer cantidad;

     //items_carrito a carritos
    @ManyToOne
    @JoinColumn(name = "carrito_id", updatable = false,insertable = false)
    private Carrito carrito;


    //items_carrito a productos
    @ManyToOne
    @JoinColumn(name = "producto_id", insertable = false, updatable = false)
    private  Producto producto;

}
