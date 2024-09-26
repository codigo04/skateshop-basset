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

    public OrdenItemPK getIdPk() {
        return idPk;
    }

    public void setIdPk(OrdenItemPK idPk) {
        this.idPk = idPk;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }
}
