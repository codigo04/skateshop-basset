package com.basset_back.infraestructure.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "categoria_id")
    private Long idCategoria;

    private String nombre;
    private  String descripcion;

     //categoria producto
    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;
}
