package com.basset_back.dominio.aggretes.dto;

import com.basset_back.infraestructure.entity.ItemsOrden;
import com.basset_back.infraestructure.entity.Usuario;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class Order {

    private Long idOrder;
    private Long idUser;
    private BigDecimal totalPrice;
    private String estate;
    private Timestamp dateCreation;
    //ordenes usuario
    private Usuario user;
    //ordenes
    private List<ItemsOrden> itemsOrders;

    public List<ItemsOrden> getItemsOrders() {
        return itemsOrders;
    }

    public void setItemsOrders(List<ItemsOrden> itemsOrders) {
        this.itemsOrders = itemsOrders;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Timestamp getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Timestamp dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getEstate() {
        return estate;
    }

    public void setEstate(String estate) {
        this.estate = estate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }
}
