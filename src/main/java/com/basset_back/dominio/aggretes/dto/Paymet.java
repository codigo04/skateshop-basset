package com.basset_back.dominio.aggretes.dto;

import com.basset_back.infraestructure.entity.Orden;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Paymet {

    private long idPaymet;
    private long idOrder;
    private BigDecimal amount;
    private Timestamp datePaymet;
    private String estate;
    private String  methodPaymet;
    private Orden Order;

    public long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(long idOrder) {
        this.idOrder = idOrder;
    }

    public long getIdPaymet() {
        return idPaymet;
    }

    public void setIdPaymet(long idPaymet) {
        this.idPaymet = idPaymet;
    }



    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Timestamp getDatePaymet() {
        return datePaymet;
    }

    public void setDatePaymet(Timestamp datePaymet) {
        this.datePaymet = datePaymet;
    }

    public String getEstate() {
        return estate;
    }

    public void setEstate(String estate) {
        this.estate = estate;
    }

    public String getMethodPaymet() {
        return methodPaymet;
    }

    public void setMethodPaymet(String methodPaymet) {
        this.methodPaymet = methodPaymet;
    }

    public Orden getOrder() {
        return Order;
    }

    public void setOrder(Orden order) {
        Order = order;
    }
}
