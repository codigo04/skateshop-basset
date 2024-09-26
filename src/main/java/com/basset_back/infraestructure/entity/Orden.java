package com.basset_back.infraestructure.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "oredenes")
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orden")
    private Long idOrden;

    @Column(name = "usuario_id")
    private Long idUsuario;

    @Column(name = "precio_total")
    private BigDecimal precioTotal;

    private String estado;

    @Column(name = "fecha_creacion")
    private Timestamp fechaCreacion;


    //ordenes usuario
    @ManyToOne
    @JoinColumn(name = "usuario_id", insertable = false, updatable = false)
    private Usuario usuario;

   //ordenes
    @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL)
    private List<ItemsOrden> itemsOrdens;

    //ordenes pago
    @OneToMany(mappedBy = "orden")
    private List<Pago> pagos;


    public Long getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Long idOrden) {
        this.idOrden = idOrden;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public BigDecimal getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(BigDecimal precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<ItemsOrden> getItemsOrdens() {
        return itemsOrdens;
    }

    public void setItemsOrdens(List<ItemsOrden> itemsOrdens) {
        this.itemsOrdens = itemsOrdens;
    }

    public List<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }
}
