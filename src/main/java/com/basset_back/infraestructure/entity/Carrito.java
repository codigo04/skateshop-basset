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


    public Long getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(Long idCarrito) {
        this.idCarrito = idCarrito;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
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

    public List<ItemsCarrito> getItemsCarritos() {
        return itemsCarritos;
    }

    public void setItemsCarritos(List<ItemsCarrito> itemsCarritos) {
        this.itemsCarritos = itemsCarritos;
    }
}
