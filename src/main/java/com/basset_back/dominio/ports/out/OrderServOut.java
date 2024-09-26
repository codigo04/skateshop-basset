package com.basset_back.dominio.ports.out;

import com.basset_back.dominio.aggretes.dto.Order;
import com.basset_back.dominio.aggretes.dto.Product;

import java.util.List;
import java.util.Optional;

public interface OrderServOut {
    Optional<Order> createOrder(Order order);

    Optional<Order> updateOrder(Order order);

    void deleteOrder(long orderId);

    Optional<Order> searchOder(long orderId);

    Optional<List<Product>> searchItemsOrder(long orderId);
}
