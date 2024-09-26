package com.basset_back.dominio.aggretes.dto;

import com.basset_back.infraestructure.entity.CarritosItemPK;


public class ItemsCar {
    private CarsItemPK idPrimarykey;
    private int amount;


    public CarsItemPK getIdPrimarykey() {
        return idPrimarykey;
    }

    public void setIdPrimarykey(CarsItemPK idPrimarykey) {
        this.idPrimarykey = idPrimarykey;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
