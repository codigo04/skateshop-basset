package com.basset_back.infraestructure.entity;


import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

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

    public CarritosItemPK getIdPk() {
        return idPk;
    }

    public void setIdPk(CarritosItemPK idPk) {
        this.idPk = idPk;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }


    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
