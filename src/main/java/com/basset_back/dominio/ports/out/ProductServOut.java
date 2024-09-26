package com.basset_back.dominio.ports.out;

import com.basset_back.dominio.aggretes.dto.Product;


import java.util.List;
import java.util.Optional;

public interface ProductServOut {
   List<Product> searchProducts();
    Optional<Product>  createProduct(Product product);
    Optional<Product> updateProduct(Product product);
    Optional<Product> updateCategoriProductDefault(long productId);
    void deleteProduct(String nameProduct);
    Optional<Product> searchProductByName(String nameProduct);
    Optional<List<Product>> searchProductByCategory(String nameCategory);

    Optional<Product> increaseStock(Long productoId, int cantidad);
    Optional<Product> decreseStock(Long productoId, int cantidad);
 }
