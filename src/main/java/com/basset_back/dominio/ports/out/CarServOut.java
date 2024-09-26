package com.basset_back.dominio.ports.out;

import com.basset_back.dominio.aggretes.dto.Car;
import com.basset_back.dominio.aggretes.dto.Product;
import com.basset_back.dominio.aggretes.dto.User;
import com.basset_back.infraestructure.entity.ItemsCarrito;

import java.util.List;
import java.util.Optional;

public interface CarServOut {
    // Crear un nuevo carrito
    Optional<Car> createCar(Car car);

    // Añadir y eliminar productos de un carrito
    Optional<Car> addProductToCar(long carId, Product product, int cantidad);
    void removeProductFromCar(long carId, String productName);
    void removeAllProductsFromCar(long carId);

    // Buscar productos en un carrito
    Optional<List<ItemsCarrito>> searchProductsByCarId(long carId);
    Optional<ItemsCarrito> searchProductByName(long carId, String productName);

    // Ajustar la cantidad de un producto en un carrito
    Optional<ItemsCarrito> increaseProductQuantity(long carId, long productId, int quantity);
    Optional<ItemsCarrito> decreaseProductQuantity(long carId, long productId, int quantity);
}
