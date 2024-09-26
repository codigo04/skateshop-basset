package com.basset_back.infraestructure.dao;

import com.basset_back.infraestructure.entity.ItemsOrden;
import com.basset_back.infraestructure.entity.Orden;
import com.basset_back.infraestructure.entity.OrdenItemPK;
import com.basset_back.infraestructure.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemsOrdenDao extends JpaRepository<ItemsOrden, OrdenItemPK> {

    @Query("SELECT p FROM Producto p JOIN ItemsOrden ip ON p.idProducto = ip.producto.idProducto WHERE ip.orden.idOrden = :ordenId")
    List<Producto> findProductosByOrdenId(@Param("ordenId") long idOrden);





}
