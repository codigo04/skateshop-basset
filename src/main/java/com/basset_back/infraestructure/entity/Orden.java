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
    @OneToMany(mappedBy = "orden")
    private List<ItemsOrden> itemsOrdens;

    //ordenes pago
    @OneToMany(mappedBy = "orden")
    private List<Pago> pagos;

}
