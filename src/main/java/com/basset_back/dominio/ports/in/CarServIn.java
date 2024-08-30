package com.basset_back.dominio.ports.in;

import com.basset_back.dominio.aggretes.dto.Car;
import com.basset_back.infraestructure.entity.Carrito;

public interface CarServIn {

    Car createCart(Carrito carrito);

    void addItemToCart(Long cartId, Long productId, int quantity);


    void removeItemFromCart(Long cartId, Long productId);

    Car getCartById(Long cartId);

    Car getCartForUser(Long userId);

}
