package com.basset_back.dominio.aggretes.dto;

import jakarta.persistence.Column;

public class CarsItemPK {

    private long idCar;
    private long idProduct;

    public long getIdCar() {
        return idCar;
    }

    public void setIdCar(long idCar) {
        this.idCar = idCar;
    }

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }
}
