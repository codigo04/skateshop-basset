package com.basset_back.dominio.aggretes.dto;

import com.basset_back.infraestructure.entity.Orden;
import com.basset_back.infraestructure.entity.OrdenItemPK;
import com.basset_back.infraestructure.entity.Producto;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;

public class ItemsOrder {

    private OrdenItemPK idPk;

    private Integer cantidad;


    private BigDecimal price;


    private Producto product;


    private Orden order;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Producto getProduct() {
        return product;
    }

    public void setProduct(Producto product) {
        this.product = product;
    }

    public Orden getOrder() {
        return order;
    }

    public void setOrder(Orden order) {
        this.order = order;
    }
}
