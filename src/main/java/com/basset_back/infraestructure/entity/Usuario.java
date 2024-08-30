package com.basset_back.infraestructure.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

   @ManyToMany(fetch = FetchType.EAGER)
   @JoinTable(name = "usuario_rol",
           joinColumns = @JoinColumn(name = "id_usuario"),
           inverseJoinColumns = @JoinColumn(name = "id_rol"))
   private Set<Rol> rolesUsuario = new HashSet<>();

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getNumeroDoc() {
        return numeroDoc;
    }

    public void setNumeroDoc(String numeroDoc) {
        this.numeroDoc = numeroDoc;
    }

    public List<Orden> getOrdenList() {
        return ordenList;
    }

    public void setOrdenList(List<Orden> ordenList) {
        this.ordenList = ordenList;
    }

    public List<Carrito> getCarritoList() {
        return carritoList;
    }

    public void setCarritoList(List<Carrito> carritoList) {
        this.carritoList = carritoList;
    }

    public Set<Rol> getRolesUsuario() {
        return rolesUsuario;
    }

    public void setRolesUsuario(Set<Rol> rolesUsuario) {
        this.rolesUsuario = rolesUsuario;
    }
}
