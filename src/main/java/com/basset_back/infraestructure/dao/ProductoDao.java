package com.basset_back.infraestructure.dao;

import com.basset_back.infraestructure.entity.Categoria;
import com.basset_back.infraestructure.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductoDao extends CrudRepository<Producto,Long> {


    Optional<Producto> findByNombre(String nombreProduct);
    void deleteByNombre(String nombre);

   @Query("SELECT p FROM Producto p WHERE p.categoria.nombre = :nameCategoria")
    Optional<List<Producto>> findAllByCategoria(@Param("nameCategoria") String nameCategoria);
}
