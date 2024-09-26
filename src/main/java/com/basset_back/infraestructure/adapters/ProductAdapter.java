package com.basset_back.infraestructure.adapters;

import com.basset_back.dominio.aggretes.dto.Product;
import com.basset_back.dominio.ports.out.ProductServOut;
import com.basset_back.infraestructure.dao.CategoriaDao;
import com.basset_back.infraestructure.dao.ProductoDao;
import com.basset_back.infraestructure.entity.Categoria;
import com.basset_back.infraestructure.entity.Producto;
import com.basset_back.infraestructure.mapper.ProductMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductAdapter implements ProductServOut {

    @Autowired
    ProductoDao productoDao;
    @Autowired
    ProductMapper productMapper;

    @Autowired
    CategoriaDao categoriaDao;


    @Override
    public List<Product> searchProducts() {
       List<Producto> productos = (List<Producto>) productoDao.findAll();

        return productMapper.toProductList(productos);
    }



    @Override
    public Optional<Product> createProduct(Product product) {
        Optional<Categoria> categoria = categoriaDao.findById(product.getCategoryId());

        if (!categoria.isPresent()) {
            return Optional.empty();
        }
        product.setCategoryId(categoria.get().getIdCategoria());
        product.setDateCreation(new Timestamp(System.currentTimeMillis()));

        if (product.getStock() < 0) product.setStock(0);

        Producto producto = productoDao.save(productMapper.toProducto(product));

        return Optional.of(productMapper.toProduct(producto));
    }

    @Override
    public Optional<Product> updateProduct(Product product) {
        Optional<Producto> productoExist = productoDao.findByNombre(product.getName());

        if (!productoExist.isPresent()) {
            return Optional.empty();
        }

        Producto productoNew = productoExist.get();

        productoNew.setDescripcion(product.getDescription());
        productoNew.setImagenUrl(product.getImgUrl());
        productoNew.setNombre(product.getName());
        productoNew.setPrecio(product.getPrice());


        return Optional.of(productMapper.toProduct(productoDao.save(productoNew)));
    }



    @Override
    public Optional<Product> updateCategoriProductDefault(long productId) {
     long categoriaDefault = 7L;

         Optional<Producto> productoExist =  productoDao.findById(productId);

           if (productoExist.isPresent()) {
               Producto producto = productoExist.get();
               producto.setCategoriaId(categoriaDefault);
               productoDao.save(producto);
               return Optional.of(productMapper.toProduct(producto));
           }else



        return Optional.empty();
    }

    @Override
    public Optional<Product> increaseStock(Long productoId, int cantidad) {
        Optional<Producto> productoExist = productoDao.findById(productoId);

        if (!productoExist.isPresent()) return Optional.empty();
        Producto producto = productoExist.get();

        producto.setStock(producto.getStock()  + cantidad);

        return Optional.of(productMapper.toProduct(productoDao.save(producto)));
    }

    @Override
    public Optional<Product> decreseStock(Long productoId, int cantidad) {
        Optional<Producto> productoExist = productoDao.findById(productoId);

        if (!productoExist.isPresent()) return Optional.empty();
        Producto producto = productoExist.get();


        producto.setStock(producto.getStock()  - cantidad);


        productoDao.save(producto);
        return Optional.of(productMapper.toProduct(productoDao.save(producto)));
    }

    @Transactional
    @Override
    public void deleteProduct(String nameProduct) {

          if(searchProductByName(nameProduct).isPresent())  productoDao.deleteByNombre(nameProduct);

    }

    @Override
    public Optional<Product> searchProductByName(String nameProduct) {

        Optional<Producto> producto=   productoDao.findByNombre(nameProduct);

        return Optional.of(productMapper.toProduct(producto.get()));
    }

    @Override
    public Optional<List<Product>> searchProductByCategory(String nameCategory) {
        Optional<List<Producto>> productos = productoDao.findAllByCategoria(nameCategory);

        return productos.map(productMapper::toProductList);
    }


}
