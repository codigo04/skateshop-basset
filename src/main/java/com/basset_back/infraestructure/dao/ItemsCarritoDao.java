package com.basset_back.infraestructure.dao;

import com.basset_back.infraestructure.entity.Carrito;
import com.basset_back.infraestructure.entity.CarritosItemPK;
import com.basset_back.infraestructure.entity.ItemsCarrito;
import com.basset_back.infraestructure.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemsCarritoDao extends JpaRepository<ItemsCarrito, CarritosItemPK> {


    void deleteByCarrito_IdCarrito(Long carritoId);
    Optional<List<ItemsCarrito>> findAllByCarrito_IdCarrito(Long carritoId);

    Optional<ItemsCarrito> findByProducto_Nombre(String nombreProducto);
}
