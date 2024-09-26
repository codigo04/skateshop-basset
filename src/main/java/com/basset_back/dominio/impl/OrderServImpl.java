package com.basset_back.dominio.impl;

import com.basset_back.dominio.aggretes.dto.Order;
import com.basset_back.dominio.aggretes.dto.Product;
import com.basset_back.dominio.ports.in.OrderServIn;
import com.basset_back.dominio.ports.out.OrderServOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServImpl implements OrderServIn {


    @Autowired
    OrderServOut orderServOut;


    @Override
    public Optional<Order> createOrder(Order order) {

        orderServOut.createOrder(order);

        return Optional.of(orderServOut.createOrder(order).get());
    }

    @Override
    public Optional<Order> updateOrder(Order order) {

        return Optional.of(orderServOut.updateOrder(order).get());
    }

    @Override
    public void deleteOrder(long orderId) {
        orderServOut.deleteOrder(orderId);
    }

    @Override
    public Optional<Order> searchOder(long orderId) {

        orderServOut.searchOder(orderId);
        return Optional.of(orderServOut.searchOder(orderId).get());
    }

    @Override
    public Optional<List<Product>> searchItemsOrder(long orderId) {
        orderServOut.searchItemsOrder(orderId);
        return Optional.of(orderServOut.searchItemsOrder(orderId).get());
    }
}
