package com.basset_back.dominio.aggretes.dto;

import com.basset_back.infraestructure.entity.Usuario;

import java.sql.Timestamp;

public class Car {

    private Long idCar;

    private Long idUsur;

    private Timestamp dateCreation;

    private Usuario user;


    public Long getIdCar() {
        return idCar;
    }

    public void setIdCar(Long idCar) {
        this.idCar = idCar;
    }

    public Long getIdUsur() {
        return idUsur;
    }

    public void setIdUsur(Long idUsur) {
        this.idUsur = idUsur;
    }

    public Timestamp getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Timestamp dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
}
