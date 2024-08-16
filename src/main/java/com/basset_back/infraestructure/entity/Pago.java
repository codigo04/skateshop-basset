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
}
