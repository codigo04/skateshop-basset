package com.basset_back.dominio.impl;

import com.basset_back.dominio.aggretes.dto.Car;
import com.basset_back.dominio.aggretes.dto.Product;
import com.basset_back.dominio.ports.in.CarServIn;
import com.basset_back.dominio.ports.out.CarServOut;
import com.basset_back.infraestructure.entity.Carrito;
import com.basset_back.infraestructure.entity.ItemsCarrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServImpl implements CarServIn {

    @Autowired
    public CarServOut carServOut;

    @Override
    public Optional<Car> createCar(Car car) {

        return carServOut.createCar(car);
    }

    @Override
    public Optional<Car> addProductToCar(long carId, Product product, int cantidad) {


        return carServOut.addProductToCar(carId, product, cantidad);
    }


    @Override
    public void removeProductFromCar(Long carId, String productName) {
        carServOut.removeProductFromCar(carId, productName);
    }

    @Override
    public void removeAllProductsFromCar(Long carId) {
        carServOut.removeAllProductsFromCar(carId);
    }

    @Override
    public Optional<List<ItemsCarrito>> searchProductsByCarId(long carId) {


        return carServOut.searchProductsByCarId(carId);
    }

    @Override
    public Optional<ItemsCarrito> searchProductByName(long carId, String productName) {
        return carServOut.searchProductByName(carId,productName);
    }

    @Override
    public Optional<ItemsCarrito> increaseProductQuantity(long carId, long productId, int quantity) {
        return carServOut.increaseProductQuantity(carId,productId,quantity);
    }

    @Override
    public Optional<ItemsCarrito> decreaseProductQuantity(long carId, long productId, int quantity) {
        return carServOut.increaseProductQuantity(carId,productId,quantity);
    }


}
