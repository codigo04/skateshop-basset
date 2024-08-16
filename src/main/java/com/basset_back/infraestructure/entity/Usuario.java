package com.basset_back.infraestructure.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long idUsuario;

    private String nombre;
    private String apellido;
    private String gmail;
    private String contrasena;
    private  String tipoDoc;
    private String numeroDoc;

   @OneToMany(mappedBy = "usuario")
   private List<Orden> ordenList;

   @OneToMany(mappedBy = "usuario")
   private List<Carrito> carritoList;
}
