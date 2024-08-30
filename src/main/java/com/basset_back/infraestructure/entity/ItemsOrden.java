package com.basset_back.infraestructure.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "items_orden")
public class ItemsOrden {

    @EmbeddedId
    private OrdenItemPK idPk;

    private Integer cantidad;


    private BigDecimal precio;

//items_orden producto
    @ManyToOne
    @JoinColumn(name = "producto_id", insertable = false,updatable = false)
    private Producto producto;

//items_orden  orden
    @ManyToOne
    @JoinColumn(name ="id_orden", insertable = false, updatable = false)
    private Orden orden;


}
