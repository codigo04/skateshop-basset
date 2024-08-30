package com.basset_back.dominio.impl;

import com.basset_back.dominio.aggretes.dto.Car;
import com.basset_back.dominio.ports.in.CarServIn;
import com.basset_back.infraestructure.entity.Carrito;

public class CarServImpl implements CarServIn {

    //public CarritoServOut carritoServOut;

    @Override
    public Car createCart(Carrito carrito) {
        return null;
    }

    @Override
    public void addItemToCart(Long cartId, Long productId, int quantity) {

    }

    @Override
    public void removeItemFromCart(Long cartId, Long productId) {

    }

    @Override
    public Car getCartById(Long cartId) {
        return null;
    }

    @Override
    public Car getCartForUser(Long userId) {
        return null;
    }
}
