package com.basset_back.infraestructure.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "pago")
public class Pago {

    @Id
    @Column(name = "id_Pago")
    private Long idPago;

    @Column(name = "id_orden")
    private Long idOrden;


    private BigDecimal monto;

    @Column(name = "fecha_pago")
    private Timestamp fechaPago;

    private String estado;


    @Column(name = "metodo_pago")
    private String  metodoPago;



    //pago ordenes
    @ManyToOne
    @JoinColumn(name = "id_orden", updatable = false,insertable = false)
    private Orden orden;


    public Long getIdPago() {
        return idPago;
    }

    public void setIdPago(Long idPago) {
        this.idPago = idPago;
    }

    public Long getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Long idOrden) {
        this.idOrden = idOrden;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Timestamp getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Timestamp fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }
}
