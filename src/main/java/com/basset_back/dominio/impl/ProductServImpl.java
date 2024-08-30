package com.basset_back.dominio.impl;

import com.basset_back.dominio.aggretes.dto.Product;
import com.basset_back.dominio.ports.in.ProductServIn;
import com.basset_back.dominio.ports.out.ProductServOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServImpl implements ProductServIn {

    @Autowired
    ProductServOut productServOut;


    @Override
    public Optional<Product> createProduct(Product product) {


        return productServOut.createProduct(product);
    }

    @Override
    public Optional<Product> updateProduct(Product product) {


        return productServOut.updateProduct(product);
    }

    @Override
    public void deleteProduct(String nameProduct) {
           productServOut.deleteProduct(nameProduct);
    }

    @Override
    public Optional<Product> searchProductByName(String nameProduct) {


        return productServOut.searchProductByName(nameProduct);
    }

    @Override
    public Optional<List<Product>> searchProductByCategory(String nameCategory) {
        return productServOut.searchProductByCategory(nameCategory);
    }

    @Override
    public Optional<Product> increaseStock(Long productoId, int cantidad) {
        return productServOut.increaseStock(productoId,cantidad);
    }

    @Override
    public Optional<Product> decreseStock(Long productoId, int cantidad) {
        return productServOut.decreseStock(productoId,cantidad);
    }
}
