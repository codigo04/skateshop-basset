package com.basset_back.aplication.Controller;

import com.basset_back.dominio.aggretes.dto.Product;
import com.basset_back.dominio.ports.in.ProductServIn;
import com.basset_back.infraestructure.dao.ProductoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/v1")
@RestController
public class ProductoController {


     @Autowired
     ProductServIn productServIn;


    @GetMapping("/productos/todos")
    public ResponseEntity<List<Product>> searchProducts(){

         if (productServIn.searchProducts().size() == 0) {
             return ResponseEntity.ok().body(productServIn.searchProducts());
         }else {
             return ResponseEntity.notFound().build();
         }

    }


    @GetMapping("/producto/nombre/{nameProducto}")
    public ResponseEntity<Product> searchProductByName(@PathVariable("nameProducto") String nameProducto){
        Optional<Product> product = productServIn.searchProductByName(nameProducto);
        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/producto/categori/{nameCategori}")
    public ResponseEntity<List<Product>> searchProductByCategori(@PathVariable("nameCategori") String nameCategori){
        Optional<List<Product>> products = productServIn.searchProductByCategory(nameCategori);

        if(products.isPresent()){
            return ResponseEntity.ok(products.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping ("/producto/guardar")
    public ResponseEntity<Product> guardarProducto(@RequestBody  Product product) {
        Optional<Product> savedProduct = productServIn.createProduct(product);
        if (savedProduct.isPresent()) {
            return ResponseEntity.ok(savedProduct.get());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    // actualizar si existe el producto
    @PutMapping("/producto/actualizar")
    public ResponseEntity<Product> actualizarProducto(@RequestBody Product product) {
        Optional<Product> updatedProduct = productServIn.updateProduct(product);
        if (updatedProduct.isPresent()) {
            return ResponseEntity.ok(updatedProduct.get());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //aumentar stock de un produto
    @PutMapping("/producto/aumentar/stock")
    public ResponseEntity<Product> aumentarStock(@RequestBody Product product){
        Optional<Product> updatedProductStock = productServIn.increaseStock(product.getProductId(),product.getStock());

        if(updatedProductStock.isPresent()){
            return ResponseEntity.ok(updatedProductStock.get());
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PutMapping("/producto/decrementar/stock")
    public ResponseEntity<Product> decreseStock(@RequestBody Product product)   {
        Optional<Product> updatedProductStock =  productServIn.decreseStock(product.getProductId(),product.getStock());
        if (updatedProductStock.isPresent()) {
            return ResponseEntity.ok(updatedProductStock.get());
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }


    }

    @PutMapping("/producto/update/categori")
    public ResponseEntity<Product> updateProductCategori(@RequestBody Product product) {
        Optional<Product> updatedProductCategori =  productServIn.updateCategoriProductDefault(product.getProductId());
        if (updatedProductCategori.isPresent()) {
            return ResponseEntity.ok(updatedProductCategori.get());
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/producto/borrar/{nameProducto}")
    public void delateProduct(@PathVariable("nameProducto") String nameProducto){
        productServIn.deleteProduct(nameProducto);

    }
}
